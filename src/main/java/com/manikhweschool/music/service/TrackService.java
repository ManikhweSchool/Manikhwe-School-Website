package com.manikhweschool.music.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Track;
import com.manikhweschool.music.repository.TrackRepository;

//@Service
public class TrackService {

	//@Autowired
	private TrackRepository repository;
	
	public Track saveTrack(Track track) { 
		//return repository.save(track);
		return null;
	}
	
	public void saveAll(Collection<Track> tracks) {
		//repository.saveAll(tracks);
	}
	
	public Optional<Track> findTrack(String trackId){
		//return repository.findById(trackId);
		return null;
	}
	
	public List<Track> findAllTracks(){
		//return repository.findAll();
		return null;
	}
	
	public String findTrackId(Set<Artist> artists, 
	String musicTitle) {
		List<Track> allMusic = findAllTracks();
				
		for(Track music : allMusic) {
			Track clone;
			try {
				clone = (Track) music.clone();
				clone.setArtists(artists);
				clone.setTrackName(musicTitle);
				if(music.equals(clone)) {
					return 
					music.getTrackURL();
				}
			} catch (CloneNotSupportedException e) {
						
				e.printStackTrace();
			}
		}
		return "";
	}

	public TrackRepository getRepository() {
		return repository;
	}

	public void setRepository(TrackRepository repository) {
		this.repository = repository;
	}
	
	
}

