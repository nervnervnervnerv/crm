package com.nerv.crm.controller;

import com.nerv.crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class HomeController {
    UserRepository userRepository;
    @GetMapping("/home")
    public String home() {
        //managersRepository.save(new Manager(1L,"firstname","lastname","username","password", Role.ROLE_ADMIN));

        userRepository.findAll().forEach(System.out::println);
        return "home";
    }

}