package com.gooki.service;


import org.springframework.security.access.AccessDeniedException;

/**
 * Created with IntelliJ IDEA.
 * User: iecanfly
 * Date: 6/18/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MapSecurityService {
    public boolean hasPermission(String congName) throws AccessDeniedException;
}
