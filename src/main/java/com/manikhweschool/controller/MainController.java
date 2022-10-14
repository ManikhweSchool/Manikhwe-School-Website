package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhweschool.model.Student;

@Controller
public class MainController {
	
	public MainController() {
		
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
	
	@RequestMapping(value = "/java/exercises", 
	method = RequestMethod.GET)
	public String javaExercises() {
				
		return "Exercises";
	}
	
	@RequestMapping(value = "/python", 
	method = RequestMethod.GET)
	public String learnPython(HttpSession session) {
						
		
		return "IntroToPython";
	}
	
	@RequestMapping(value = "/python/exercises", 
	method = RequestMethod.GET)
	public String pythonExercises() {
						
		return "Python/Exercises";
	}
	
	@RequestMapping(value = "/dart", 
	method = RequestMethod.GET)
	public String learnDart() {
				
		return "IntroToDart";
	}
	
	@RequestMapping(value = "/dart/exercises", 
	method = RequestMethod.GET)
	public String dartExercises() {
								
		return "Dart/Exercises";
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
