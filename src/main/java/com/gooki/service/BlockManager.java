package com.gooki.service;

import java.util.List;

import com.gooki.dao.BlockDao;
import org.appfuse.service.GenericManager;

import com.gooki.webapp.exception.BlockExistsException;
import com.gooki.model.Block;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BlockManager extends GenericManager<Block, Long>{
	/**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param blockDao the GenericDaoHibernate<Block, Long> implementation to use
     */
    void setBlockDao(BlockDao blockDao);


    /**
     * Retrieves a list of blocks for given cong name.
     * @return List
     */
    List<Block> getBlocksByCongName(String congName);

    /**
     * Retrieves a list of blocks for given params.
     * @return List
     */
    List<Block> getBlocks(String congName, String[] blockArray);

    /**
     * Retrieves a block for given params.
     * @return List
     */
    Block getBlock(String congName, String blockName, String blockNumber);

    /**
     * Saves a block's information.
     *
     * @param block the block's information
     * @throws BlockExistsException thrown when block already exists
     * @return block the updated block object
     */
    Block saveBlock(Block block) throws BlockExistsException;

    /**
     * Removes a block from the database
     *
     * @param block the block to remove
     */
    void removeBlock(Block block);

    /**
     * Removes a block from the database by their blockId
     *
     * @param blockId the block's id
     */
    void removeBlock(String blockId);

    /**
     * Search a block for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Block> search(String searchTerm);
}
