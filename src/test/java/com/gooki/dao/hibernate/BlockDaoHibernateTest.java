package com.gooki.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.gooki.dao.BlockDao;
import com.gooki.webapp.exception.BlockExistsException;
import com.gooki.dao.BaseDaoTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooki.model.Block;

public class BlockDaoHibernateTest extends BaseDaoTestCase {
	@Autowired
	private BlockDao blockDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindBlockByCongName() throws Exception {
	    List<Block> blocks = blockDao.findByCongName("ningbo_east_temp");
	    assertTrue(blocks.size() > 0);
	}

    @Test
    public void testSaveBlockAfterDuplicateCheck() throws Exception {
        Block block = new Block();
        block.setCong("test");
        block.setBlock("a");
        block.setNumber(100);
        block.setCoord("1.2,1.3");
        assertNotNull(blockDao.saveBlockAfterDuplicateCheck(block));
    }

    @Test(expected = BlockExistsException.class)
    public void testSaveBlockAfterDuplicateCheckThrowsException() throws Exception {
        Block block = new Block();
        block.setCong("test");
        block.setBlock("a");
        block.setNumber(100);
        block.setCoord("1.2,1.3");
        blockDao.saveBlockAfterDuplicateCheck(block);
        blockDao.saveBlockAfterDuplicateCheck(block);
    }

    @Test
    public void testFindBlocksSize() throws Exception {
        assertEquals(2, blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "D^1"}).size());
        assertEquals(1, blockDao.findBlocks("ningbo_east_temp", new String[]{"C^19", "C^2"}).size());
        assertEquals(1, blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "F^2"}).size());
        assertEquals(1, blockDao.findBlocks("ningbo_east_temp2", new String[]{"C^1", "q^2"}).size());
    }

    @Test
    public void testFindBlocksOrder() throws Exception {
        assertEquals(1, blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "C^2", "D^1"}).get(0).getNumber().intValue());
        assertEquals(2, blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "C^2", "D^1"}).get(1).getNumber().intValue());
        assertEquals(1, blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "C^2", "D^1"}).get(2).getNumber().intValue());

        assertEquals("C", blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "C^2", "D^1"}).get(0).getBlock());
        assertEquals("C", blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "C^2", "D^1"}).get(1).getBlock());
        assertEquals("D", blockDao.findBlocks("ningbo_east_temp", new String[]{"C^1", "C^2", "D^1"}).get(2).getBlock());
    }

    @Test
    public void testFindBlock()  throws Exception {
        assertNotNull(blockDao.findBlock("ningbo_east_temp", "C", "1"));
        assertEquals(2557, blockDao.findBlock("ningbo_east_temp", "C", "1").getId().longValue());
    }

    @Test
    public void testUpdate()  throws Exception {
        Block block = blockDao.findBlock("ningbo_east_temp", "C", "1");
        block.setBlock("D");
        blockDao.update(block);
        assertNull(blockDao.findBlock("ningbo_east_temp", "C", "1"));
    }

    @After
	public void tearDown() throws Exception {
	}

}
