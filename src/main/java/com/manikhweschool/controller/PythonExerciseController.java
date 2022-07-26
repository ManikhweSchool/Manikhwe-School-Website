package com.manikhweschool.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PythonExerciseController extends ExerciseController{
	
	public PythonExerciseController() {
		language = "Python";
	}
	
	@GetMapping(value = "/python/download/partone/chapterone/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterOneVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)1,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterone/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterOneCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)1,false,exercise);
		
	}
	
	
	@GetMapping(value = "/python/download/partone/chaptertwo/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwoVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)2,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptertwo/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwoCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)2,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterthree/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThreeVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)3,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterthree/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThreeCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)3,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterfour/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)4,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterfour/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)4,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterfive/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFiveVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)5,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterfive/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFiveCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)5,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptersix/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)6,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptersix/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)6,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterseven/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSevenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)7,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterseven/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSevenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)7,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptereight/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterEightVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)8,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptereight/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterEightCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)8,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapternine/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)9,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapternine/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)9,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterten/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)1,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterten/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)10,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptereleven/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterElevenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)11,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptereleven/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterElevenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)11,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptertwelve/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwelveVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)12,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chaptertwelve/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwelveCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)12,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterthirteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)13,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterthirteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterThirteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)13,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterfourteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)14,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partone/chapterfourteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFourteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)1, (byte)14,false,exercise);
		
	}
	/*********************End Of Part One********************/
	@GetMapping(value = "/python/download/parttwo/chapterfifteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterFifteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)15,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partwo/chapterfifteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterFifteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)15,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parttwo/chaptersixteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)16,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partwo/chaptersixteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSixteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)16,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parttwo/chapterseventeen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterSeventeenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)17,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partwo/chapterseventeen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterSeventeenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)17,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parttwo/chaptereighteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterEighteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)18,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partwo/chaptereighteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterEighteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)2, (byte)18,false,exercise);
		
	}
	/*********************End Of Part Two********************/
	@GetMapping(value = "/python/download/partthree/chapternineteen/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineteenVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)19,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chapternineteen/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterNineteenCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)19,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partthree/chaptertwenty/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)20,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chaptertwenty/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)20,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partthree/chaptertwentyone/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyOneVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)21,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chaptertwentyone/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyOneCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)21,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partthree/chaptertwentytwo/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyTwoVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)22,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chaptertwentytwo/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyTwoCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)22,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partthree/chaptertwentythree/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyThreeVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)23,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chaptertwentythree/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyThreeCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)23,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partthree/chaptertwentyfour/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFourVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)24,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chaptertwentyfour/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFourCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)24,false,exercise);
		
	}
	
	@GetMapping(value = "/python/download/partthree/chaptertwentyfive/video")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFiveVideo(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)25,true,exercise);
		
	}
	
	@GetMapping(value = "/python/download/parthree/chaptertwentyfive/code")
	public @ResponseBody ResponseEntity<byte[]> getChapterTwentyFiveCode(
	@RequestParam String exercise) throws IOException, URISyntaxException {
			
		return getResource((byte)3, (byte)25,false,exercise);
		
	}
	
	/*********************End Of Part Three********************/
	
}
