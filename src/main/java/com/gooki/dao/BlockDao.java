package com.gooki.dao;

import java.util.List;

import com.gooki.webapp.exception.BlockExistsException;
import org.appfuse.dao.GenericDao;
import com.gooki.model.Block;


public interface BlockDao extends GenericDao<Block, Long>{
	List<Block> findByCongName(String cong);
    Block saveBlockAfterDuplicateCheck(Block block) throws BlockExistsException;
    List<Block> findBlocks(String congName, String[] blockArray);
    Block findBlock(String congName, String blockName, String blockNumber);
}
