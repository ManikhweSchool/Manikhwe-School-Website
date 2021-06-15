package com.manikhweschool;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.manikhweschool.model.TodayVisitation;

public class SchoolSessionListener implements HttpSessionListener {


	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session Created...");
		
		System.out.println("Java Chapter One Visitors : " + 
		((TodayVisitation)event.getSession()
		.getServletContext().getAttribute(
		"todayVisitation"))
		.getJavaVisitationInfo().getChapterOneDayVisitors());
				
		System.out.println("Python Chapter One Visitors : " + 
		((TodayVisitation)event.getSession()
		.getServletContext().getAttribute(
		"todayVisitation"))
		.getPythonVisitationInfo().getChapterOneDayVisitors());
		
		((TodayVisitation)event.getSession()
		.getServletContext().getAttribute(
		"todayVisitation")).increaseDayVisitorNumber();
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session Destroyed...");
		
		System.out.println("Java Chapter One Visitors : " + 
		((TodayVisitation)event.getSession()
		.getServletContext().getAttribute(
		"todayVisitation"))
		.getJavaVisitationInfo().getChapterOneDayVisitors());
		
		System.out.println("Python Chapter One Visitors : " + 
		((TodayVisitation)event.getSession()
		.getServletContext().getAttribute(
		"todayVisitation"))
		.getPythonVisitationInfo().getChapterOneDayVisitors());
	}
}
