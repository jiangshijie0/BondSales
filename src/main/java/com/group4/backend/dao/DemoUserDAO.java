package com.group4.backend.dao;

import com.group4.backend.entity.DemoUser;

public interface DemoUserDAO {
	public DemoUser queryUser(String name, String pass);
}
