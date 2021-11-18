package com.manikhweschool.music.controller.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manikhweschool.music.controller.AlbumController;
import com.manikhweschool.music.controller.ArtistController;
import com.manikhweschool.music.controller.TrackController;
import com.manikhweschool.music.model.Album;
import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Image;
import com.manikhweschool.music.model.Track;

//@Component
public class AlbumExtractionTask extends ExtractionTask{

	//@Autowired
	private AlbumController albumController;
	
	//@Autowired
	private TrackController trackController;
	
	//@Autowired
	private ArtistController artistController;
	
	private Album album;
	ArrayList<Artist> artists = new ArrayList<>();
	
	ArrayList<Artist> trackArtists = new ArrayList<>();
	ArrayList<Track> albumTracks = new ArrayList<>(); // Album tracks
 	
	public AlbumExtractionTask() {
		
	}
	
	// Need To Modify It Later.
	@Override
	protected void fillFileNames() {
		
		int i = 1;
		
		while(i > 0) {
			fileNames.add("C:\\Users\\Test\\OneDrive\\Documents\\My-God's-Path-On-Earth\\Manikhwe Programming School\\Manikhwe-Programming-School\\src\\main\\java\\com\\manikhweschool\\music\\controller\\extraction\\ForAlbum.json");
			i--;
		}
	}

