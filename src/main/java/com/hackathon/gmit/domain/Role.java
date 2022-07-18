/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.domain;

public enum Role {
    //ROLE_ADMIN
    ADMIN("admin", "ADMIN"),
    USER("user", "USER"),
    OTHER("other", "OTHER");

    private final String name;
    private final String value;

    Role(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String asRole() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
