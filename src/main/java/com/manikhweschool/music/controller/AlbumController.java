package com.manikhweschool.music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.manikhweschool.music.model.Album;
import com.manikhweschool.music.service.AlbumService;

@Controller
public class AlbumController {

	@Autowired
	private AlbumService service;
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/album", 
	method = RequestMethod.POST)*/
	public void saveAlbum(Album album) {
		
		service.saveAlbum(album);
	}
	
	public void saveAllAlbums(List<Album> albums) {
		service.saveAllAlbums(albums);
	}
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/album", 
	method = RequestMethod.GET)*/
	public List<Album> findAllAlbums(){
		
		return service.findAllAlbums();
	}
	
	/*@RequestMapping(value = "http://api.musicpatternrecognition.com"
	+ "/album/{id}", 
	method = RequestMethod.GET)*/
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

