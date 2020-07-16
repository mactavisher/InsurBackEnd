package com.insurgency.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供用户服务
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @PostMapping("register")
    public String Register() {
        return "register";
    }
}
