package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhweschool.model.TodayVisitation;

@Controller
public class DartChapterController {


	
	@RequestMapping(value="/dart/part/one/{chapter}", method = RequestMethod.GET)
	public String visitPartOne(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Dart/Part_One_Pages/Chapter";
		switch(chapter) {
		case "{1}" : 
			page += "One"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterOneDayVisitors();
			break;
		case "{2}" : 
			page += "Two"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwoDayVisitors();
			break;
		case "{3}" : 
			page += "Three"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterThreeDayVisitors();
			break;
		case "{4}" : 
			page += "Four"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterFourDayVisitors();
			break;
		case "{5}" : 
			page += "Five"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterFiveDayVisitors();
			break;
		case "{6}" : 
			page += "Six"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterSixDayVisitors();
			break;
		case "{7}" : 
			page += "Seven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterSevenDayVisitors();
			break;
		case "{8}" : 
			page += "Eight";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterEightDayVisitors();
			break;
		case "{9}" : 
			page += "Nine"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterNineDayVisitors();
			break;
		case "{10}" : 
			page += "Ten"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTenDayVisitors();
			break;
		default : 
			page += "Eleven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterElevenDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/dart/part/two/{chapter}", method = RequestMethod.GET)
	public String visitPartTwo(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Dart/Part_Two_Pages/Chapter";
		
		switch(chapter) {
		
		case "{12}" : 
			page += "Twelve"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwelveDayVisitors();
			break;
		case "{13}" : 
			page += "Thirteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterThirteenDayVisitors();
			break;
		case "{14}" : 
			page += "Fourteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterForteenDayVisitors();
			break;
		case "{15}" : 
			page += "Fiftheen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterFifteenDayVisitors();
			break;
		
		case "{16}" : 
			page += "Sixteen";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterSixteenDayVisitors();
		default : 
			page += "Seventeen";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterSeventeenDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/dart/part/three/{chapter}", method = RequestMethod.GET)
	public String visitPartThree(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Dart/Part_Three_Pages/Chapter";
		
		switch(chapter) {
		case "{18}" : 
			page += "Eightheen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterEighteenDayVisitors();
			break;
		case "{19}" : 
			page += "Nineteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterNinteenDayVisitors();
			break;
		case "{20}" : 
			page += "Twenty"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwentyDayVisitors();
			break;
		case "{21}" : 
			page += "TwentyOne"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwentyOneDayVisitors();
			break;
		case "{22}" : 
			page += "TwentyTwo"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwentyTwoDayVisitors();
			break;
		case "{23}" : 
			page += "TwentyThree"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwentyThreeDayVisitors();
			break;
		default : 
			page += "TwentyFour"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getDartVisitationInfo()
			.increaseChapterTwentyFourDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
}
