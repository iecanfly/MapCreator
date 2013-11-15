package com.gooki.service.impl;

import com.gooki.service.SecurityContextService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: iecanfly
 * Date: 6/19/13
 * Time: 7:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
@Service("securityContextService")
public class SecurityContextServiceImpl implements SecurityContextService {
    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

    public Authentication getAuthentication() {
        return getSecurityContext().getAuthentication();
    }

    public String getUserName() {
        return getAuthentication().getName();
    }
}
