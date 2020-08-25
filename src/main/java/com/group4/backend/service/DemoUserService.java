package com.group4.backend.service;

import org.springframework.stereotype.Service;

public interface DemoUserService {
	public boolean verifyUser(String name, String pass);
}
