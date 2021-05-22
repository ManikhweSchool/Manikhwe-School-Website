package com.manikhweschool.music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.service.ArtistService;

@Controller
public class ArtistController {

	@Autowired
	private ArtistService service;
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/artist", 
	method = RequestMethod.POST)*/
	public void saveArtist(Artist artsist) {
		service.saveArtist(artsist);
	}
	
	public void saveAllArtist(List<Artist> artists) {
		service.saveAllArtists(artists);
	}
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/artist/{id}", 
	method = RequestMethod.GET)*/
	public Optional<Artist> findArtist(String artistId){
		
		return service.findArtist(artistId);
	}
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/artist/name?artistName", 
	method = RequestMethod.GET)*/
	public Optional<Artist> find(String artistName){
		return service.find(artistName);
	}
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/artist", 
	method = RequestMethod.GET)*/
	public List<Artist> findAllArtist(){
		return service.findAllArtist();
	}

	public ArtistService getService() {
		return service;
	}

	public void setService(ArtistService service) {
		this.service = service;
	}
	
	
}

