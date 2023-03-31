package com.tlliu.springboot.carolj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tlliu.springboot.carolj.service.SystemEnvService;



/* 这个类的所有方法返回的数据直接返回给浏览器（如果是对象转为json数据）
 * @RestController 定义一个Restful controller。这被称为构造型（stereotype）注解。
 * @RestController = @ResponseBody + @Controller
 * 它为阅读代码的人提供暗示（这是一个支持REST的控制器），对于Spring，该类扮演了一个特殊角色。
 * 在本示例中，我们的类是一个web @Controller，所以当web请求进来时，Spring会考虑是否使用它来处理。
 * @RestController 告诉Spring以字符串的形式渲染结果，并直接返回给调用者
 * 
 *  1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是return 里的内容。
 *   例如：本来应该到success.jsp页面的，则其显示success.
 *  2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 *  3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
*/
@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @Autowired
    SystemEnvService systemEnvService;
    /*
     * @RequestMapping 注解提供路由信息，它告诉Spring任何来自"/helloworld"路径的HTTP请求都应该被映射到该方法
     * @GetMapping("")=@RequestMapping(path="", method=RequestMethod.GET) 
    */
    @GetMapping("")
    public String helloWorld() {
        return "Hello World!" + System.lineSeparator() + systemEnvService.getSystemEnv().toString();
    }


}
