package com.example.myProject.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String uId, String password) {
		// admin, admin
		return uId.equalsIgnoreCase("admin")
				&& password.equalsIgnoreCase("admin");
	}

}
