package org.insurgency.controller;

import javax.servlet.http.HttpServletRequest;

import org.insurgency.forms.UserForm;
import org.insurgency.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供用户服务
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * user service
     */
    private IUserService userService;

    /**
     * keep the default constructor
     */
    public UserController() {}

    /**
     * inject by constructor
     * 
     * @param userService
     *            userService
     */
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<String> Register(HttpServletRequest request, UserForm form) {
        return userService.userRegister(request, form);
    }
}
