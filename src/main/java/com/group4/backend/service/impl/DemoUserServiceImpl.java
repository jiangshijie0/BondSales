package com.group4.backend.service.impl;

import com.group4.backend.dao.DemoUserDAO;
import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoUserServiceImpl implements DemoUserService {
	@Resource
	DemoUserDAO demoUserDAO;

	@Override
	public boolean verifyUser(DemoUser demoUser) {
		DemoUser demoUserResult = demoUserDAO.queryUser(demoUser);
		if (demoUserResult == null) return false;
		return demoUserResult.getPass().equals(demoUser.getPass());
	}

	@Override
	public void checkDuplicateUser(DemoUser demoUser){
		DemoUser demoUser1 = demoUserDAO.queryUser(demoUser);
		if (demoUser1 == null){
			demoUserDAO.addUser(demoUser);
		}
	}
}
