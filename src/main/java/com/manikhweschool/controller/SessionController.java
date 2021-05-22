package com.manikhweschool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manikhweschool.model.Session;
import com.manikhweschool.model.Student;
import com.manikhweschool.service.SessionService;

@Controller
public class SessionController{
	
    
    @Autowired
    private SessionService service;
    
    @Autowired
	private Session session;
    
    @Autowired
    private StudentController studentController;
    
    @RequestMapping(value = "/sessionbooking", 
    method = RequestMethod.GET)
    public String bookSession(Model model) {
    						
    	model.addAttribute("session", session);
    	return "SessionRequest";
    }

    @RequestMapping(value = "/sessionbooking", 
    method = RequestMethod.POST)
    public String bookSession(@ModelAttribute(name="session")Session session, Model model){
        
    	String status;
		String page;
		Optional<Student> optionalStudent = studentController.findStudent(session.getSessionStudent().getEmail());
		
		if(!optionalStudent.isPresent()) {
			model.addAttribute("student", session.getSessionStudent());
			status = "Student Must Register First In Order To Book A Session.";
			model.addAttribute("nextPage","SessionRequest");
			page = "SignIn";
		}
		else if(!optionalStudent.get().getPassword().equals(
		session.getSessionStudent().getPassword())) {
			model.addAttribute("session", session);
			model.addAttribute("sessionAddedOnDatabase", false);
			status = "Incorrect Password.";
			page = "SessionRequest";
		}
		else {
			
			optionalStudent.get().addSession(session);
			service.saveSession(session);
			status = "Session Booking Recieved.";
			page = "SessionConfirmation";
		}
		model.addAttribute("status", status);
        return page;
    }
    
    @RequestMapping(value = "/find/session/{id}", method = RequestMethod.GET)
	public Optional<Session> findSession(@RequestParam("id") int id) {
		
		return service.findSession(id);
	}

    public List<Session> findAllSessions(){
        return service.findAllSessions();
    }
}