package com.tlliu.springboot.carolj.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tlliu.springboot.carolj.service.SystemEnvService;

import org.springframework.http.MediaType;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTests {

    private MockMvc mvc;
    @MockitoBean
    private SystemEnvService systemEnvService;

    @BeforeEach
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController(systemEnvService)).build();
    }
    @Test
    public void getHello() throws Exception {        
        mvc.perform(MockMvcRequestBuilders.get("/helloworld").accept(MediaType.TEXT_PLAIN))//.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("Hello World!")));
    }
}