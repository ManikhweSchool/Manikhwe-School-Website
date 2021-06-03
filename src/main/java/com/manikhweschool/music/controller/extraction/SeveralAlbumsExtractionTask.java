package com.manikhweschool.music.controller.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manikhweschool.music.controller.AlbumController;
import com.manikhweschool.music.controller.ArtistController;
import com.manikhweschool.music.controller.TrackController;
import com.manikhweschool.music.model.Album;
import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Image;
import com.manikhweschool.music.model.Track;

/*
 * curl -X GET "https://api.spotify.com/v1/albums/
 * ?ids=41MnTivkwTO3UUJ8DrqEJJ,6JWc4iAiJ9FjyK0B59ABb4,
 * 6UXCm6bOO4gFlDQZV5yL37" 
 * -H "Authorization: Bearer {your access token}"
 * */
// Maximum: 20 IDs Separated By A Commas
@Component
public class SeveralAlbumsExtractionTask extends ExtractionTask{

	@Autowired
	private AlbumController albumController;
	
	@Autowired
	private TrackController trackController;
	
	@Autowired
	private ArtistController artistController;
	
	// Current Album
	private Album album; 
	
	// Current Album's artists.
	private ArrayList<Artist> artists;
	
	// Current Album's track artists.
	private ArrayList<Artist> trackArtists;
	
	// Current Album tracks.
	private ArrayList<Track> albumTracks; 
	
	// Artists that are already saved in the database.
	private ArrayList<Artist> storedArtists;
	
	// Id's for artists used to splits trackArtists array.
	private int seperatorId = 0;
 	
	public SeveralAlbumsExtractionTask() {
		
	}
	
	public void setStoredArtists(
	ArrayList<Artist> storedArtists) {
		
		if(this.storedArtists==null ||
		this.storedArtists.isEmpty())
			this.storedArtists = storedArtists;
	}
	
	public ArrayList<Artist> getStoredArtists(){
		
		return (ArrayList<Artist>) 
		Collections.unmodifiableCollection(storedArtists);
	}
	
	// Need To Modify It Later.
	@Override
	protected void fillFileNames() {
		
		int i = 1;
		
		while(i > 0) {
			fileNames.add("C:\\Users\\Test\\"
			+ "OneDrive\\Documents\\My-God's-"
			+ "Path-On-Earth\\Manikhwe Programming "
			+ "School\\Manikhwe-Programming-School\\"
			+ "src\\main\\java\\com\\manikhweschool\\"
			+ "music\\controller\\extraction\\"
			+ "ForSeveralAlbums2.json");
			i--;
		}
	}

	@Override
	protected void fetch() {
		
		if(fileNameIndex < fileNames.size()) {
			file = new File(fileNames.get(fileNameIndex++));
			
			try {
				scanner = new Scanner(file);
				while(scanner.hasNext()) {
					album = new Album();
					artists = new ArrayList<>();
					
					trackArtists = new ArrayList<>();
					albumTracks = new ArrayList<>();
					
					dealWithArtists();
					dealWithAlbum();
					dealWithManyTracks();
					dealWithAlbumLastInfo();
								
					albumController.saveAlbum(album);
					
					if(storedArtists==null) {
						for(Artist artist : artists) 
							artist.getAlbums().add(album);
						artistController.saveAllArtist(artists);
						album.setArtists(artists);
					}
					/* Artists that are already on the database 
					 * cannot be mapped to their corresponding 
					 * album.*/
					else {
						
						for(Artist artist : artists) {
							artist.addAlbum(album);
							artistController.saveArtist(artist);
							album.getArtists().add(artist);
							
						}
					}
					
					int i = 0;
					
					for(Track track : albumTracks/*(ArrayList<Track>) album.getTracks()*/) {
		
						while(i<trackArtists.size() && 
						!trackArtists.get(i).getArtistId().startsWith("sep")) {
							Artist artist = trackArtists.get(i++);
							
							artist.getAlbums().add(album);
							artist.getTracks().add(track);
							track.setAlbum(album);
							track.addArtist(artist);
							trackController.saveMusic(track);
						}
						i++;
					}
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
				artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\"")) {
				scanner.next(); // :
				word = scanner.next(); // "2BTZIqw0ntH9MvilQ3ewNY",
				artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"name\"")) {
				scanner.next(); // :
				word = scanner.nextLine(); // "Cyndi Lauper",		
				artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"type\"")) {
				scanner.next(); // :
				word = scanner.next(); // "artist",
				artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"uri\"")) {
				scanner.next(); // :
				word = scanner.next(); // "spotify:artist:2BTZIqw0ntH9MvilQ3ewNY"
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
				album.setAlbumURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\"")) {
				scanner.next(); // :
				word = scanner.next(); // "0sNOF9WDwhWunNAHPD3Baj",
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
				album.setAlbumName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"popularity\"")) {
				scanner.next(); // :
				word = scanner.next();
				album.setPopularity(Integer.parseInt(word.substring(0,word.indexOf(","))));
			}
			else if(word.equals("\"release_date\"")) {
				scanner.next(); // :
				word = scanner.next(); // "1983",
				album.setReleaseDate(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"release_date_precision\"")) {
				scanner.next(); // :
				word = scanner.next(); // "year",
				album.setReleaseDatePrecision(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));	
				hasRichedEnd = true;
			}
			
			
		}
	}
	
	private void dealWithAlbumLastInfo() {
		
		String word = "";
		
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
			else if(word.equals("\"album_type\"")) {
				break;
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
				
				Artist seperator = new Artist();
				seperator.setArtistId("seperator" + ++seperatorId);
				trackArtists.add(seperator);
				
				
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

