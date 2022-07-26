package com.manikhweschool.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DartExerciseController extends ExerciseController{

	
	public DartExerciseController() {
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterone/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterOneVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)1,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterone/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterOneCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)1,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chaptertwo/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwoVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)2,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chaptertwo/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwoCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)2,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterthree/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThreeVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)3,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterthree/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThreeCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)3,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterfour/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)4,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterfour/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)4,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterfive/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFiveVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)5,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterfive/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFiveCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)5,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chaptersix/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)6,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chaptersix/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)6,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterseven/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSevenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)7,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterseven/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSevenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)7,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chaptereight/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterEightVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)8,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chaptereight/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterEightCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)8,false,exercise);
		
	}
	
	
	@GetMapping(value = "/dart/download/partone/chapternine/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)9,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapternine/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)9,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterten/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)10,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partone/chapterten/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)10,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parteleven/chaptereleven/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterElevenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)11,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parteleven/chaptereleven/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterElevenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)11,false,exercise);
		
	}
	
	/*********************End Of Part One********************/
	
	@GetMapping(value = "/dart/download/parttwo/chaptertwelve/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwelveVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)12,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partwo/chaptertwelve/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwelveCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)12,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parttwo/chapterthirteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)13,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partwo/chapterthirteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)13,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parttwo/chapterseventeen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSeventeenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)17,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partwo/chapterseventeen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSeventeenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)17,false,exercise);
		
	}
	/*********************End Of Part Two********************/
	
	@GetMapping(value = "/dart/download/partthree/chapterfourteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)14,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parthree/chapterfourteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)14,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partthree/chapterfifteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFifteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)15,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parthree/chapterfifteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFifteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)15,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partthree/chaptersixteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)16,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/parthree/chaptersixteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)16,false,exercise);
		
	}
	
	/*********************End Of Part Three********************/
	
	@GetMapping(value = "/dart/download/partfour/chaptereighteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterEighteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)18,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptereighteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterEighteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)18,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chapternineteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)19,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chapternineteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)19,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwenty/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)20,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwenty/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)20,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyone/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyOneVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)21,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyone/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyOneCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)21,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentytwo/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyTwoVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)22,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentytwo/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyTwoCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)22,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentythree/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyThreeVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)23,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentythree/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyThreeCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)23,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyfour/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFourVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)24,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyfour/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFourCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)24,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyfive/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFiveVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)25,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyfive/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFiveCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)25,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentysix/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentySixVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)26,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentysix/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentySixCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)26,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyseven/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentySevenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)27,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyseven/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentySevenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)27,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyeight/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyEightVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)28,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentyeight/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyEightCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)28,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentynine/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyNineVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)29,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfour/chaptertwentynine/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyNineCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)4, (byte)29,false,exercise);
		
	}
	/*********************End Of Part Four********************/
	
	@GetMapping(value = "/dart/download/partfive/chapterthirty/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)30,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirty/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)30,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirtyone/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyOneVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)31,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirtyone/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyOneCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)31,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirtytwo/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyTwoVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)32,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirtytwo/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyTwoCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)32,false,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirtythree/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyThreeVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)33,true,exercise);
		
	}
	
	@GetMapping(value = "/dart/download/partfive/chapterthirtythree/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirtyThreeCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)5, (byte)33,false,exercise);
		
	}
	/*********************End Of Part Five********************/
	
}