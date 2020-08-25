package com.group4.backend.service;

import com.group4.backend.entity.DemoUser;
import org.springframework.stereotype.Service;

public interface DemoUserService {
	public boolean verifyUser(DemoUser demoUser);
	public void checkDuplicateUser(DemoUser demoUser);
}
