package com.group4.backend.service.impl;

import com.group4.backend.dao.DemoUserDAO;
import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoUserServiceImpl implements DemoUserService {
	@Autowired
	DemoUserDAO demoUserDAO;

	@Override
	public boolean verifyUser(String name, String pass) {
		DemoUser demoUser = demoUserDAO.queryUser(name, pass);
		if (pass.equals(demoUser.getPass())) return true;
		return false;
	}
}
