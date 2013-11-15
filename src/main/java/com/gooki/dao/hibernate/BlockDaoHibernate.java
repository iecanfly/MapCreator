package com.gooki.dao.hibernate;

import com.gooki.dao.BlockDao;
import com.gooki.model.Block;
import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.webapp.exception.BlockExistsException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("blockDao")
public class BlockDaoHibernate extends GenericDaoHibernate<Block, Long> implements BlockDao {

    public BlockDaoHibernate() {
		super(Block.class);
	}

	@SuppressWarnings("unchecked")
	public List<Block> findByCongName(String cong) {
		return getSession().createCriteria(Block.class).add(Restrictions.eq("cong", cong)).addOrder(Order.asc("block")).addOrder(Order.asc("number")).list();
	}

    public Block saveBlockAfterDuplicateCheck(Block block) throws BlockExistsException {
        Block testBlock = (Block) getSession().createCriteria(Block.class).
                            add(Restrictions.eq("cong", block.getCong())).
                            add(Restrictions.eq("block", block.getBlock())).
                            add(Restrictions.eq("number", block.getNumber())).uniqueResult();

        if(testBlock != null)  {
            throw new BlockExistsException();
        }

        getSession().save(block);

        return block;
    }

    public void update(Block block) {
        getSession().update(block);
    }

    @Override
    public List<Block> findBlocks(String congName, String[] blockArray) {
        Criteria allCriteria = getSession().createCriteria(Block.class);
        allCriteria.add(Restrictions.conjunction().add(Restrictions.eq("cong", congName)));
        Disjunction blockOR = Restrictions.disjunction();

        for(String blockInfo : blockArray) {
            String blockName = blockInfo.split(TerritoryConstants.SEPERATOR.getValue())[0];
            Integer blockNumber = new Integer(blockInfo.split(TerritoryConstants.SEPERATOR.getValue())[1]);
            Criterion blockNameCriterion = Restrictions.eq("block", blockName);
            Criterion blockNumberCriterion = Restrictions.eq("number", blockNumber);
            blockOR.add(Restrictions.conjunction().add(blockNameCriterion).add(blockNumberCriterion));
        }

        allCriteria.add(blockOR);
        allCriteria.addOrder(Order.asc("block"));
        allCriteria.addOrder(Order.asc("number"));

        return (List<Block>) allCriteria.list();

    }

    @Override
    public Block findBlock(String congName, String blockName, String blockNumber) {
        return (Block) getSession().createCriteria(Block.class).
                add(Restrictions.eq("cong", congName)).
                add(Restrictions.eq("block", blockName)).
                add(Restrictions.eq("number", new Integer(blockNumber))).uniqueResult();
    }

}
