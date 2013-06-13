package com.gooki.service.impl;


import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import com.gooki.service.CongManager;
import com.gooki.webapp.exception.CongExistsException;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("congManager")
public class CongManagerImpl extends GenericManagerImpl<Cong, Long> implements CongManager {
    private CongDao congDao;

    @Autowired
    public CongManagerImpl(CongDao congDao) {
        super(congDao);
        this.congDao = congDao;
    }

    public void setCongDao(CongDao congDao) {
        this.congDao = congDao;
    }

    public Cong saveCong(Cong cong) throws CongExistsException {
        return congDao.save(cong);
    }

    public void removeCong(Cong block) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeCong(String congId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Cong findByCongName(String name) {
        return congDao.findByCongName(name);
    }

    public List<Cong> search(String searchTerm) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
