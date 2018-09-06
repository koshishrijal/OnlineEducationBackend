package com.asky.backend.model;

import javax.validation.constraints.NotNull;

public class UserDtoForInsert {

    @NotNull(message = "name must not be null")
    private String username;
    @NotNull(message ="email mst not be null")
    private String email;
    @NotNull(message="password is required")
    private String password;

    private String role;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
