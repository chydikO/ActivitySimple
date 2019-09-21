package com.example.activitysimple.model;

import java.io.Serializable;

public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String login;
    private String Password;
    private String device;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return Password;
    }

    public String getDevice() {
        return device;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
