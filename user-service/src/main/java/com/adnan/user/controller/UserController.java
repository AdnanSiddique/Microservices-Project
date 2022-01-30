package com.adnan.user.controller;

import com.adnan.user.ValueObject.ResponseTemplateVo;
import com.adnan.user.entity.User;
import com.adnan.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody  User user) {
        log.info("inside saveUser method of UserController");
        return  userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
