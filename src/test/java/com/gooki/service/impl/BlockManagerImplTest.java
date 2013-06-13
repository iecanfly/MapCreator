package com.gooki.service.impl;

import com.gooki.dao.BlockDao;
import com.gooki.model.Block;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BlockManagerImplTest {
	BlockManagerImpl blockManagerImpl;
	@Mock
    BlockDao blockDao;
    @Mock
    Block block;

    @SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		blockManagerImpl = new BlockManagerImpl(blockDao);
	}

	@After
	public void tearDown() throws Exception {
		blockManagerImpl = null;
	}

	@Test
	public void testGetBlockByCongName() {
        blockManagerImpl.getBlocksByCongName("test");
        verify(blockDao).findByCongName("test");
	}

    @Test
    public void testGetBlocks() {
        blockManagerImpl.getBlocks("test", new String[]{"A-B^1", "A-C^1"});
        verify(blockDao).findBlocks("test", new String[]{"A-B^1", "A-C^1"});
    }

    @Test
    public void testGetBlock() {
        blockManagerImpl.getBlock("test", "blockName", "blockNumber");
        verify(blockDao).findBlock("test", "blockName", "blockNumber");
    }

    @Test
	public void testSaveBlock() throws Exception {
        blockManagerImpl.saveBlock(block);
        verify(blockDao).saveBlockAfterDuplicateCheck(block);
	}

}
