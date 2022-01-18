package com.demo.application.registrationsimplewebapp.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.application.registrationsimplewebapp.dto.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RegistrationControllerIT {

    private static final String USERNAME = "TestUsername";

    private static final String PASSWORD = "TestPass1";

    @Resource
    private WebApplicationContext context;

    @Test
    void handleRegistration() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .alwaysDo(print())
                .build();

        UserDto user = new UserDto();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
        user.setMatchingPassword(PASSWORD);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("user", user))
                //then
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("greeting-page"));
    }
}