package com.manikhweschool;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.manikhweschool.model.VisitationInfo;

public class SchoolSessionListener implements HttpSessionListener {

	
	
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session Created...");
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session Destroyed...");
	}
}
