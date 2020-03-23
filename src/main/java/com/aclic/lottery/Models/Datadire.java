package com.aclic.lottery.Models;

public class Datadire {
    private String Code;
    private String Value;

    @Override
    public String toString() {
        return "Datadire{" +
                "Code='" + Code + '\'' +
                ", Value='" + Value + '\'' +
                '}';
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
