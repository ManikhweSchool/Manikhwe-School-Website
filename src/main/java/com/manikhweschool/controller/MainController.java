package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	public MainController() {
		
	}
	
	@RequestMapping(value = "/index", 
	method = RequestMethod.GET)
	public String visitHome() {
		
		//return "Login";
		return "index";
	}

	@RequestMapping(value = "/java", 
	method = RequestMethod.GET)
	public String learnJava(HttpSession session) {
										
		return "IntroToJava";
	}
	
	@RequestMapping(value = "/python", 
	method = RequestMethod.GET)
	public String learnPython(HttpSession session) {
							
		return "IntroToPython";
	}
	
	@RequestMapping(value = "/dart", 
	method = RequestMethod.GET)
	public String learnDart(HttpSession session) {
				
		return "IntroToDart";
	}
	
	// The visitBackgroundPage method can work as a servlet's doGet or doPost method.
	@RequestMapping(value = "/background", 
	method = RequestMethod.GET)
	public String visitBackgroundPage(HttpSession session) {
			
		return "Background";
	}
	
	
	@RequestMapping(value = "/contact", 
	method = RequestMethod.GET)
	public String visitContactsPage(HttpSession session) {
		
		return "ContactInfo";
	}
}
