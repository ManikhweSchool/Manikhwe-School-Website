package com.manikhweschool;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.manikhweschool.model.JavaVisitationInfo;

// I need to know where do I specify initial parameters and listeners.
/* The class plays two roles, one as a tool for specifying 
 * what needs to be done before my web application begins 
 * and two as a tool for tracking user visitations and their 
 * clicks*/
@Component
public class SchoolContextListener implements ServletContextListener, Runnable {

	private JavaVisitationInfo javaVisitationInfo;
	
	private byte hour;
	
	private boolean dayHasPassed;
	
	private ServletContext sc;
	
	
	public SchoolContextListener() throws FileNotFoundException {

		
		javaVisitationInfo = new JavaVisitationInfo();
		hour = 0;
		dayHasPassed = true;
	}
	
	// Make my credentials available to all of my pages.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		if(sc==null)
			sc = event.getServletContext();
		else
			System.out.println("Context Initialized");
		
		synchronized(sc) {
			
			sc.setAttribute("javaVisitationInfo", javaVisitationInfo);
			
			String instructorName = sc.getInitParameter("instructorName");
			sc.setAttribute("instructorName", instructorName);
			
			String instructorSurname = sc.getInitParameter("instructorSurname");
			sc.setAttribute("instructorSurname", instructorSurname);
			
			String instructorEmail = sc.getInitParameter("instructorEmail");
			sc.setAttribute("instructorEmail", instructorEmail);
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
	@Override
	public void run() {
		
		try {
		while(true) {
			Thread.sleep(1000*60*60);
			//Thread.sleep(1000);
			hour++;
			if(hour==24) {
				hour = 0;
				dayHasPassed = true;
			}
			else if(dayHasPassed && 
			hour==1 && sc != null) {
				
				javaVisitationInfo = new JavaVisitationInfo();
				//sc.removeAttribute("javaVisitationInfo");
				sc.setAttribute("javaVisitationInfo", javaVisitationInfo);
				
			}
			System.out.println(hour);
			
		}
		}catch(InterruptedException ex) {
			
		}
		
	}
	
}
