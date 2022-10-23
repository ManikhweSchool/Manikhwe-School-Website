package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhweschool.model.Student;

@Controller
public class MainController {
	
	@Autowired
	private Student student;
	
	public MainController() {
		
	}
	
	@RequestMapping(value = "/index", 
	method = RequestMethod.GET)
	public String visitHome(HttpSession session) {
		
		if(session.getAttribute("student")==null)
			session.setAttribute("student", student);
		return "index";
	}

	@RequestMapping(value = "/java", 
	method = RequestMethod.GET)
	public String learnJava(HttpSession session) {
		
		if(session.getAttribute("student")==null)
			session.setAttribute("student", student);
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
						
		if(session.getAttribute("student")==null)
			session.setAttribute("student", student);
		return "IntroToPython";
	}
	
	@RequestMapping(value = "/python/exercises", 
	method = RequestMethod.GET)
	public String pythonExercises() {
						
		return "Python/Exercises";
	}
	
	@RequestMapping(value = "/dart", 
	method = RequestMethod.GET)
	public String learnDart(HttpSession session) {
				
		if(session.getAttribute("student")==null)
			session.setAttribute("student", student);
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
			
		if(session.getAttribute("student")==null)
			session.setAttribute("student", student);
		return "Background";
	}
	
	
	@RequestMapping(value = "/contact", 
	method = RequestMethod.GET)
	public String visitContactsPage(HttpSession session) {
		
		if(session.getAttribute("student")==null)
			session.setAttribute("student", student);
		return "ContactInfo";
	}
}
