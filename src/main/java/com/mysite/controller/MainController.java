package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public String index() {
		
		System.out.println("MainController.index()");
		
		return "/WEB-INF/views/main/index.jsp";
	}	
	
}
