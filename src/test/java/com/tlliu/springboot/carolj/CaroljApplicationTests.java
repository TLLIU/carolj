package com.tlliu.springboot.carolj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaroljApplicationTests {

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
	}

}
