package com.group4.backend.services;

import com.group4.backend.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
	public List<Employee> queryUser();
}
