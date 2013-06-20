package com.gooki.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;

/**
 * Created with IntelliJ IDEA.
 * User: iecanfly
 * Date: 6/19/13
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */

public interface SecurityContextService {
    public SecurityContext getSecurityContext();
    public Authentication getAuthentication();
    public String getUserName();
}
