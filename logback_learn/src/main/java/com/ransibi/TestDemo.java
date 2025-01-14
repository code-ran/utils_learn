package com.ransibi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.PanelUI;

/**
 * @description:
 * @author: rsb
 * @description: 2025-01-14-10-12
 * @description:
 * @Version: 1.0.0
 */
public class TestDemo {
    @Test
    public void test01() {
        Logger logger = LoggerFactory.getLogger(TestDemo.class);
        logger.error("========= ERROR信息 test Logback =========");
        logger.warn("========= WARN信息 test Logback =========");
        logger.info("========= INFO信息 test Logback =========");
        logger.debug("========= DEBUG信息 test Logback =========");
        logger.trace("========= TRACE信息 test Logback =========");
    }

    @Test
    public void test02(){
        Logger logger = LoggerFactory.getLogger(TestDemo.class);
        for (int i = 0; i < 1000; i++) {
            logger.error("========= ERROR信息 test Logback =========");
            logger.warn("========= WARN信息 test Logback =========");
            logger.info("========= INFO信息 test Logback =========");
            logger.debug("========= DEBUG信息 test Logback =========");
            logger.trace("========= TRACE信息 test Logback =========");
        }
    }

    @Test
    public void test03(){
        Logger logger = LoggerFactory.getLogger(TestDemo.class);
        for (int i = 0; i < 100; i++) {
            logger.error("========= ERROR信息 test Logback =========");
            logger.warn("========= WARN信息 test Logback =========");
            logger.info("========= INFO信息 test Logback =========");
            logger.debug("========= DEBUG信息 test Logback =========");
            logger.trace("========= TRACE信息 test Logback =========");
        }
        System.out.println("aaaaaaaaaaaa");
        System.out.println("bbbbbbbbbbbb");
        System.out.println("cccccccccccc");
        System.out.println("dddddddddddd");
        System.out.println("eeeeeeeeeeee");
        System.out.println("ffffffffffff");
    }

    @Test
    public void test04() {
        Logger logger = LoggerFactory.getLogger(TestDemo.class);
        logger.error("========= ERROR信息 test Logback =========");
        logger.warn("========= WARN信息 test Logback =========");
        logger.info("========= INFO信息 test Logback =========");
        logger.debug("========= DEBUG信息 test Logback =========");
        logger.trace("========= TRACE信息 test Logback =========");
    }
}
