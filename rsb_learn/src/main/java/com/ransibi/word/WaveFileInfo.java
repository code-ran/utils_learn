package com.ransibi.word;

public class WaveFileInfo {
    private  String name;
    private  String path;
    private int age;//借用字段     可忽略




    public WaveFileInfo() {

    }






    public WaveFileInfo(String name, String path, int age) {

        this.name = name;
        this.path = path;
        this.age = age;
    }






    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
