package com.manikhweschool.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhweschool.model.ConsultationSession;
import com.manikhweschool.model.Student;
import com.manikhweschool.service.ConsultationSessionService;



@Controller
public class ConsultationSessionController {

	@Autowired
	private ConsultationSessionService service;
	
	@Autowired
	private StudentController studentController;
	
	
	@RequestMapping(value = "/booking", 
	method = RequestMethod.GET)
	public String requestForm(Model model) {
	
		model.addAttribute("session", new ConsultationSession());
		return "Session";
	}
	@RequestMapping(value = "/booking", 
	method = RequestMethod.POST)
	public String saveReqeust(
	@ModelAttribute(name="session")ConsultationSession session, 
	Model model, HttpSession httpSession) { 
		
		String status = "";
		String page = "Session";
		boolean sessionAdded = false;
		
		
		if(session.getLanguages().isEmpty()) {
			status += "Pick Atleast One Programming Language.";
		}
		else if(session.getSessionPhoneNumber()==null) {
			status += "Enter A Valid South African PhoneNumber.";
		}
		else if(session.getSessionPhoneNumber().equals("")) {
			status += "Enter A South African PhoneNumber.";
		}
		else if(session.getSessionPreferedDate().equals("") &&
		session.getSessionSelectedDay().equals("")) {
			status += "Pick Consultation Date.";
		}
		else if(session.getSessionAddress().equals("")){
			status += "Enter The Address";
		}
		else {
			
			Student student = (Student)httpSession.getAttribute("student");
			if(student==null) {
				model.addAttribute("bookingError", "Sign Up First, In Order To Proceed Booking A Consultation Session.");
				return studentController.signIn(model, httpSession, "Session");
			}
			else {
				Optional<Student> retrievedStudent = studentController.findStudent(student.getEmail());
			
				if(retrievedStudent.isPresent()) {
					
					
					Student stu = retrievedStudent.get();
					stu.addConsultationSession(session);
					
					session.setStudent(student);
					
					service.saveConsultationSession(session);
					
					sessionAdded = true;
					status += "Session Added Successfully";
					page = "SessionRequestConfirmation";
					
					model.addAttribute("session", session);
				}
				
				else {
					status += "Sign Up In Order To Book A Consultation.";
					
				}
			}
			
		}
		
		model.addAttribute("status", status);
		model.addAttribute("sessionAddedOnDatabase", sessionAdded);
		return page;
	}
	
	public Optional<ConsultationSession> findRequest(long consultationSessionId){
		return service.findConsultationSession(consultationSessionId);
	}
	
	public void deleteRequest(long consultationSessionId ,
	Model model) { 
			
		long initialSize = service.count();
		
		Optional<ConsultationSession> consultationSession = service.findConsultationSession(consultationSessionId);
		if(consultationSession.get().isSessionDone())
			service.deleteConsultationSession(consultationSessionId);
		
		if(initialSize != service.count()) 
			model.addAttribute("sessionRemovedFromDatabase", true);
		else 
			model.addAttribute("sessionRemovedFromDatabase", false);
			
		model.addAttribute("session", service.findAllConsultationSessions());
		
	}
	/*
	public void changeSurveyDone(long requestId,Model model) {

		Request request = service.findRequest(requestId).get();
						
		if(!request.getIsSurveyDone())
			request.setIsSurveyDone(!request.getIsSurveyDone());
		service.saveReqeust(request);
						
		model.addAttribute("requests", service.findAllRequests());
	}*/
	
	//public List<ConsultationSession> findAllConsultationSession(){return service.findAllConsultationSessions();}
}


