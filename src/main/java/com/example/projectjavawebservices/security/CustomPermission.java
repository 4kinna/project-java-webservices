package com.example.projectjavawebservices.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public class CustomPermission implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Integer targetId = (Integer) targetDomainObject;

        for (GrantedAuthority ga : authorities) {
            if(ga.getAuthority().equals(String.format("%d", targetId))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
