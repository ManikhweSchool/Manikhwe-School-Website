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

import com.manikhweschool.music.model.Album;
import com.manikhweschool.music.model.Track;
import com.manikhweschool.music.service.AlbumService;

//@Controller
public class AlbumController {

	//@Autowired
	private AlbumService service;
	
	/*@RequestMapping(value ="/album?name=albumName", 
	method = RequestMethod.GET)*/
	public List<Track> findAlbumTracks(
	Model model, 
	@RequestParam("albumName") String albumName){
		
		List<Album> albums = findAllAlbums();
		
		List<Track> allTracks = new ArrayList<>();
		int count = 0;
		
		for(Album album : albums) {
			if(album.getAlbumName().equalsIgnoreCase(albumName))
				allTracks.addAll(album.getTracks());
			count++;
		}
		
		model.addAttribute("album_tracks", allTracks);
		
		if(count==0)
			model.addAttribute("album_status", "Album Doesn't Exist.");
		else if(count==1) 
			model.addAttribute("album_status", "Album Exist.");
		else
			model.addAttribute("album_status", "Multiple Albums Exist.");
		
		return allTracks;
		
	}
	
	public void saveAlbum(Album album) {
		
		service.saveAlbum(album);
	}
	
	public void saveAllAlbums(List<Album> albums) {
		service.saveAllAlbums(albums);
	}
	
	public List<Album> findAllAlbums(){
		
		return service.findAllAlbums();
	}
	
	
	public Optional<Album> findAlbum(String albumId){
		
		return service.findAlbum(albumId);
	}

	public AlbumService getService() {
		return service;
	}

	public void setService(AlbumService service) {
		this.service = service;
	}
}

