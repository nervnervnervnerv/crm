package com.nerv.crm.controller;

import com.nerv.crm.repository.UserRepository;
import com.nerv.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class IndexController {
    private UserService userService;
    @GetMapping("/")
    public String index(Model model) {
//        userService.allUsers().forEach(System.out::println);
        model.addAttribute("users", userService.allUsers());
        return "index";
    }

}