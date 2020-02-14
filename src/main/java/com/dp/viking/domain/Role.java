package com.dp.viking.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, MANAGER, HR, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