	@Override
	protected void fetch() {
		
		if(fileNameIndex < fileNames.size()) {
			file = new File(fileNames.get(fileNameIndex++));
			
			try {
				scanner = new Scanner(file);
				album = new Album();
				
				dealWithArtists();
				dealWithAlbum();
				dealWithManyTracks();
				dealWithAlbumLastInfo();
							
				albumController.saveAlbum(album);
				
				for(Track track : albumTracks) {
					track.setAlbum(album);
					trackController.saveMusic(track);
					
				}
				album.setTracks(albumTracks);
				
				for(Artist artist : artists)
					artist.getAlbums().add(album);
				artistController.saveAllArtist(artists);
				album.setArtists(artists);
				
				int i = 0;
				
				for(Track track : (ArrayList<Track>) album.getTracks()) {
					
					while(i<trackArtists.size() && trackArtists.get(i) != null) {
						Artist artist = trackArtists.get(i++);
						artist.getAlbums().add(album);
						track.setAlbum(album);
						trackController.saveMusic(track);
						artist.getTracks().add(track);
						artistController.saveArtist(artist);
						track.addArtist(artist);
					}
					i++;
				}
				
				scanner.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	private void dealWithArtists() {
		
		boolean hasRichedEnd = false;
		
		Artist artist = new Artist();
		
		String word;
		
		while(scanner.hasNext() && !hasRichedEnd) {
			word = scanner.next();
			if(word.equals("\"href\"")) {
				artist = new Artist();
				scanner.next(); // :
				word = scanner.next(); // "https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY",
				//System.out.println("\n\tInfo For All Artists Available On This Album : " );
				//System.out.println("\t\tArtist URL : " + word);
				artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\"")) {
				scanner.next(); // :
				word = scanner.next(); // "2BTZIqw0ntH9MvilQ3ewNY",
				//System.out.println("\t\tArtist ID : " + word);
				artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"name\"")) {
				scanner.next(); // :
				word = scanner.nextLine(); // "Cyndi Lauper",
				//System.out.println("\t\tArtist Name : " + word);		
				artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"type\"")) {
				scanner.next(); // :
				word = scanner.next(); // "artist",
				//System.out.println("\t\tArtist Type : " + word);
				artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"uri\"")) {
				scanner.next(); // :
				word = scanner.next(); // "spotify:artist:2BTZIqw0ntH9MvilQ3ewNY"
				//System.out.println("\t\tArtist URI : " + word);
				artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				artists.add(artist);
			}
			else if(word.equals("\"available_markets\"")) {
				scanner.next();
				word = "";
				do {
					word += scanner.next(); // ["AD","AR","AT",..."VN","ZA"],
				}while(!word.contains("],"));
						
				String[] markets = word.substring(word.indexOf("[")+1,word.indexOf("]")).split(",");
				ArrayList<String> availableMarkets = new ArrayList<>(Arrays.asList(markets));
				album.setAvailableMarkets(availableMarkets);
				hasRichedEnd = true;
			}
		}
	}
	
	private void dealWithAlbum() {
		
		boolean hasRichedEnd = false;
		
		boolean doneWithImages = false;
		LinkedHashSet<Image> albumImages = new LinkedHashSet<>();
		Image albumImage = null;
		
		String word;
		
		while(scanner.hasNext() && !hasRichedEnd) {
			word = scanner.next();
			if(word.equals("\"genres\"")) {
				scanner.next(); // :
				String genres = scanner.nextLine(); // [ ],
				ArrayList<String> genreList = new ArrayList<>();
				if(!genres.contains("[ ],")) {
		
					String[] availableGenres = genres.substring(
					genres.indexOf("["+1), genres.indexOf("]")).split(",");
					for(int i = 0; i < availableGenres.length;i++) 
						genreList.add(availableGenres[i]);
				}
				album.setGenres(genreList);
			}
			else if(word.equals("\"href\"")) {
				scanner.next(); // :
				word = scanner.next(); // "https://api.spotify.com/v1/albums/0sNOF9WDwhWunNAHPD3Baj",
				//System.out.println("\tAlbum URL : " + word);
				album.setAlbumURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\"")) {
				scanner.next(); // :
				word = scanner.next(); // "0sNOF9WDwhWunNAHPD3Baj",
				//System.out.println("\tAlbum ID : " + word);
				album.setAlbumId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(!doneWithImages && word.equals("\"images\"")) {
				do {
					
					word = scanner.next();
					
					if(word.equals("\"height\"")) {
						word = scanner.next(); // :
						albumImage = new Image();
						word = scanner.next(); // 640,
						albumImage.setHeight(Short.parseShort(
						word.substring(0, word.indexOf(","))));
					}
					else if(word.equals("\"url\"")) {
						word = scanner.next(); // :
						word = scanner.next(); // "https://i.scdn.co/image/07c323340e03e25a8e5dd5b9a8ec72b69c50089d",
						albumImage.setImageURL(word.substring(0, 
						word.indexOf(",")));
					}
					else if(word.equals("\"width\"")) {
						word = scanner.next(); // :
						word = scanner.next(); // 640
						albumImage.setWidth(Short.parseShort(word));
						albumImage.setAlbum(album);
						albumImages.add(albumImage);
					}
					
				}while(word.charAt(0)!=(']'));
				doneWithImages = true;
				album.setImages(albumImages);
			}
			else if(word.equals("\"name\"")) {
				scanner.next(); // :
				word = scanner.nextLine(); // "She's So Unusual",
				//System.out.println("\tAlbum Name : " + word);
				album.setAlbumName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"popularity\"")) {
				scanner.next(); // :
				word = scanner.next();
				//System.out.println("\tAlbum Popularity : " + word);
				album.setPopularity(Integer.parseInt(word.substring(0,word.indexOf(","))));
			}
			else if(word.equals("\"release_date\"")) {
				scanner.next(); // :
				word = scanner.next(); // "1983",
				//System.out.println("\tAlbum release_date : " + word);
				album.setReleaseDate(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"release_date_precision\"")) {
				scanner.next(); // :
				word = scanner.next(); // "year",
				//System.out.println("\tAlbum release_date_precision : " + word);
				album.setReleaseDatePrecision(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));	
				hasRichedEnd = true;
			}
			
			
		}
	}
	
	private void dealWithAlbumLastInfo() {
		
		String word;
		
		while(scanner.hasNext()) {
			word = scanner.next();
			
			
			if(word.equals("\"offset\"")) {
				word = scanner.next(); // :
				word = scanner.next();
				album.setOffset(
				Byte.parseByte(word.substring(
				0, (word.length()-1))));
			}
			else if(word.equals("\"total\"")) {
				word = scanner.next(); // :
				word = scanner.next();
				album.setTotal(
				Byte.parseByte(word.substring(
				0, word.length())));
			}
			else if(word.equals("\"type\"")) {
				word = scanner.next(); // :
				word = scanner.next();
				album.setAlbumType(word.substring(
				word.indexOf("\"")+1, word.lastIndexOf("\"")));
			}
			else if(word.equals("\"uri\"")) {
				word = scanner.next(); // :
				word = scanner.next();
				album.setAlbumURI(word.substring(
				word.indexOf("\"")+1, word.lastIndexOf("\"")));
			}
			
		}
	}
	
	private void dealWithManyTracks() {
		
		boolean hasUpdatedCrucialInfo = false;
		boolean hasDeltWithTrackMarkets = false;
	
		Artist artist = new Artist();
		
		
		Track track = new Track();
		
		String word = scanner.next();
		
		while(scanner.hasNext() && 
		!word.equals("\"limit\"")) {
			word = scanner.next();
			
			if(!hasUpdatedCrucialInfo && 
			!hasDeltWithTrackMarkets &&
			word.equals("\"href\"")) {
				scanner.next(); // :
				word = scanner.next(); // "https://api.spotify.com/v1/albums/0sNOF9WDwhWunNAHPD3Baj/tracks?offset=0&limit=50",
				album.setCrucialInfo(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				hasUpdatedCrucialInfo = true;	
			}
			else if(word.equals("\"artists\"")) {
				word = scanner.next();
				while(scanner.hasNext() && 
				!word.equals("\"available_markets\"")) {
					word = scanner.next();
					if(hasUpdatedCrucialInfo && 
					!hasDeltWithTrackMarkets &&
					word.equals("\"href\"")) {
						scanner.next(); // :
						artist = new Artist();
						word = scanner.next(); // "https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY",
						artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
										
					}
					else if(!hasDeltWithTrackMarkets &&
					word.equals("\"id\"")) {
						scanner.next(); // :
						word = scanner.next(); // "2BTZIqw0ntH9MvilQ3ewNY",
						artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
										
					}
					else if(!hasDeltWithTrackMarkets &&
					word.equals("\"name\"")) {
						scanner.next(); // :
						word = scanner.nextLine(); // "Cyndi Lauper",
						artist.setArtistName(
						word.substring(word.indexOf("\"")+1,
						word.lastIndexOf("\"")));
					}
					else if(!hasDeltWithTrackMarkets &&
					word.equals("\"type\"")) {
						scanner.next(); // :
						word = scanner.next(); // "artist",
						artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
					}
					else if(!hasDeltWithTrackMarkets &&
					word.equals("\"uri\"")) {
						scanner.next(); // :
						word = scanner.next(); // "spotify:artist:2BTZIqw0ntH9MvilQ3ewNY"
								
						artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						trackArtists.add(artist);
								
					}
				}
				
				// Deal with available markets.
				scanner.next(); // :
				word = "";
				do {
					word += scanner.next(); // ["AD","AR","AT",..."VN","ZA"],
				}while(!word.contains("],"));
							
				String[] markets = word.substring(word.indexOf("[")+1,word.indexOf("]")).split(",");
				ArrayList<String> availableMarkets = new ArrayList<>(Arrays.asList(markets));
					
				track.setAvailableMarkets(availableMarkets);		
				hasDeltWithTrackMarkets = true;
				
			}
			
			else if(word.equals("\"disc_number\"")) {
				scanner.next(); // :
				word = scanner.next(); // 1,
				track.setDiscNumber(
				Integer.parseInt(word.substring(0, 
				word.indexOf(","))));
			}
			else if(word.equals("\"duration_ms\"")) {
				scanner.next(); // :
				word = scanner.next(); // 305560,
				track.setDuration_ms(
				Integer.parseInt(word.substring(0, 
				word.indexOf(","))));
			}
			else if(hasDeltWithTrackMarkets && 
			word.equals("\"href\"")) {
				scanner.next(); // :
				word = scanner.next(); // "https://api.spotify.com/v1/tracks/3f9zqUnrnIq0LANhmnaF0V",
				track.setTrackURL(word.substring(
				word.indexOf("\"")+1, word.lastIndexOf("\"")));
			}
			else if(hasDeltWithTrackMarkets && 
			word.equals("\"id\"")) {
				scanner.next(); // :
				word = scanner.next(); // "3f9zqUnrnIq0LANhmnaF0V",
				track.setTrackId(word.substring(
				word.indexOf("\"")+1, 
				word.lastIndexOf("\"")));
			}
			else if(hasDeltWithTrackMarkets && 
			word.equals("\"name\"")) {
				scanner.next(); // :
				// "Money Changes Everything",
				word = scanner.nextLine();
				track.setTrackName(
				word.substring(word.indexOf("\"")+1, 
				word.lastIndexOf("\"")));
			}
			else if(word.equals("\"track_number\"")) {
				scanner.next(); // :
				word = scanner.next(); //1,
				track.setTrackNumber(
				Integer.parseInt(word.substring(0, 
				word.indexOf(","))));
			}
			else if(hasDeltWithTrackMarkets && 
			word.equals("\"type\"")) {
				scanner.next(); // :
				word = scanner.next(); // "track",
				track.setTrackType(word.substring(
				word.indexOf("\"")+1, word.lastIndexOf("\"")));
			}
			else if(hasDeltWithTrackMarkets &&
			word.equals("\"uri\"")) {
				scanner.next(); // :
				word = scanner.next(); // "spotify:track:3f9zqUnrnIq0LANhmnaF0V"
				track.setTrackURI(word.substring(
				word.indexOf("\"")+1, word.lastIndexOf("\"")));
				albumTracks.add(track);
				
				hasDeltWithTrackMarkets = false;
				trackArtists.add(null);
				track = new Track();
			}
		}
		
		// Deal with album limits.
		if(scanner.hasNext())
			word = scanner.next(); // :
		if(scanner.hasNext())
			word = scanner.next();
		
		album.setLimit(
		Byte.parseByte(word.substring(
		0, (word.length()-1))));
		
	}
}

