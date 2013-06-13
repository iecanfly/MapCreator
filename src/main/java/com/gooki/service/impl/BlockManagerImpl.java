package com.gooki.service.impl;

import com.gooki.dao.BlockDao;
import com.gooki.webapp.exception.BlockExistsException;
import com.gooki.model.Block;
import com.gooki.service.BlockManager;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("blockManager")
public class BlockManagerImpl extends GenericManagerImpl<Block, Long> implements BlockManager{
    private BlockDao blockDao;

    @Autowired
    public BlockManagerImpl(BlockDao blockDao) {
        super(blockDao);
        this.blockDao = blockDao;
    }

	public void setBlockDao(BlockDao blockDao) {
        this.blockDao = blockDao;
	}

	public List<Block> getBlocksByCongName(String congName) {
		return blockDao.findByCongName(congName);
	}

    @Override
    public List<Block> getBlocks(String congName, String[] blockArray) {
        return blockDao.findBlocks(congName, blockArray);
    }

    @Override
    public Block getBlock(String congName, String blockName, String blockNumber) {
        return blockDao.findBlock(congName, blockName, blockNumber);
    }

    public Block saveBlock(Block block) throws BlockExistsException {
        blockDao.saveBlockAfterDuplicateCheck(block);
        return block;
	}

	public void removeBlock(Block block) {
		// TODO Auto-generated method stub
		
	}

	public void removeBlock(String blockId) {
		// TODO Auto-generated method stub
		
	}

	public List<Block> search(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
