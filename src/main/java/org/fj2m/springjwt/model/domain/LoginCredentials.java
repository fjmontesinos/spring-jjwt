package org.fj2m.springjwt.model.domain;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class LoginCredentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}