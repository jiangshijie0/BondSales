package com.group4.backend.controller;

import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("test")
public class RegisterController {
    @Autowired
    private DemoUserService demoUserService;

    @RequestMapping("/register")
    @ResponseBody
    public void addUser(DemoUser user) {
        demoUserService.checkDuplicateUser(user);
    }
}
