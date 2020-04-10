package com.aclic.lottery.Models;

public class User {
    private String id;
    private String account;
    private String password;
    private Integer role;
    private String av;

    public User() {}

    public User(String account, String password, Integer role, String av) {
        this.account = account;
        this.password = password;
        this.role = role;
        this.av = av;
    }

    public User(String account, String password, Integer role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public User(String id, String account, String password, Integer role, String av) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
        this.av = av;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", av='" + av + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }
}
