package com.tlliu.springboot.carolj.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.http.MediaType;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTests {

    private MockMvc mvc;
    @BeforeEach
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/helloworld").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!")));
/*
        RestAssured.given()
	        .contentType(ContentType.JSON)
//	        .pathParam("id", "AskJsd8Sd")
//	        .when()
//	        .get("/examplepath/{id}")
	        .get("/helloworld")
        	.then()
	        .statusCode(200)
//	        .body("firstName", equalTo("Onur"))
//	        .body("Surname", equalTo("Baskirt"));
        	.body(equalTo("Hello World!"));
*/
    }
}