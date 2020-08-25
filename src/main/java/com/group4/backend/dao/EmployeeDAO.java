package com.group4.backend.dao;

import com.group4.backend.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface EmployeeDAO {
	public List<Employee> queryUser ();
}
