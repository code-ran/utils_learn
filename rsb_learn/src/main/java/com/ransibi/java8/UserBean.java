package com.ransibi.java8;

import lombok.Data;

import java.util.List;

@Data
public class UserBean {
    private String name;
    private List<String> address;

    public UserBean(String name, List<String> address) {
        this.name = name;
        this.address = address;
    }
}
