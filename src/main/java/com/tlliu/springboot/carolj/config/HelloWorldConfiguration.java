package com.tlliu.springboot.carolj.config;

import com.tlliu.springboot.carolj.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：指明当前类是一个配置类；就是来代替之前的Spring配置文件
 *
 * 在配置文件中用<bean></bean>标签添加组件
 */
@Configuration
public class HelloWorldConfiguration {
    //将方法的返回值添加到容器中；容器这个组件id就是方法名
    @Bean
    public HelloWorldService helloWorldService() {
        System.out.println("Create component helloWorldService to container from this configuraiton class");
        return new HelloWorldService();
    }

}