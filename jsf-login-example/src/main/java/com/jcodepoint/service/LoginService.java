package com.jcodepoint.service;

import com.jcodepoint.model.User;

public class LoginService {

	public User getUser(String userName) {
		//Let's use hardcoded data for demonstration purposes.
		if (userName.equalsIgnoreCase("jcodepoint")) {
			return new User("jcodepoint", "clave", "jCodePoint", "Site");
		} else {
			return null;
		}
	}
	
}
