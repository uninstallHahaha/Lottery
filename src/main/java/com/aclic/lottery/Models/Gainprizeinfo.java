package com.aclic.lottery.Models;

import java.util.Date;

public class Gainprizeinfo {

    private String ID;
    private String PrizeID;
    private String UserID;
    private String UserName;
    private Date GainTime;
    private String Address;

    @Override
    public String toString() {
        return "Gainprizeinfo{" +
                "ID='" + ID + '\'' +
                ", PrizeID='" + PrizeID + '\'' +
                ", UserID='" + UserID + '\'' +
                ", UserName='" + UserName + '\'' +
                ", GainTime=" + GainTime +
                ", Address='" + Address + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPrizeID() {
        return PrizeID;
    }

    public void setPrizeID(String prizeID) {
        PrizeID = prizeID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Date getGainTime() {
        return GainTime;
    }

    public void setGainTime(Date gainTime) {
        GainTime = gainTime;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
