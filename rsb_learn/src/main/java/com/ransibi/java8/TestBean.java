package com.ransibi.java8;

import lombok.Data;

import java.util.Objects;

@Data
public class TestBean {
    private String role;
    private String name;
    private String file;
    private String path;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestBean testBean = (TestBean) o;
        return Objects.equals(name, testBean.name) && Objects.equals(file, testBean.file) && Objects.equals(path, testBean.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, file, path);
    }
}
