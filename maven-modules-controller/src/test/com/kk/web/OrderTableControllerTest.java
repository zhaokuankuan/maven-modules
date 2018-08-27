package com.kk.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author :Mr.kk
 * @date: 2018/8/27-13:30
 */
@SpringBootTest
public class OrderTableControllerTest {

    private MockMvc mockMvc;


    /** 将对应的实体类设置到mockmvc中
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        //创建一个标准的类
        mockMvc = MockMvcBuilders.standaloneSetup(new OrderTableController()).build();
    }

    /** 测试web请求  可以用swagger 直接生成文档测试
     * @throws Exception
     */
    @Test
    public void getHello() throws  Exception{
        System.out.print("I am test!");
        mockMvc.perform(MockMvcRequestBuilders.get("/getHello?name=zhaokk").accept(MediaType.APPLICATION_JSON_UTF8));
    }
}