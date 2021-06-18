package com.tlliu.springboot.carolj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class CaroljApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ApplicationContext ioc;

	@Test
	public void testHelloWorldService(){
        boolean b = ioc.containsBean("helloWorldService");
        assertTrue(b);
        System.out.println(b);
    }

	@Test
	void contextLoads() {
        //日志的级别
        //从低到高
        //可以调整输出的日志级别；日志就只会在这个级别以后的高级别生效
        logger.trace("这是trace日志");
        logger.debug("这是debug信息");
        //SpringBoot默认给的是info级别，如果没指定就是默认的root级别
        logger.info("这是info日志");
        logger.warn("这是warn信息");
        logger.error("这是Error信息");
	}

}
