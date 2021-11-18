package com.manikhweschool.music.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;

import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Track;
import com.manikhweschool.music.service.TrackService;

//@Controller
public class TrackController {
	
	//@Autowired
	private TrackService service;
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/music", 
	method = RequestMethod.POST)*/
	public HttpStatus saveMusic(Track track) {
		
		List<Track> allMusic = service.findAllTracks();
		
		boolean musicExist = false;
		
		for(Track m : allMusic)
			if(track.equals(m)) {
				musicExist = true;
				break;
			}
		
		if(!musicExist) {
	
			service.saveTrack(track);
			
			// Resource Created.
			return HttpStatus.CREATED;
		}

		// Resource Wasn't Created.
		return HttpStatus.UNAUTHORIZED;
	}
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/music?participants=artists&title=musicTitle", 
	method = RequestMethod.GET)*/
	public Track findMusic(
	/*@RequestParam */Set<Artist> artists,
	/*@RequestParam */String trackName){
		
		List<Track> allMusic = 
		service.findAllTracks();
		
		for(Track music : allMusic) {
			Track clone;
			try {
				clone = (Track) music.clone();
				clone.setArtists(artists);
				clone.setTrackName(trackName);
				if(music.equals(clone)) {
					return 
					music;
				}
			} catch (CloneNotSupportedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
					
	/*@RequestMapping(value = "http://api.patternrecognition.com"
	+ "/music", method = RequestMethod.GET)*/
	public List<Track> findAllTracks(){
			
		// Resource Found.
		return service.findAllTracks();
	}

	public TrackService getService() {
		return service;
	}

	public void setService(TrackService service) {
		this.service = service;
	}
	
	
}

