package com.group4.backend.controller;

import com.group4.backend.entity.Employee;
import com.group4.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.List;

@Controller
public class TestController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("testDirect")
	@ResponseBody
	public String testPath () {
		System.out.println("This is Test Function.");
		final String url = "jdbc:oracle:thin:@192.168.3.9:1521:ORCL";
		final String username = "hr";
		final String password = "hr";
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		String sql = "select * from EMPLOYEES";

		Connection conn = null;
		ResultSet rs = null;
		Statement stamt = null;

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn.isValid(10000));
			stamt = conn.createStatement();

			rs = stamt.executeQuery(sql);
			while(rs.next()){
				//输出查询结果
				System.out.println("_" + rs.getString("first_name") + "_"
						+ rs.getString("last_name"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		return "This is a Test Page.";
	}

	@Autowired
	UserService userService;

	@RequestMapping("testM")
	@ResponseBody
	public String testMybatis () {
		List<Employee> result = userService.queryUser();
		for (Employee employee : result) {
			System.out.println(employee.toString());
		}

		return "This is the Testing for Mybatis XML file.";
	}
}
