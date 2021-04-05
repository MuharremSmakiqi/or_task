package com.example.or_task.Controller;

import com.example.or_task.Services.UsersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WebMvcTest(controllers = UsersController.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UsersService usersService;


    @Test
    @DisplayName("Should list all users when we visit the url: /api/v1/user/")
    void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("Should list a users by id: /api/v1/user/uuid/1")
    void findUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/uuid/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("Should list a users by name: /api/v1/user/name")
    void findUserByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/muharrem"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getGender() {
    }
}