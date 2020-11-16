package com.notnewcompany.social_network.integration;

import com.notnewcompany.social_network.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Test
    public void test() throws Exception {

        this.mockMvc.perform(get("/users/messages")).andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher)
                        content().json("[]"));
    }

    @Test
    public void test2() throws Exception {

        String req = "{\n" +
                "        \"firstName\": \"Chet\",\n" +
                "        \"email\": \"cbraisher8@boston.com\"\n" +
                "        }";

        String expected = "{\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"Chet\",\n" +
                "    \"lastName\": null,\n" +
                "    \"country\": null,\n" +
                "    \"age\": 0,\n" +
                "    \"gender\": null,\n" +
                "    \"email\": \"cbraisher8@boston.com\",\n" +
                "    \"password\": null,\n" +
                "    \"interests\": null\n" +
                "}";

        this.mockMvc.perform(post("/registration").content(req)).andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(expected));
    }

}


