package com.group4.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoUserService;
import com.group4.backend.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class LoginController {
	@Autowired
	DemoUserService demoUserService;

	@RequestMapping("loginTest")
	@ResponseBody
	public DemoUser loginTest() {
		DemoUser demoUser = new DemoUser();
		demoUser.setName("jiangshijie0@qq.com");
		demoUser.setPass("password");
		boolean result = demoUserService.verifyUser(demoUser);
		return demoUser;
	}

	@PostMapping(value = "login")
	@ResponseBody
	public DemoUser login(@RequestBody DemoUser user, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session.getAttribute(user.getName()) != null) return user;
		boolean result = demoUserService.verifyUser(user);

		if (result) {
			UserTool.loginStatus = true;
			Enumeration<String> em = session.getAttributeNames();  //得到session中所有的属性名
			while (em.hasMoreElements()) {
				session.removeAttribute(em.nextElement()); //遍历删除session中的值
			}
			session.setAttribute(user.getName(), user);
			UserTool.checkLogin(request);
			return user;
		}
		return null;
	}

	@PostMapping(value = "logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		UserTool.loginStatus = false;
		HttpSession session = request.getSession();
		Enumeration<String> em = session.getAttributeNames();  //得到session中所有的属性名
		while (em.hasMoreElements()) {
			session.removeAttribute(em.nextElement()); //遍历删除session中的值
		}

		return JSONObject.toJSONString("true");
	}

}
