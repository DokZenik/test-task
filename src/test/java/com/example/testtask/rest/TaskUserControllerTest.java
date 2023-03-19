package com.example.testtask.rest;

import com.example.testtask.TestTaskApplication;
import com.example.testtask.rest.TaskUserController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TestTaskApplication.class)
@AutoConfigureMockMvc
public class TaskUserControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TaskUserController taskUserController;


    @Test
    public void existingControllerTest() throws Exception{
        Assert.notNull(taskUserController, "Controller wasn't autowired");
    }

    @Test
    public void getUserTest() throws Exception {
        mvc.perform(get("/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("19")));

        mvc.perform(get("/3"))
                .andDo(print())
                .andExpect(status().is(404))
                .andExpect(content().string(containsString("User not found")));
    }
}
