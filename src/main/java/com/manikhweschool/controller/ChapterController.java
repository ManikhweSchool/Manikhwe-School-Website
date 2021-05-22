package com.manikhweschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChapterController {

	@RequestMapping(value="/part/one/{chapter}", method = RequestMethod.GET)
	public String visitPartOne(@PathVariable("chapter") String chapter){
		
		String page = "Part_One_Pages/Chapter";
		switch(chapter) {
		case "{1}" : page += "One"; break;
		case "{2}" : page += "Two"; break;
		case "{3}" : page += "Three"; break;
		case "{4}" : page += "Four"; break;
		case "{5}" : page += "Five"; break;
		case "{6}" : page += "Six"; break;
		case "{7}" : page += "Seven"; break;
		default : page += "Eight";
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/two/{chapter}", method = RequestMethod.GET)
	public String visitPartTwo(@PathVariable("chapter") String chapter){
		
		String page = "Part_Two_Pages/Chapter";
		
		switch(chapter) {
		case "{9}" : page += "Nine"; break;
		case "{10}" : page += "Ten"; break;
		case "{11}" : page += "Eleven"; break;
		case "{12}" : page += "Twelve"; break;
		case "{13}" : page += "Thirteen"; break;
		default : page += "Seventeen";
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/three/{chapter}", method = RequestMethod.GET)
	public String visitPartThree(@PathVariable("chapter") String chapter){
		
		String page = "Part_Three_Pages/Chapter";
		
		switch(chapter) {
		case "{14}" : page += "Fourteen"; break;
		case "{15}" : page += "Fiftheen"; break;
		
		default : page += "Sixteen";
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/four/{chapter}", method = RequestMethod.GET)
	public String visitPartFour(@PathVariable("chapter") String chapter){
		
		String page = "Part_Four_Pages/Chapter";
		
		switch(chapter) {
		case "{18}" : page += "Eightheen"; break;
		case "{19}" : page += "Nineteen"; break;
		case "{20}" : page += "Twenty"; break;
		case "{21}" : page += "TwentyOne"; break;
		case "{22}" : page += "TwentyTwo"; break;
		case "{23}" : page += "TwentyThree"; break;
		case "{24}" : page += "TwentyFour"; break;
		case "{25}" : page += "TwentyFive"; break;
		case "{26}" : page += "TwentySix"; break;
		case "{27}" : page += "TwentySeven"; break;
		case "{28}" : page += "TwentyEight"; break;
		default : page += "TwentyNine";
		}
		
		return page;
	}
	
	@RequestMapping(value="/part/five/{chapter}", method = RequestMethod.GET)
	public String visitPartFive(@PathVariable("chapter") String chapter){
		
		String page = "Part_Five_Pages/Chapter";
		
		switch(chapter) {
		case "{30}" : page += "Thirty"; break;
		case "{31}" : page += "ThirtyOne"; break;
		case "{32}" : page += "ThirtyTwo"; break;
		default : page += "ThirtyThree";
		}
		
		return page;
	}
}
