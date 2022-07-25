package me.motyim.demos.springsecurity.enums;

public enum AppUserPermission {

    COURSE_READ("course:read"),
    COURSE_WRITE("course:write"),
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write");

    private final String value;

    AppUserPermission(String value){
        this.value = value;
    }

}
