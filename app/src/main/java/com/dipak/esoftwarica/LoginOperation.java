package com.dipak.esoftwarica;

public class LoginOperation {

    private String username, password;

    public LoginOperation(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public Boolean operation()
    {
        if (username.equals("softwarica") && password.equals("coventry"))
        {
            return true;
        }else {
            return false;
        }
    }

}
