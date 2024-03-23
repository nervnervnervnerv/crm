package com.nerv.crm.controller;

import com.nerv.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class SettingsController {
//    private UserService userService;
    @GetMapping(value = "/settings")
    public String settings(Model model) {
        return "/settings";
    }
}
