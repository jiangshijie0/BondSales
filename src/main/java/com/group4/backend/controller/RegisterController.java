package com.group4.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("RegisterCtrl")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class RegisterController {
    @Autowired
    private DemoUserService demoUserService;

    @PostMapping("/register")
    @ResponseBody
    public String addUser(@RequestBody String body) {
        DemoUser demoUser = JSONObject.parseObject(body, DemoUser.class);
        String result = demoUserService.checkDuplicateUser(demoUser);
        String json = JSONObject.toJSONString(result);
        return json;
    }
}
