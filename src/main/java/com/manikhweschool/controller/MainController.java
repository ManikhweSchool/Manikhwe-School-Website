package com.manikhweschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/home", 
	method = RequestMethod.GET)
	public String visitHomePage() {
		
		return "index";
	}
	
	@RequestMapping(value = "/index", 
	method = RequestMethod.GET)
	public String visitHome() {
				
		return "index";
	}
	

	@RequestMapping(value = "/java", 
	method = RequestMethod.GET)
	public String learnJava() {
										
		return "IntroToJava";
	}
	
	@RequestMapping(value = "/python", 
	method = RequestMethod.GET)
	public String learnPython() {
												
		return "IntroToPython";
	}
	
	// The visitBackgroundPage method can work as a servlet's doGet or doPost method.
	@RequestMapping(value = "/background", 
	method = RequestMethod.GET)
	public String visitBackgroundPage() {
			
		return "Background";
	}
	
	// The example given here is a bad one, it is for the demonstration purposes only.
	// The variable userName doesn't not have to match what was passed from a client in this case.
	@RequestMapping(value = "/contact", 
	method = RequestMethod.GET)
	public String visitContactsPage() {
			
		return "ContactInfo";
	}
}
