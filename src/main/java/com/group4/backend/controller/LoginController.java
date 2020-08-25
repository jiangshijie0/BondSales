package com.group4.backend.controller;

import com.group4.backend.service.DemoUserService;
import com.group4.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@Autowired
	DemoUserService demoUserService;

	@RequestMapping("loginTest")
	@ResponseBody
	public String loginTest() {
		boolean result = demoUserService.verifyUser("jiangshijie0@qq.com", "password");
		return result + "";
	}

	@PostMapping("login")
	@ResponseBody
	public String login(@RequestBody String json, HttpServletRequest request) {
		System.out.println(json);
		request.getSession();
		return "false";
	}
}
