package com.gooki.service.impl;

import com.gooki.model.Cong;
import com.gooki.model.User;
import com.gooki.service.MapSecurityService;
import com.gooki.service.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: iecanfly
 * Date: 6/18/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */

@Component("mapSecurity")
public class MapSecurityServiceImpl implements MapSecurityService {
    @Autowired
    private SecurityContextService securityContextService;

    public boolean hasPermission(String congName) throws AccessDeniedException {
        String userName = securityContextService.getUserName();
        Set<Cong> congs = ((User)securityContextService.getAuthentication().getPrincipal()).getCongs();

        for (Iterator<Cong> iterator = congs.iterator(); iterator.hasNext(); ) {
            Cong next =  iterator.next();
            if(next.getName().equals(congName)) {
                return true;
            }
        }
        if(userName.equals("admin")) {
            return true;
        }

        throw new AccessDeniedException("Access Denied");
    }
}
