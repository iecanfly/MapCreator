package com.gooki.service.impl;

import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CongManagerImplTest {
	CongManagerImpl congManagerImpl;
	@Mock
    CongDao congDao;

    @SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		congManagerImpl = new CongManagerImpl(congDao);
	}

	@After
	public void tearDown() throws Exception {
		congManagerImpl = null;
	}

	@Test
	public void testGetCongByCongName() {
        congManagerImpl.findByCongName("test");
        verify(congDao).findByCongName("test");
	}

    @Test
	public void testSaveCong() {
        Cong cong = new Cong();
        congManagerImpl.save(cong);
        verify(congDao).save(cong);
	}

}
