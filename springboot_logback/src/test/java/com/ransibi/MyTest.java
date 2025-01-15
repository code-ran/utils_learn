package com.ransibi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: rsb
 * @description: 2025-01-15-10-37
 * @description:
 * @Version: 1.0.0
 */

@SpringBootTest
@Slf4j
public class MyTest {
    @Test
    public void test01() {
        Logger logger = LoggerFactory.getLogger(MyTest.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
    }

    @Test
    public void test02() {
        log.error("error信息");
        log.warn("warn信息");
        log.info("info信息");
        log.debug("debug信息");
        log.trace("trace信息");
    }
}