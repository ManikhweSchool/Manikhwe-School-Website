package com.manikhweschool;

import java.io.FileNotFoundException;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manikhweschool.controller.TodayVisitationController;
import com.manikhweschool.model.DartVisitationInfo;
import com.manikhweschool.model.JavaVisitationInfo;
import com.manikhweschool.model.PythonVisitationInfo;
import com.manikhweschool.model.TodayVisitation;

/* The class plays two roles, one as a tool for specifying 
 * what needs to be done before my web application begins 
 * and two as a tool for tracking user visitations and their 
 * clicks*/
@Component
public class SchoolContextListener implements ServletContextListener, Runnable {

	private TodayVisitation todayVisitation;
	
	private byte day;
	private boolean monthHasPassed;
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private TodayVisitationController controller;
	
	
	public SchoolContextListener() throws FileNotFoundException {

		day = 0;
		monthHasPassed = false;
		todayVisitation = new TodayVisitation(
		new GregorianCalendar(),
		new JavaVisitationInfo(),
		new PythonVisitationInfo(),
		new DartVisitationInfo());
	}
	
	// Make my credentials available to all of my pages.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		synchronized(sc) {
			
			sc.setAttribute("todayVisitation", todayVisitation);
			new Thread(this).start();
		}
		
		
	   	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
	@Override
	public void run() {
		
		try {
		while(true) {
			
			Thread.sleep(1000*60*60*24);
			
			day++;

			if(day==30) {

				monthHasPassed = true;
				day = 0;
				
			}
			else if(monthHasPassed && day==1) {
				
				controller.save((TodayVisitation)sc.getAttribute("todayVisitation"));
				sc.setAttribute("todayVisitation", 
					new TodayVisitation(
						new GregorianCalendar(),
						new JavaVisitationInfo(),
						new PythonVisitationInfo(),
						new DartVisitationInfo()
					)
				);
			}
			
		}
		}catch(InterruptedException ex) {
			
		}
		
	}
	
}
