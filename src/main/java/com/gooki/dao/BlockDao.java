package com.gooki.dao;

import com.gooki.model.Block;
import com.gooki.webapp.exception.BlockExistsException;

import java.util.List;


public interface BlockDao extends GenericDao<Block, Long>{
	List<Block> findByCongName(String cong);
    Block saveBlockAfterDuplicateCheck(Block block) throws BlockExistsException;
    void update(Block block);
    List<Block> findBlocks(String congName, String[] blockArray);
    Block findBlock(String congName, String blockName, String blockNumber);
}
