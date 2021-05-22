package com.manikhweschool;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.manikhweschool.music.controller.extraction.AlbumExtractionTask;
import com.manikhweschool.music.controller.extraction.ArtistAlbumsExtractionTask;
import com.manikhweschool.music.controller.extraction.ArtistExtractionTask;
import com.manikhweschool.music.controller.extraction.SeveralAlbumsExtractionTask;
import com.manikhweschool.music.controller.extraction.SeveralArtistsExtractionTask;
import com.manikhweschool.music.controller.extraction.TrackExtractionTask;
import com.manikhweschool.music.model.Artist;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Autowired
	private ApplicationContext ctx;
	
	private ArrayList<Artist> storedArtists;
	
	public LoadDatabase() {
		
	}
	
	@Bean
	CommandLineRunner initDatabase() {
	  return args -> {
		 
          populateDatabase();
		 
	  };
	}
	
	public void populateDatabase() {
		
		// Step 1 - Fetch And Save Several Artists.          
        storedArtists = fetchManyArtists();
 
        /*Step 2 - Fetch Artist Albums And
         * Store Albums' Ids In The File For 
         * Each Artist.
         * */
        fetchManyArtistAlbums();
        
        /*Step 3 - Fetch Several Albums Based
         * On The Given Artists.*/
        fetchManyAlbums();
	}
	
	private void fetchTrackByTrack() {
		TrackExtractionTask trackExtractionTask = 
		(TrackExtractionTask)ctx.getBean("trackExtractionTask");
		
		Thread thread = new Thread(trackExtractionTask);
		thread.start();
	}
	
	private void fetchByArtist() {
		
		ArtistExtractionTask artistExtractionTask = 
		(ArtistExtractionTask)ctx.getBean("artistExtractionTask");
				
		Thread thread = new Thread(artistExtractionTask);
		thread.start();
	}
	
	private void fetchSeveralArtists() {
		
		SeveralArtistsExtractionTask severalArtistExtractionTask = 
		(SeveralArtistsExtractionTask)ctx.getBean(
		SeveralArtistsExtractionTask.class);
				
		Thread thread = new Thread(severalArtistExtractionTask);
		thread.start();
	}
	
	private ArrayList<Artist> fetchManyArtists() {
		
		SeveralArtistsExtractionTask severalArtistExtractionTask = 
		(SeveralArtistsExtractionTask)ctx.getBean(
		SeveralArtistsExtractionTask.class);
		
		severalArtistExtractionTask.justFetch();
		
		return severalArtistExtractionTask.getArtists();
	}
	
	private void fetchManyArtistAlbums() {
		
		ArtistAlbumsExtractionTask 
		artistAlbumsExtractionTask = 
		(ArtistAlbumsExtractionTask)ctx.getBean(
		ArtistAlbumsExtractionTask.class);

		artistAlbumsExtractionTask.setStoredArtists(
		storedArtists);
		artistAlbumsExtractionTask.justFetch();

	}

	private void fetchManyAlbums() {
		
		SeveralAlbumsExtractionTask 
		severalAlbumsExtractionTask = 
		(SeveralAlbumsExtractionTask)ctx.getBean(
		SeveralAlbumsExtractionTask.class);

		severalAlbumsExtractionTask.setStoredArtists(
		(ArrayList<Artist>)storedArtists);
		severalAlbumsExtractionTask.justFetch();
	}
	
	private void fetchAlbumByAlbum() {
		
		AlbumExtractionTask albumExtractionTask = 
		(AlbumExtractionTask)ctx.getBean("albumExtractionTask");

		Thread thread = new Thread(albumExtractionTask);
		thread.start();
	}
	
	private void fetchSeveralAlbums() {
		
		SeveralAlbumsExtractionTask severalAlbumsExtractionTask = 
		(SeveralAlbumsExtractionTask)ctx.getBean("severalAlbumsExtractionTask");

		Thread thread = new Thread(severalAlbumsExtractionTask);
		thread.start();
	}
	
	private void fetchArtistAlbums() {
		
		ArtistAlbumsExtractionTask artistAlbumsExtractionTask = 
		(ArtistAlbumsExtractionTask)ctx.getBean(ArtistAlbumsExtractionTask.class);

		Thread thread = new Thread(artistAlbumsExtractionTask);
		thread.start();
	}
}
