package com.ransibi.word;

public class FltBrieFingStnInfo {
    private String stnName;
    private String fltcurrent;//故障电流
    private float FirstDistance;//保护一测距
    private float SecDistance; //保护二测距
    private float totalDistance;
    private String firstkepft;
    private String secondkepft;




    public FltBrieFingStnInfo(String stnName, String fltcurrent,
                              float firstDistance, float secDistance, float totalDistance,
                              String firstkepft, String secondkepft) {

        this.stnName = stnName;
        this.fltcurrent = fltcurrent;
        FirstDistance = firstDistance;
        SecDistance = secDistance;
        this.totalDistance = totalDistance;
        this.firstkepft = firstkepft;
        this.secondkepft = secondkepft;
    }


    public float getTotalDistance() {
        return totalDistance;
    }


    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }


    public FltBrieFingStnInfo() {

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


    public String getStnName() {
        return stnName;
    }
    public void setStnName(String stnName) {
        this.stnName = stnName;
    }
    public String getFltcurrent() {
        return fltcurrent;
    }
    public void setFltcurrent(String fltcurrent) {
        this.fltcurrent = fltcurrent;
    }
    public float getFirstDistance() {
        return FirstDistance;
    }
    public void setFirstDistance(float firstDistance) {
        FirstDistance = firstDistance;
    }
    public float getSecDistance() {
        return SecDistance;
    }
    public void setSecDistance(float secDistance) {
        SecDistance = secDistance;
    }


}
