package com.zyc.test;

import com.zyc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc //测试 http 请求 请求 项目中的接口 引入 mockMVC
public class MockMvcDemo {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/text"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MvcResult mvcResultError = mockMvc.perform(MockMvcRequestBuilders.get("/user/text_XX"))
                 .andReturn();
                // andExpect  断言  判断请求是否 返回  ok  或者  404  取决于  status().
        String status = mvcResult.getResponse().getContentAsString();
        System.out.println(status);
        int statusError = mvcResultError.getResponse().getStatus();
        System.out.println(statusError);

    }
}
