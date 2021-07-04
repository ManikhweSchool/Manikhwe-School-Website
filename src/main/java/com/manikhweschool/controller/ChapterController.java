package com.manikhweschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manikhweschool.model.TodayVisitation;

@Controller
public class ChapterController {

	@RequestMapping(value="/python/part/one/{chapter}", method = RequestMethod.GET)
	public String visitPythonPartOne(
	@PathVariable("chapter") String chapter, HttpSession session){
		
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
			page += "Forteen"; 
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
	public String visitPythonPartTwo(
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
	public String visitPythonPartThree(
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
	
	@RequestMapping(value="/part/one/{chapter}", method = RequestMethod.GET)
	public String visitPartOne(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Part_One_Pages/Chapter";
		switch(chapter) {
		case "{1}" : 
			page += "One"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterOneDayVisitors();
			break;
		case "{2}" : 
			page += "Two"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwoDayVisitors();
			break;
		case "{3}" : 
			page += "Three"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterThreeDayVisitors();
			break;
		case "{4}" : 
			page += "Four"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterFourDayVisitors();
			break;
		case "{5}" : 
			page += "Five"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterFiveDayVisitors();
			break;
		case "{6}" : 
			page += "Six"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterSixDayVisitors();
			break;
		case "{7}" : 
			page += "Seven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterSevenDayVisitors();
			break;
		default : 
			page += "Eight";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterEightDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/two/{chapter}", method = RequestMethod.GET)
	public String visitPartTwo(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Part_Two_Pages/Chapter";
		
		switch(chapter) {
		case "{9}" : 
			page += "Nine"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterNineDayVisitors();
			break;
		case "{10}" : 
			page += "Ten"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTenDayVisitors();
			break;
		case "{11}" : 
			page += "Eleven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterElevenDayVisitors();
			break;
		case "{12}" : 
			page += "Twelve"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwelveDayVisitors();
			break;
		case "{13}" : 
			page += "Thirteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterThirteenDayVisitors();
			break;
		default : 
			page += "Seventeen";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterSeventeenDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/three/{chapter}", method = RequestMethod.GET)
	public String visitPartThree(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Part_Three_Pages/Chapter";
		
		switch(chapter) {
		case "{14}" : 
			page += "Fourteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterForteenDayVisitors();
			break;
		case "{15}" : 
			page += "Fiftheen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterFifteenDayVisitors();
			break;
		
		default : 
			page += "Sixteen";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterSixteenDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/four/{chapter}", method = RequestMethod.GET)
	public String visitPartFour(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Part_Four_Pages/Chapter";
		
		switch(chapter) {
		case "{18}" : 
			page += "Eightheen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterEighteenDayVisitors();
			break;
		case "{19}" : 
			page += "Nineteen"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterNinteenDayVisitors();
			break;
		case "{20}" : 
			page += "Twenty"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyDayVisitors();
			break;
		case "{21}" : 
			page += "TwentyOne"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyOneDayVisitors();
			break;
		case "{22}" : 
			page += "TwentyTwo"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyTwoDayVisitors();
			break;
		case "{23}" : 
			page += "TwentyThree"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyThreeDayVisitors();
			break;
		case "{24}" : 
			page += "TwentyFour"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyFourDayVisitors();
			break;
		case "{25}" : 
			page += "TwentyFive"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyFiveDayVisitors();
			break;
		case "{26}" : 
			page += "TwentySix"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentySixDayVisitors();
			break;
		case "{27}" : 
			page += "TwentySeven"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentySevenDayVisitors();
			break;
		case "{28}" : 
			page += "TwentyEight"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyEightDayVisitors();
			break;
		default : 
			page += "TwentyNine";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterTwentyNineDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/five/{chapter}", method = RequestMethod.GET)
	public String visitPartFive(
	@PathVariable("chapter") String chapter,
	HttpSession session){
		
		String page = "Part_Five_Pages/Chapter";
		
		switch(chapter) {
		case "{30}" : 
			page += "Thirty"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterThirtyDayVisitors();
			break;
		case "{31}" : 
			page += "ThirtyOne"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterThirtyOneDayVisitors();
			break;
		case "{32}" : 
			page += "ThirtyTwo"; 
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterThirtyTwoDayVisitors();
			break;
		default : 
			page += "ThirtyThree";
			((TodayVisitation)session.getServletContext()
			.getAttribute("todayVisitation"))
			.getJavaVisitationInfo()
			.increaseChapterThirtyThreeDayVisitors();
		}
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			
		}
		
		return page;
	}
}
