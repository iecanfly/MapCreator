package com.gooki.service.impl;


import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import com.gooki.model.User;
import com.gooki.service.CongManager;
import com.gooki.service.SecurityContextService;
import com.gooki.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service("congManager")
public class CongManagerImpl extends GenericManagerImpl<Cong, Long> implements CongManager {
    private CongDao congDao;
    private UserManager userManager;
    private SecurityContextService securityContextService;

    @Autowired
    public CongManagerImpl(CongDao congDao, UserManager userManager, SecurityContextService securityContextService) {
        super(congDao);
        this.congDao = congDao;
        this.userManager = userManager;
        this.securityContextService = securityContextService;
    }

    public void removeCongByName(String congName) {
        congDao.removeCongByName(congName);
    }

    public Cong findByCongName(String name) {
        return congDao.findByCongName(name);
    }

    public HashSet<Cong> getAllUniqueCongs() {
        return new HashSet<Cong>(getAll());
    }

    @PreAuthorize("@mapSecurity.hasPermission(#cong.getName())")
    public void addUser(Cong cong, User user) {
        cong.getUsers().add(user);
        save(cong);
    }

    public List<Cong> search(String searchTerm) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
