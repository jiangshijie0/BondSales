package com.group4.backend.controller;

import com.group4.backend.entity.DemoUser;
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
		DemoUser demoUser = new DemoUser();
		demoUser.setName("jiangshijie0@qq.com");
		demoUser.setPass("password");
		boolean result = demoUserService.verifyUser(demoUser);
		return result + "";
	}

	@PostMapping("login")
	@ResponseBody
	public String login(@RequestBody DemoUser user, HttpServletRequest request) {
		boolean result = demoUserService.verifyUser(user);
		if (result) return user.getName() + " login successfully";
		return user.getName() + " login fail";
	}
}
