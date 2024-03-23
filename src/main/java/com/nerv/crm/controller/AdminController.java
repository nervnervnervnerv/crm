package com.nerv.crm.controller;

import com.nerv.crm.model.User;
import com.nerv.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@AllArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private UserService userService;
    @GetMapping(value = "/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "/admin";
    }

    @PostMapping(value = "/admin/delete/{id}")
    public String deleteUser(@PathVariable Long id, @RequestParam String action){
        if (action.equals("delete")){
            userService.deleteUser(id);
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@Validated User user, String action, RedirectAttributes redirectAttributes){
        if (action.equals("add")){
            userService.saveUser(user);
        }
        return "redirect:/admin";
    }
}


