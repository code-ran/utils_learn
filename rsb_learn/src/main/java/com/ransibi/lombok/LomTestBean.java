package com.ransibi.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LomTestBean {
    private String Name;
    private Integer age;
    private String sex;
    private boolean isExist;
}
