package com.ransibi.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LomTest {
    public static void main(String[] args) {
        LomTestBean lomTestBean = new LomTestBean("张三",20,"男",false);
        log.info("信息输出:{}", lomTestBean);
    }
}