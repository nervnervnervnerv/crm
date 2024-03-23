package com.nerv.crm.controller;

import com.nerv.crm.service.UserService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//TODO секюр
//TODO messages.properties
@RestController
@AllArgsConstructor
public class ValidationController {
    private UserService userService;
    @PostMapping (value = "/validate/username", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    ResponseEntity<?> validateUsername(@RequestBody HashMap<String, String> username) {
        boolean userExists = userService.existsByUsername(username.get("username"));
        if (userExists) {
            //TODO
            return new ResponseEntity<>("<p>Пользователь с таким именем уже создан</p>", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //TODO DTO объект для валидации или !отдельный класс для передачи данных
    @PostMapping (value = "/validate/firstname", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    ResponseEntity<?> validateFirstName(@RequestBody @NotNull @NotEmpty @Length(min = 3) HashMap<String, String> username) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
