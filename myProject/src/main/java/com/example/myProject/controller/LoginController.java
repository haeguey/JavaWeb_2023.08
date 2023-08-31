package com.example.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myProject.service.LoginService;



@Controller
@SessionAttributes("uId")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	// @RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "jsp/login";
	}
	
	@PostMapping("/login")
	// @RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String uId, @RequestParam String password){
		
		boolean isValidUser = service.validateUser(uId, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "jsp/login";
		}
		
		model.put("uId", uId);
		model.put("password", password);
		
		return "jsp/welcome";
	}

}
