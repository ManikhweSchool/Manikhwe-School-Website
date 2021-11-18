package com.manikhweschool.music.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manikhweschool.music.model.Track;
import com.manikhweschool.music.model.Rhythm;
import com.manikhweschool.music.service.TrackService;
import com.manikhweschool.music.service.RhythmService;

//@Controller
public class RhythmController {

	//@Autowired
	private RhythmService rhythmService;
	
	//@Autowired
	private TrackService musicService;
	
	
	/*@RequestMapping(value = "/manikhweschool/"
	+ "tracks/{trackId}/rhythms}", 
	method = RequestMethod.POST)*/
	public HttpStatus saveRhythm(
	@RequestParam String trackId,
	Rhythm newRhythm){
				
		Optional<Track> optionalMusic = musicService.findTrack(trackId);
		if(optionalMusic.isPresent()) {
					
			optionalMusic.get().addRhythm(newRhythm);
			rhythmService.saveRhythm(newRhythm);
			// Resource Created.
			return HttpStatus.ACCEPTED;
		}
				
		// Resource Not Created.
		return HttpStatus.UNAUTHORIZED;
				
	}
	
	@RequestMapping(value = "/manikhweschool/"
	+ "tracks/{trackId}/rhythms/{rhythmId}}", 
	method = RequestMethod.GET)
	public Rhythm findRhythm(
	@RequestParam String trackId,
	@PathVariable int rhythmIndex){
		
		Optional<Track> optionalMusic = musicService.findTrack(trackId);
		if(optionalMusic.isPresent()) {
			
			// Resource Found.
			return 
			optionalMusic.get().getRhythm(rhythmIndex);
			
		}
		
		// Resource Not Found.
		return null;
		
		
	}
	
	@RequestMapping(value = "/manikhweschool"
	+ "/rhythms}", method = RequestMethod.GET)
	public List<Rhythm> findRhythms(){
		
		// Resource Found.
		return 
		rhythmService.findAllRhythms();
	}
	
	@RequestMapping(value = "/manikhweschool/"
	+ "tracks/{trackId}/rhythms}", 
	method = RequestMethod.GET)
	public List<Rhythm> findRhythms(
	@PathVariable String trackId){
		Optional<Track> optionalMusic = musicService.findTrack(trackId);
		if(optionalMusic.isPresent()) {
			
			List<Rhythm> rhythms = (List<Rhythm>) optionalMusic.get().getRhythms();
			
			// Resource Found.
			return rhythms;
		}
		
		// Resource Not Found.
		return new ArrayList<>();
	}
}


