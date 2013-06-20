package com.gooki.dao;

import java.util.List;

import com.gooki.webapp.exception.BlockExistsException;
import com.gooki.dao.GenericDao;
import com.gooki.model.Block;


public interface BlockDao extends GenericDao<Block, Long>{
	List<Block> findByCongName(String cong);
    Block saveBlockAfterDuplicateCheck(Block block) throws BlockExistsException;
    void update(Block block);
    List<Block> findBlocks(String congName, String[] blockArray);
    Block findBlock(String congName, String blockName, String blockNumber);
}
