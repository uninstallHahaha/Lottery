package com.aclic.lottery.Models;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class User {
    private String ID;
    private String Account;
    private String PassWord;
    private Integer Role;

    public User() {}

    public User(String account, String passWord, Integer role) {
        Account = account;
        PassWord = passWord;
        Role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", Account='" + Account + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", Role=" + Role +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public Integer getRole() {
        return Role;
    }

    public void setRole(Integer role) {
        Role = role;
    }
}
