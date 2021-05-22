package com.manikhweschool.music.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.music.model.Album;
import com.manikhweschool.music.model.Track;
import com.manikhweschool.music.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository repository;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private TrackService trackService;
	
	public void saveAlbum(Album album) {
		
		artistService.saveAllArtists(album.getArtists());
		
		Collection<Track> allTracks = album.getTracks();
		
		for(Track track : allTracks) {
			track.setAlbum(album);
			
		}
		
		trackService.saveAll(allTracks);
		
		repository.save(album);
	}
	
	public void saveAllAlbums(List<Album> albums) {
		repository.saveAll(albums);
	}
	
	public List<Album> findAllAlbums(){
		
		return repository.findAll();
	}
	
	public Optional<Album> findAlbum(String id){
		
		return repository.findById(id);
	}
	
	public Optional<Album> findAlbumByName(String albumName){
		
		List<Album> albums = findAllAlbums();
		
		for(Album album : albums)
			if(album.getAlbumName().equalsIgnoreCase(albumName))
				return findAlbum(album.getAlbumId());
		return null;
	}

	public AlbumRepository getRepository() {
		return repository;
	}

	public void setRepository(AlbumRepository repository) {
		this.repository = repository;
	}
	
	
}
