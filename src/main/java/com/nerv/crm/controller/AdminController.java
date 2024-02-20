package com.nerv.crm.controller;

import com.nerv.crm.model.User;
import com.nerv.crm.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class AdminController {
    private UserService userService;

    @GetMapping("/admin")
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
    public String addUser(@Valid @ModelAttribute("user") User user, String action, Model model){
        if (action.equals("add")){
            try {
                userService.saveUser(user);
            } catch (DuplicateKeyException ignored) {
                model.addAttribute("users",userService.allUsers());
                model.addAttribute("errorMessage", "User already exists.");
                return "/admin";
            }
        }
        return "redirect:/admin";
    }

}


