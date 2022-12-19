package com.example.genchi.controller;

import com.example.genchi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> doListUsers(){
        return ResponseEntity.ok(userService.doListUsers());
    }
}
