package com.gooki.service;

import java.util.List;

import com.gooki.dao.BlockDao;
import com.gooki.service.GenericManager;

import com.gooki.webapp.exception.BlockExistsException;
import com.gooki.model.Block;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BlockManager extends GenericManager<Block, Long>{
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
     * Updates a block's information.
     * @param block the block's information
     */
    void updateBlock(Block block) ;

    /**
     * Removes a block from the database
     *
     * @param block the block to remove
     */
    void removeBlock(Block block);

    /**
     * Search a block for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Block> search(String searchTerm);
}
