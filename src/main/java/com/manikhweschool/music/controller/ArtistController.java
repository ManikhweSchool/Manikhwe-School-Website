package com.manikhweschool.music.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Track;
import com.manikhweschool.music.service.ArtistService;

@Controller
public class ArtistController {

	@Autowired
	private ArtistService service;
	
	@RequestMapping(value ="/artist?name=artistName", 
	method = RequestMethod.GET)
	public List<Track> findArtistTracks(
	Model model, 
	@RequestParam("artistName") String artistName){
		
		List<Artist> artists = findAllArtist();
		List<Track> allTracks = new ArrayList<>();
		
		int count = 0;
		
		for(Artist artist : artists) {
			if(artist.getArtistName().equalsIgnoreCase(artistName))
				allTracks.addAll(artist.getTracks());
			count++;
		}
		
		model.addAttribute("artist_tracks", allTracks);
		
		if(count==0)
			model.addAttribute("artist_status", "Artist Doesn't Exist.");
		else if(count==1) 
			model.addAttribute("artist_status", "Artist Exist.");
		else
			model.addAttribute("artist_status", "Multiple Artists Exist.");
		
		return allTracks;
	}
	
	public void saveArtist(Artist artsist) {
		service.saveArtist(artsist);
	}
	
	public void saveAllArtist(List<Artist> artists) {
		service.saveAllArtists(artists);
	}
	
	public Optional<Artist> findArtist(String artistId){
		
		return service.findArtist(artistId);
	}
	
	public Optional<Artist> find(String artistName){
		return service.find(artistName);
	}
	
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

