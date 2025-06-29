package com.journal.journalws.dto.user;

import jakarta.validation.constraints.NotNull;

public class UserSaveRequest {

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    private final String password;

    public UserSaveRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
