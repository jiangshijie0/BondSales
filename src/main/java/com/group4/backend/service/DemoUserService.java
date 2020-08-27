package com.group4.backend.service;

import com.group4.backend.entity.DemoUser;

public interface DemoUserService {
	public boolean verifyUser(DemoUser demoUser);
	public String checkDuplicateUser(DemoUser demoUser);
}
