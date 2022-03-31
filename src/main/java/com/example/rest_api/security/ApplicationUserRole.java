package com.example.rest_api.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.rest_api.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet()), ADMIN(Sets.newHashSet(CLIENT_READ, CLIENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
