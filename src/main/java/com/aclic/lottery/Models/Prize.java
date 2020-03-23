package com.aclic.lottery.Models;

import java.util.Date;

public class Prize {

    private String ID;
    private String Name;
    private String Desc;
    private String Pic;
    private String BigPic;
    private Integer Count;
    private String Provider;
    private Integer State;
    private Date CreaTime;
    private Date StartTime;
    private Integer DuraTime;

    @Override
    public String toString() {
        return "Prize{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Desc='" + Desc + '\'' +
                ", Pic='" + Pic + '\'' +
                ", BigPic='" + BigPic + '\'' +
                ", Count=" + Count +
                ", Provider='" + Provider + '\'' +
                ", State=" + State +
                ", CreaTime=" + CreaTime +
                ", StartTime=" + StartTime +
                ", DuraTime=" + DuraTime +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public String getBigPic() {
        return BigPic;
    }

    public void setBigPic(String bigPic) {
        BigPic = bigPic;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String provider) {
        Provider = provider;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Date getCreaTime() {
        return CreaTime;
    }

    public void setCreaTime(Date creaTime) {
        CreaTime = creaTime;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Integer getDuraTime() {
        return DuraTime;
    }

    public void setDuraTime(Integer duraTime) {
        DuraTime = duraTime;
    }
}
