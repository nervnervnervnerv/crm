package com.nerv.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController {
    @GetMapping("/error/forbidden")
    public String forbiddenError() {
        return "errors/forbidden";
    }
}
