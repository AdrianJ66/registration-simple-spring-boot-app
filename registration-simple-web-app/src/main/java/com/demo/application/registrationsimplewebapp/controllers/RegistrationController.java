package com.demo.application.registrationsimplewebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.application.registrationsimplewebapp.dto.UserDto;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String getRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }
}
