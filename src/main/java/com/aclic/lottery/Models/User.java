package com.aclic.lottery.Models;

public class User {
    private String ID;
    private String Account;
    private String PassWord;
    private Integer Role;

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
