package com.nerv.crm.controller;


import com.nerv.crm.model.Role;
import com.nerv.crm.model.User;
import com.nerv.crm.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class UserInfoController {
    private UserService userService;
    @GetMapping("/users")
    public String usersInfo(Model model){
        System.out.println();
        model.addAttribute("users",userService.allUsers());
        return "users";
    }

    @PostMapping("/users/add")
    public String registerNewUser(@Valid User user, Model model) {
        try {
            userService.saveUser(user);
        } catch (DuplicateKeyException ignored) {
            model.addAttribute("users",userService.allUsers());
            model.addAttribute("errorMessage", "User already exists.");
            return "users";
        }
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String  deleteUser(@RequestParam(required = true) Long id,
                              @RequestParam(required = true, defaultValue = "delete" ) String action) {

        if (action.equals("delete")){
            userService.deleteUser(id);
        }
        return "redirect:/users";
    }
}
