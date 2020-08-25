package com.group4.backend.services.impl;

import com.group4.backend.dao.EmployeeDAO;
import com.group4.backend.entity.Employee;
import com.group4.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public List<Employee> queryUser() {
		return employeeDAO.queryUser();
	}
}
