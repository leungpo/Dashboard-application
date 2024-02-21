package com.app.dashboard.controller;

import com.app.dashboard.entity.User;
import com.app.dashboard.service.UserService;
import com.mongodb.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getById(@NonNull @PathVariable String id){
        User user = userService.findById(id);
        return userService.findById(id);
    }
}
