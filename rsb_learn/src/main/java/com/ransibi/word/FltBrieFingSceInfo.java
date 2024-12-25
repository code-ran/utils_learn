package com.ransibi.word;

import java.util.ArrayList;
import java.util.List;

public class FltBrieFingSceInfo {
    private String stnName;
    private String devId;
    private String name;
    private String seqid;
    private String  tripRight;//是否正确动作  1 是 0 否   2 未动作
    private int devtype;

    private List<WaveFileInfo> lstosc=new ArrayList<WaveFileInfo>();



    public FltBrieFingSceInfo(String stnName, String devId, String name,
                              String seqid, String tripRight, int devtype,
                              List<WaveFileInfo> lstosc) {

        this.stnName = stnName;
        this.devId = devId;
        this.name = name;
        this.seqid = seqid;
        this.tripRight = tripRight;
        this.devtype = devtype;
        this.lstosc = lstosc;
    }


    public FltBrieFingSceInfo() {

    }


    public List<WaveFileInfo> getLstosc() {
        return lstosc;
    }


    public void setLstosc(List<WaveFileInfo> lstosc) {
        this.lstosc = lstosc;
    }


    public String getSeqid() {
        return seqid;
    }


    public int getDevtype() {
        return devtype;
    }


    public void setDevtype(int devtype) {
        this.devtype = devtype;
    }


    public void setSeqid(String seqid) {
        this.seqid = seqid;
    }


    public String getStnName() {
        return stnName;
    }
    public void setStnName(String stnName) {
        this.stnName = stnName;
    }
    public String getDevId() {
        return devId;
    }
    public void setDevId(String devId) {
        this.devId = devId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTripRight() {
        return tripRight;
    }
    public void setTripRight(String tripRight) {
        this.tripRight = tripRight;
    }


}
