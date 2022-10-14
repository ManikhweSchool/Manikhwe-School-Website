package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhweschool.model.TodayVisitation;

@Controller
public class PythonChapterController {

	@RequestMapping(value="/python/part/one/{chapter}", method = RequestMethod.GET)
	public String visitPartOne( 
	@PathVariable("chapter") String chapter, 
	HttpSession session){
		
		String page = "Python/Part_One_Pages/Chapter";
		switch(chapter) {
		case "{1}" : 
			page += "One"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation")).
			getPythonVisitationInfo().
			increaseChapterOneDayVisitors();
			break;
		case "{2}" : 
			page += "Two"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation")).
			getPythonVisitationInfo().
			increaseChapterTwoDayVisitors();
			break;
		case "{3}" : 
			page += "Three"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterThreeDayVisitors();
			break;
		case "{4}" : 
			page += "Four"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterFourDayVisitors();	
			break;
		case "{5}" : 
			page += "Five"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterFiveDayVisitors();
			break;
		case "{6}" : 
			page += "Six"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterSixDayVisitors();
			break;
		case "{7}" : 
			page += "Seven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterSevenDayVisitors();
			break;
		case "{8}" : 
			page += "Eight"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterEightDayVisitors();
			break;
		case "{9}" : 
			page += "Nine"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterNineDayVisitors();
			break;
		case "{10}" : 
			page += "Ten"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTenDayVisitors();
			break;
		case "{11}" : 
			page += "Eleven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterElevenDayVisitors();
			break;
		case "{12}" : 
			page += "Twelve"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwelveDayVisitors();
			break;
		case "{13}" : 
			page += "Thirteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterThirteenDayVisitors();
			break;
		default : 
			page += "Fourteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation")).
			getPythonVisitationInfo().
			increaseChapterForteenDayVisitors();
		
		
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/python/part/two/{chapter}", method = RequestMethod.GET)
	public String visitPartTwo(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Python/Part_Two_Pages/Chapter";
		
		switch(chapter) {
		case "{15}" : 
			page += "Fiftheen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterFifteenDayVisitors();
			break;
		case "{16}" : 
			page += "Sixteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterSixteenDayVisitors();
			break;
		case "{17}" : 
			page += "Seventeen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterSeventeenDayVisitors();
			break;
		default : 
			page += "Eighteen";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterEighteenDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/python/part/three/{chapter}", method = RequestMethod.GET)
	public String visitPartThree(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Python/Part_Three_Pages/Chapter";
		
		switch(chapter) {
		case "{19}" : 
			page += "Nineteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterNinteenDayVisitors();
			break;
		case "{20}" : 
			page += "Twenty"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwentyDayVisitors();
			break;
		case "{21}" : 
			page += "TwentyOne"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwentyOneDayVisitors();
			break;
		case "{22}" : 
			page += "TwentyTwo"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwentyTwoDayVisitors();
			break;
		case "{23}" : 
			page += "TwentyThree"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwentyThreeDayVisitors();
			break;
		case "{24}" : 
			page += "TwentyFour"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwentyFourDayVisitors();
			break;
		default : 
			page += "TwentyFive";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getPythonVisitationInfo()
			.increaseChapterTwentyFiveDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
}
