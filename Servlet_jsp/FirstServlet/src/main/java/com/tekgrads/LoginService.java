package com.tekgrads;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

	Map<String, String> users = new HashMap<>();

	public LoginService() {
		users.put("test1", "Test User 1");
		users.put("test2", "Test User 2");
		users.put("test3", "Test User 3");
	}

	public boolean authenticate(String userId, String password) {

		if (password == null || password.trim() == "") {
			return false;
		}

		return true;
	}

	public User getUser(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(users.get(userId));
		return user;
	}
}