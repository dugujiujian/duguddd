package com.dugu.ddd.controller.main;

import com.dugu.ddd.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author cihun
 * @date 2023-09-18 20:16
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {


        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testHello() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/index"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("hello, spring boot!"));
        }



}