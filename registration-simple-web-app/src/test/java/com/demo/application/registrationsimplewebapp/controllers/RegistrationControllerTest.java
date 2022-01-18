package com.demo.application.registrationsimplewebapp.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.application.registrationsimplewebapp.services.UserService;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController controller;

    @Mock
    private UserService userService;

    @Test
    void getRegistrationForm() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();

        //when
        mockMvc.perform(get("/register"))
                //then
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("registration-page"));
    }

    @Test
    void getGreeting() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                //then
                .andExpect(status().isOk())
                .andExpect(view().name("greeting-page"));


    }
}