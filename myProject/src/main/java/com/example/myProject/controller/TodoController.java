package com.example.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myProject.service.TodoService;



@Controller
@SessionAttributes("uId")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping("/list-todos")
	// @RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
//test:	list=service.retrieveTodos(uId);
//test:	model.put("todos", list);
		String uId = (String) model.get("uId");
		model.put("todos", service.retrieveTodos(uId));
		
//test:	System.out.println(service.retrieveTodos(uId));
		return "jsp/list-todos";
	}
}
