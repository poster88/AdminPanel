package com.example.poster.adminpanelrealm.models;

import io.realm.RealmObject;


public class UserModel extends RealmObject{
    private String name;
    private String lastName;
    private String login;
    private String pass;

    public UserModel() {
    }

    public UserModel(String name, String lastName, String pass, String login) {
        this.name = name;
        this.lastName = lastName;
        this.pass = pass;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
