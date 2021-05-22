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

@Component
public class TrackExtractionTask extends ExtractionTask{

	@Autowired
	private TrackController trackController;
	
	@Autowired
	private AlbumController albumController;
	
	@Autowired
	private ArtistController artistController;
	
	private Track track;
	ArrayList<Artist> trackArtists = new ArrayList<>();
	
	public TrackExtractionTask() {
		
	}
	
	// Need To Modify It Later.
	@Override
	protected void fillFileNames() {
		
		int i = 10;
		
		while(i > 0) {
			fileNames.add("C:\\Users\\Test\\OneDrive\\Documents\\My-God's-Path-On-Earth\\Manikhwe Programming School\\Manikhwe-Programming-School\\src\\main\\java\\com\\manikhweschool\\music\\controller\\extraction\\ForTrack.json");
			i--;
		}
	}
	
	
	@Override
	protected void fetch() {
		
		if(fileNameIndex < fileNames.size()) {
			file = new File(fileNames.get(fileNameIndex++));
			
			track = new Track();
			
			try {
				scanner = new Scanner(file);
				dealWithAlbum();
				dealWithArtists();
				dealWithOtherInfo();
				
				trackController.saveMusic(track);
				track.setArtists(trackArtists);
				
				for(Artist artist : trackArtists)
					artist.getTracks().add(track);
				
				artistController.saveAllArtist(trackArtists);
				
				scanner.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}

	private void dealWithAlbum() {
		
		boolean hasRichedEnd = false;
		boolean doneWithAllAlbumArtist = false;
		
		Album album = new Album();
		
		ArrayList<Artist> artists = new ArrayList<>();
		Artist artist = null;
		
		boolean doneWithImages = false;
		LinkedHashSet<Image> albumImages = new LinkedHashSet<>();
		Image albumImage = null;
		
		String word;
		
		while(scanner.hasNext() && !hasRichedEnd) {
			word = scanner.next();
		
			if(doneWithAllAlbumArtist == false && 
			word.equals("\"href\":")) {
				artist = new Artist();
				word = scanner.next(); // "https://api.spotify.com/v1/artists/6sFIWsNpZYqfjUpaCgueju",
				artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				
			}
			else if(word.equals("\"album_type\":")) {
				word = scanner.next(); // "single",
				album.setAlbumType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(doneWithAllAlbumArtist == false && 
			word.equals("\"id\":")) {
				word = scanner.next(); // "6sFIWsNpZYqfjUpaCgueju",
				artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				
			}
			else if(!doneWithImages && word.equals("\"images\":")) {
				do {
					word = scanner.next();
					
					if(word.equals("\"height\":")) {
						albumImage = new Image();
						word = scanner.next(); // 640,
						albumImage.setHeight(Short.parseShort(
						word.substring(0, word.indexOf(","))));
					}
					else if(word.equals("\"url\":")) {
						word = scanner.next(); // "https://i.scdn.co/image/966ade7a8c43b72faa53822b74a899c675aaafee",
						albumImage.setImageURL(word.substring(0, 
						word.indexOf(",")));
					}
					else if(word.equals("\"width\":")) {
						word = scanner.next(); // 640
						albumImage.setWidth(Short.parseShort(word));
						albumImage.setAlbum(album);
						albumImages.add(albumImage);
					}
					
				}while(word.charAt(0)!=(']'));
				doneWithImages = true;
				album.setImages(albumImages);
			}
			else if(doneWithAllAlbumArtist == false && 
			word.equals("\"name\":")) {
				word = "";
				word += scanner.nextLine();
				artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				
			}
			else if(doneWithAllAlbumArtist == false && 
			word.equals("\"type\":")) {
				word = scanner.next(); // "artist",
				artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(doneWithAllAlbumArtist == false && 
			word.equals("\"uri\":")) {
				word = scanner.next(); // "spotify:artist:6sFIWsNpZYqfjUpaCgueju"
				artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				artists.add(artist);
				artistController.saveArtist(artist);
			}
			else if(doneWithAllAlbumArtist == false && 
			word.equals("\"available_markets\":")) {
				word = "";
				do {
					word += scanner.next(); // ["AD","AR","AT",..."VN","ZA"],
				}while(!word.contains("],"));
				
				String[] markets = word.substring(word.indexOf("[")+1,word.indexOf("]")).split(",");
				ArrayList<String> availableMarkets = new ArrayList<>(Arrays.asList(markets));
				album.setAvailableMarkets(availableMarkets);
				doneWithAllAlbumArtist = true;
				album.setArtists(artists);
				
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"href\":")) {
				word = scanner.next(); // "https://api.spotify.com/v1/albums/0tGPJ0bkWOUmH7MEOR77qc",
				album.setAlbumURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"id\":")) {
				word = scanner.next(); // "6sFIWsNpZYqfjUpaCgueju",
				album.setAlbumId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"name\":")) {
				
				word = scanner.nextLine(); // "Cut To The Feeling",
				album.setAlbumName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"release_date\":")) {
				word = scanner.next();
				album.setReleaseDate(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"release_date_precision\":")) {
				word = scanner.next();
				album.setReleaseDatePrecision(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));	
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"type\":")) {
				word = scanner.next(); // "album",
				album.setAlbumType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(doneWithAllAlbumArtist && 
			word.equals("\"uri\":")) {
				word = scanner.next(); // "spotify:album:0tGPJ0bkWOUmH7MEOR77qc"
				album.setAlbumURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				hasRichedEnd = true;
				albumController.saveAlbum(album);
				track.setAlbum(album);
				
			}
			
		}
	}
	
	private void dealWithArtists() {
		
		boolean hasRichedEnd = false;
		
		Artist artist = new Artist();
		
		String word;
		
		while(scanner.hasNext() && !hasRichedEnd) {
			word = scanner.next();
			
			if(word.equals("\"href\":")) {
				artist = new Artist();
				word = scanner.next(); // "https://api.spotify.com/v1/artists/6sFIWsNpZYqfjUpaCgueju",
				artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\":")) {
				word = scanner.next(); // "6sFIWsNpZYqfjUpaCgueju",
				//System.out.println("\t\tArtist ID : " + word);
				artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"name\":")) {
				word = scanner.nextLine(); // "Carly Rae Jepsen",
				artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"type\":")) {
				word = scanner.next(); // "artist",
				artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"uri\":")) {
				word = scanner.next(); // "spotify:artist:6sFIWsNpZYqfjUpaCgueju"
				artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				trackArtists.add(artist);
//artistController.saveArtist(artist);
			}
			else if(word.equals("\"available_markets\":")) {
				word = "";
				do {
					word += scanner.next(); // ["AD","AR","AT",..."VN","ZA"],
				}while(!word.contains("],"));
						
				String[] markets = word.substring(word.indexOf("[")+1,word.indexOf("]")).split(",");
				ArrayList<String> availableMarkets = new ArrayList<>(Arrays.asList(markets));
				track.setAvailableMarkets(availableMarkets);
				hasRichedEnd = true; 

			}
		}
	}

	private void dealWithOtherInfo() {
		
		String word;
		
		while(scanner.hasNext()) {
			word = scanner.next();
		
			if(word.equals("\"disc_number\":")) {
				word = scanner.next(); // "https://api.spotify.com/v1/artists/6sFIWsNpZYqfjUpaCgueju",
				track.setDiscNumber(Integer.parseInt(word.substring(0,word.indexOf(","))));
						
			}
			else if(word.equals("\"duration_ms\":")) {
				word = scanner.next(); // "https://api.spotify.com/v1/artists/6sFIWsNpZYqfjUpaCgueju",
				track.setDuration_ms(Integer.parseInt(word.substring(0,word.indexOf(","))));
						
			}
			else if(word.equals("\"href\":")) {
				word = scanner.next(); // "https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl",
				track.setTrackURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\":")) {
				word = scanner.next(); // "11dFghVXANMlKmJXsNCbNl",
				track.setTrackId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"name\":")) {
				word = scanner.nextLine();	
				track.setTrackName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"popularity\":")) {
				word = scanner.next(); // 63,
				track.setPopularity(Integer.parseInt(word.substring(0,word.indexOf(","))));
			}
			else if(word.equals("\"track_number\":")) {
				word = scanner.next(); // 1,
				track.setTrackNumber(Integer.parseInt(word.substring(0,word.indexOf(","))));
			}
			else if(word.equals("\"type\":")) {
				word = scanner.next(); // "track",
				track.setTrackType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"uri\":")) {
				word = scanner.next(); // "spotify:track:11dFghVXANMlKmJXsNCbNl"
				track.setTrackURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			
		}
	}

	public TrackController getTrackController() {
		return trackController;
	}

	public void setTrackController(TrackController trackController) {
		this.trackController = trackController;
	}

	public AlbumController getAlbumController() {
		return albumController;
	}

	public void setAlbumController(AlbumController albumController) {
		this.albumController = albumController;
	}

	public ArtistController getArtistController() {
		return artistController;
	}

	public void setArtistController(ArtistController artistController) {
		this.artistController = artistController;
	}
	
	
}


