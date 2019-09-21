package com.example.activitysimple.model;

import java.io.Serializable;

public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String login;
    private String Password;

    public LoginInfo(String login, String password) {
        this.login = login;
        Password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return Password;
    }
}
