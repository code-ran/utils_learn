package com.ransibi.word;

import java.util.List;

public class FltBrieFingEntity {
    private String stn1Name;
    private String stn2Name;
    private String dev1Name;
    private String fltTime;
    private String fltType;
    private String fltContent;
    private String firstkepft;
    private String secondkepft;
    private float totalLength;//线路全长

    private List<FltBrieFingSceInfo> lstSec;
    private List<FltBrieFingStnInfo> lstStn;

    //增加新故障电流节点
    private String icda;
    private String icdb;
    private String icdc;

    public String getIcda() {
        return icda;
    }

    public void setIcda(String icda) {
        this.icda = icda;
    }

    public String getIcdb() {
        return icdb;
    }

    public void setIcdb(String icdb) {
        this.icdb = icdb;
    }

    public String getIcdc() {
        return icdc;
    }

    public void setIcdc(String icdc) {
        this.icdc = icdc;
    }


    public FltBrieFingEntity(String stn1Name, String stn2Name, String dev1Name,
                             String fltTime, String fltType, String fltContent,
                             String firstkepft, String secondkepft,
                             List<FltBrieFingSceInfo> lstSec, List<FltBrieFingStnInfo> lstStn) {
        this.stn1Name = stn1Name;
        this.stn2Name = stn2Name;
        this.dev1Name = dev1Name;
        this.fltTime = fltTime;
        this.fltType = fltType;
        this.fltContent = fltContent;
        this.firstkepft = firstkepft;
        this.secondkepft = secondkepft;
        this.lstSec = lstSec;
        this.lstStn = lstStn;
    }


    public FltBrieFingEntity() {

    }


    public float getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(float totalLength) {
        this.totalLength = totalLength;
    }


    public String getStn1Name() {
        return stn1Name;
    }
    public void setStn1Name(String stn1Name) {
        this.stn1Name = stn1Name;
    }
    public String getStn2Name() {
        return stn2Name;
    }
    public void setStn2Name(String stn2Name) {
        this.stn2Name = stn2Name;
    }
    public String getDev1Name() {
        return dev1Name;
    }
    public void setDev1Name(String dev1Name) {
        this.dev1Name = dev1Name;
    }
    public String getFltTime() {
        return fltTime;
    }
    public void setFltTime(String fltTime) {
        this.fltTime = fltTime;
    }
    public String getFltType() {
        return fltType;
    }
    public void setFltType(String fltType) {
        this.fltType = fltType;
    }
    public String getFltContent() {
        return fltContent;
    }
    public void setFltContent(String fltContent) {
        this.fltContent = fltContent;
    }
    public String getFirstkepft() {
        return firstkepft;
    }
    public void setFirstkepft(String firstkepft) {
        this.firstkepft = firstkepft;
    }
    public String getSecondkepft() {
        return secondkepft;
    }
    public void setSecondkepft(String secondkepft) {
        this.secondkepft = secondkepft;
    }
    public List<FltBrieFingSceInfo> getLstSec() {
        return lstSec;
    }
    public void setLstSec(List<FltBrieFingSceInfo> lstSec) {
        this.lstSec = lstSec;
    }
    public List<FltBrieFingStnInfo> getLstStn() {
        return lstStn;
    }
    public void setLstStn(List<FltBrieFingStnInfo> lstStn) {
        this.lstStn = lstStn;
    }

}

