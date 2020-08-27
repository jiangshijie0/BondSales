package com.group4.backend.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class UserTool {

	public static boolean loginStatus = false;
	public static boolean checkLogin (HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration<String> em = session.getAttributeNames();  //得到session中所有的属性名

		if (em.hasMoreElements()) {
			System.out.println(em.nextElement());
			return true;
		}
		else {
			System.out.println("no more element");
			return false;
		}
	}
}
