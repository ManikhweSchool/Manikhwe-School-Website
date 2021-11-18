package com.manikhweschool.music.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.repository.ArtistRepository;

//@Service
public class ArtistService {

	//@Autowired
	private ArtistRepository repository;
	
	
	public void saveArtist(Artist artist) {
		//repository.save(artist); 
		
	}
	
	public void saveAllArtists(Collection<Artist> artists) {
		//repository.saveAll(artists);
	}
	
	public Optional<Artist> findArtist(String id){
		return null;
		//return repository.findById(id);
	}
	
	public Optional<Artist> find(String artistName){
		
		/*List<Artist> allArtists = repository.findAll();
		
		for(Artist a : allArtists) 
			if(a.getArtistName().equalsIgnoreCase(artistName))
				return findArtist(a.getArtistId());*/
		
		
		return null;
	}
	
	
	public List<Artist> findAllArtist(){
		//return repository.findAll();
		return null;
	}

	public ArtistRepository getRepository() {
		return repository;
	}

	public void setRepository(ArtistRepository repository) {
		this.repository = repository;
	}
	
	
}

