package com.gooki.service.impl;

import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import com.gooki.model.User;
import com.gooki.service.SecurityContextService;
import com.gooki.service.UserManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CongManagerImplTest {
	CongManagerImpl congManagerImpl;
	@Mock
    CongDao congDao;
    @Mock
    UserManager userManager;
    @Mock
    SecurityContextService securityContextService;

    @SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		congManagerImpl = new CongManagerImpl(congDao, userManager, securityContextService);
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
    @Ignore
	public void testSaveCong() throws Exception{
        Cong cong = getCong();
        when(securityContextService.getUserName()).thenReturn("test");
        when(congDao.save(cong)).thenReturn(cong);
        when(userManager.getUserByUsername("test")).thenReturn(getUser());

        verify(congDao).save(cong);
	}

    private User getUser() {
        User user = new User();
        user.setId(1l);
        return user;
    }

    private Cong getCong() {
        Cong cong = new Cong();
        cong.setId(111l);
        cong.setCenterCoord("123");
        cong.setName("test1");
        cong.setZoomLevel("2");

        return cong;
    }
}
