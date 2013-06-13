package com.gooki.dao.hibernate;

import com.gooki.dao.CongDao;
import com.gooki.model.Block;
import com.gooki.model.Cong;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: iecanfly
 * Date: 4/17/13
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class CongDaoHibernateTest extends BaseDaoTestCase {
    @Autowired
    private CongDao congDao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindBlockByCongName() throws Exception {
        Cong cong = congDao.findByCongName("ningbo_east_temp");
        assertNotNull(cong);
    }

    @After
    public void tearDown() throws Exception {
    }
}
