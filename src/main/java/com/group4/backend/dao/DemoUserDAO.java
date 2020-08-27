package com.group4.backend.dao;

import com.group4.backend.entity.DemoUser;

public interface DemoUserDAO {
	public DemoUser queryUser(DemoUser demoUser);
	public void addUser(DemoUser demoUser);
}
