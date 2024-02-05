package com.nerv.crm.model;

import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;
@FieldNameConstants
public enum Role implements GrantedAuthority {
    ROLE_HUNTER, ROLE_CLOSER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
