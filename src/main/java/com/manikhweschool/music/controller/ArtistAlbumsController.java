package com.manikhweschool.music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.manikhweschool.music.model.ArtistsAlbums;
import com.manikhweschool.music.service.ArtistAlbumsService;

@Controller
public class ArtistAlbumsController {

	@Autowired
	private ArtistAlbumsService service;
	
	public HttpStatus saveArtistAlbums(ArtistsAlbums artistAlbums) {
		
		return service.saveArtistAlbums(artistAlbums);
	}
	
	public Optional<ArtistsAlbums> findArtistAlbums(long artistAlbumsId){
		return service.findArtistAlbums(artistAlbumsId);
	}
	
	public List<ArtistsAlbums> findAllArtistAlbums(){
		return service.findAllArtistAlbums();
	}

	public ArtistAlbumsService getService() {
		return service;
	}

	public void setService(ArtistAlbumsService service) {
		this.service = service;
	}
}

