package me.motyim.demos.springsecurity.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static me.motyim.demos.springsecurity.enums.AppUserPermission.*;

public enum AppUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    Set<AppUserPermission> permissionSet;

    private AppUserRoles(Set<AppUserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

}
