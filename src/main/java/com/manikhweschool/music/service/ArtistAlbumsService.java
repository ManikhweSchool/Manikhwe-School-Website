package com.manikhweschool.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.manikhweschool.music.model.ArtistsAlbums;
import com.manikhweschool.music.repository.ArtistAlbumsRepository;

//@Service
public class ArtistAlbumsService {

	//@Autowired
	private ArtistAlbumsRepository repository;
	
	public HttpStatus saveArtistAlbums(ArtistsAlbums artistAlbums) {
		/*if(repository.findById(artistAlbums.getArtistAlbumsId()).isPresent())
			return HttpStatus.FOUND;
		repository.save(artistAlbums);*/
		return HttpStatus.CREATED;
	}
	
	public Optional<ArtistsAlbums> findArtistAlbums(long artistAlbumsId){
		//return repository.findById(artistAlbumsId);
		return null;
	}
	
	public List<ArtistsAlbums> findAllArtistAlbums(){
		//return repository.findAll();
		return null;
	}

	public ArtistAlbumsRepository getRepository() {
		return repository;
	}

	public void setRepository(ArtistAlbumsRepository repository) {
		this.repository = repository;
	}
}

