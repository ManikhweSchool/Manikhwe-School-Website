package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manikhweschool.model.TodayVisitation;
import com.manikhweschool.music.model.MyAuthorizationCodeUri;

@Controller
public class MainController {

	@RequestMapping(value = "/authorize", 
	method = RequestMethod.GET)
	public String askForSpotifyAccess() {
		
		
		MyAuthorizationCodeUri.createMyAuthorizationCodeUri(
		"bac757d75af0458e9eda632244424997", 
		"44314cbe9771476a85ec2a0c736c995b");
		MyAuthorizationCodeUri.authorizationCodeUri_Sync();
		
		
		return "index";
	}
	
	@RequestMapping(value = "/spotifyredirect", 
	method = RequestMethod.GET)
	public String recieveSpotifyCode(
	@RequestParam(name="code") String code) {
				
		if(code != null)
			MyAuthorizationCodeUri.secondStep(code);
		
		return "index";
	}
	
	@RequestMapping(value = "/index", 
	method = RequestMethod.GET)
	public String visitHome(HttpSession session) {
		
		if(session.getAttribute("firstTimeVisit")==null) {
			session.setAttribute("canAccessJava", false);
			session.setAttribute("canAccessPython", false);
			session.setAttribute("firstTimeVisit", true);
			
		}
		else if((Boolean)(session.getAttribute("firstTimeVisit"))==true){
			session.setAttribute("firstTimeVisit", false);
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return "index";
			
	}

	@RequestMapping(value = "/java", 
	method = RequestMethod.GET)
	public String learnJava(HttpSession session) {
		
		if(session.getAttribute("firstTimeVisit")==null) {
			session.setAttribute("canAccessJava", false);
			session.setAttribute("canAccessPython", false);
			session.setAttribute("firstTimeVisit", true);
			
		}
		else if((Boolean)(session.getAttribute("firstTimeVisit"))==true){
			session.setAttribute("firstTimeVisit", false);
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
										
		return "IntroToJava";
	}
	
	@RequestMapping(value = "/python", 
	method = RequestMethod.GET)
	public String learnPython(HttpSession session) {
							
		if(session.getAttribute("firstTimeVisit")==null) {
			session.setAttribute("canAccessJava", false);
			session.setAttribute("canAccessPython", false);
			session.setAttribute("firstTimeVisit", true);
			
		}
		else if((Boolean)(session.getAttribute("firstTimeVisit"))==true){
			session.setAttribute("firstTimeVisit", false);
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return "IntroToPython";
	}
	
	// The visitBackgroundPage method can work as a servlet's doGet or doPost method.
	@RequestMapping(value = "/background", 
	method = RequestMethod.GET)
	public String visitBackgroundPage(HttpSession session) {
			
		if(session.getAttribute("firstTimeVisit")==null) {
			session.setAttribute("canAccessJava", false);
			session.setAttribute("canAccessPython", false);
			session.setAttribute("firstTimeVisit", true);
			
		}
		else if((Boolean)(session.getAttribute("firstTimeVisit"))==true){
			session.setAttribute("firstTimeVisit", false);
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}

		return "Background";
	}
	
	// The example given here is a bad one, it is for the demonstration purposes only.
	// The variable userName doesn't not have to match what was passed from a client in this case.
	@RequestMapping(value = "/contact", 
	method = RequestMethod.GET)
	public String visitContactsPage(HttpSession session) {
			
		if(session.getAttribute("firstTimeVisit")==null) {
			session.setAttribute("canAccessJava", false);
			session.setAttribute("canAccessPython", false);
			session.setAttribute("firstTimeVisit", true);
			
		}
		else if((Boolean)(session.getAttribute("firstTimeVisit"))==true){
			session.setAttribute("firstTimeVisit", false);
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return "ContactInfo";
	}
}
