package com.group4.backend.controller;

import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
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

	@PostMapping(value = "login", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String login(@RequestBody DemoUser user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(user.getName()) != null) return "already login";
		boolean result = demoUserService.verifyUser(user);

		if (result) {
			Enumeration<String> em = session.getAttributeNames();  //得到session中所有的属性名
			while (em.hasMoreElements()) {
				session.removeAttribute(em.nextElement().toString()); //遍历删除session中的值
			}
			session.setAttribute(user.getName(), user);
			return user.getName() + " login successfully";
		}
		return user.getName() + " login fail";
	}

}
