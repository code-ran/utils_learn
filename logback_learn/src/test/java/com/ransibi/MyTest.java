package com.ransibi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: rsb
 * @description: 2025-01-13-16-57
 * @description:
 * @Version: 1.0.0
 */
public class MyTest {
    @Test
    public void testConfig() {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error("error>>>>>>>>>>>>>>>>>>>>");
        logger.warn("warn>>>>>>>>>>>>>>>>>>>>");
        logger.info("info>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.debug("debug>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.trace("trace>>>>>>>>>>>>>>>>>>>");


        /**
         * 打印结果：
         *
         * 2021-12-26 main [ERROR] - error>>>>>>>>>>>>>>>>>>>>
         * 2021-12-26 main [WARN] - warn>>>>>>>>>>>>>>>>>>>>
         * 2021-12-26 main [INFO] - info>>>>>>>>>>>>>>>>>>>>>>>>>
         * 2021-12-26 main [DEBUG] - debug>>>>>>>>>>>>>>>>>>>>>>>>>
         * 2021-12-26 main [TRACE] - trace>>>>>>>>>>>>>>>>>>>
         */


    }

}
