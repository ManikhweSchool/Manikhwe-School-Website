package com.manikhweschool.music.controller.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manikhweschool.music.controller.AlbumController;
import com.manikhweschool.music.controller.ArtistController;
import com.manikhweschool.music.model.Album;
import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.ArtistsAlbums;

//@Component
public class ArtistAlbumsExtractionTask extends ExtractionTask{

	private Set<Album> albums;
	private Album album;
	
	private Collection<Artist> artists;
	
	private ArrayList<Artist> storedArtists;
	
	//@Autowired
	private ArtistController artistController;
	
	
	private boolean limitRiched = false;
	
	public ArtistAlbumsExtractionTask() {
		artists = new TreeSet<>();
		albums = new LinkedHashSet<>();
	}
	
	public void setStoredArtists(ArrayList<Artist> storedArtists) {
		
		if(this.storedArtists==null ||
		this.storedArtists.isEmpty())
			this.storedArtists = storedArtists;
	}
	
	@Override
	protected void fillFileNames() {
		
		int i = 1;
		
		while(i > 0) {
			fileNames.add("C:\\Users\\Test\\OneDrive\\Documents\\My-God's-Path-On-Earth\\Manikhwe Programming School\\Manikhwe-Programming-School\\src\\main\\java\\com\\manikhweschool\\music\\controller\\extraction\\ForArtistAlbums.json");
			i--;
		}
	}

	@Override
	protected void fetch() {
		
		if(fileNameIndex < fileNames.size()) {
			file = new File(fileNames.get(fileNameIndex++));
			
			try {
				scanner = new Scanner(file);
				
				dealWithEverything();
		
				try {
					
					PrintWriter writer = new PrintWriter("Albums_Needed.txt");
					
					for(Album album : albums) {
						writer.println(album.getAlbumId());
						System.out.print(album.getAlbumId() + "\t");
					}
					System.out.println();
					writer.close();

				}catch(IOException exception) {
					exception.printStackTrace();
				}
				
				scanner.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private void dealWithEverything() {
		
		ArtistsAlbums artistAlbums = new ArtistsAlbums();
		
		String word;
		
		while(scanner.hasNext()) {
			dealWithArtists();
			if(!limitRiched) 
				dealWithAlbum();
			
			else {
				word = scanner.next(); //  2,
				artistAlbums.setAlbumsLimit(
				Byte.parseByte(word.substring(
				0, (word.length()-1))));
				
				artistAlbums.setAlbums(albums);
				artistAlbums.setArtists(artists);
				
				for(Artist artist : artists)
					artist.addArtistAlbum(artistAlbums);
				
				break;
			}
		}
		
		while(scanner.hasNext()) {
			word = scanner.next();
			
			if(word.equals("\"next\":")) {
				word = scanner.next(); //  2,
				artistAlbums.setNextAlbumInfo(
				word.substring(0, (word.length()-1)));
			}
			else if(word.equals("\"offset\":")) {
				word = scanner.next();
				artistAlbums.setAlbumsOffset(
				Byte.parseByte(word.substring(
				0, (word.length()-1))));
			}
			else if(word.equals("\"previous\":")) {
				word = scanner.next(); //  null,
				artistAlbums.setPreviousAlbumInfo(
				word.substring(0, (word.length()-1)));
			}
			else if(word.equals("\"total\":")) {
				word = scanner.next();
				artistAlbums.setNumberOfAlbums(
				Short.parseShort(word));
			}
		}
	}
	
	private void dealWithAlbum() {
		
		boolean hasRichedEnd = false;
		
		String word;
		
		while(scanner.hasNext() && !hasRichedEnd) {
			word = scanner.next();
			
			if(word.equals("\"href\":")) {
				word = scanner.next(); // "https://api.spotify.com/v1/albums/43977e0YlJeMXG77uCCSMX",
				//System.out.println("\tAlbum URL : " + word);
				album.setAlbumURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\":")) {
				word = scanner.next(); // "0sNOF9WDwhWunNAHPD3Baj",
				//System.out.println("\tAlbum ID : " + word);
				album.setAlbumId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"name\":")) {
				
				word = scanner.nextLine(); // "Shut Up Lets Dance (Vol. II)",
				//System.out.println("\tAlbum Name : " + word);
				album.setAlbumName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"release_date\":")) {
				word = scanner.next(); // "2018-02-09",
				//System.out.println("\tAlbum release_date : " + word);
				album.setReleaseDate(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"release_date_precision\":")) {
				word = scanner.next(); // "day",
				//System.out.println("\tAlbum release_date_precision : " + word);
				album.setReleaseDatePrecision(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));	
			}
			else if(word.equals("\"type\":")) {
				word = scanner.next(); // "album",
				//System.out.println("\tAlbum Type : " + word);
				album.setAlbumType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"uri\":")) {
				word = scanner.next(); // "spotify:album:43977e0YlJeMXG77uCCSMX"
				//System.out.println("\tAlbum URI : " + word);
				album.setAlbumURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				hasRichedEnd = true;
				albums.add(album);
				
			}
		}
		
	}
	
	private void dealWithArtists() {
		
		boolean hasRichedEnd = false;
		Set<Artist> artists = new HashSet<>();
		Artist artist = new Artist();
		
		String word;
		
		while(scanner.hasNext() && !hasRichedEnd) {
			word = scanner.next();
	
			if(word.equals("\"album_group\":")) {
				
				album = new Album();
				
			}
			else if(word.equals("\"href\":")) {
				artist = new Artist();
				word = scanner.next(); // "https://api.spotify.com/v1/artists/0LyfQWJT6nXafLPZqxe9Of",
				//System.out.println("\n\tInfo For All Artists Available On This Album : " );
				//System.out.println("\t\tArtist URL : " + word);
				artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"id\":")) {
				word = scanner.next(); // "0LyfQWJT6nXafLPZqxe9Of",
				//System.out.println("\t\tArtist ID : " + word);
				artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"name\":")) {
				word = scanner.nextLine(); // "Various Artists",
				//System.out.println("\t\tArtist Name : " + word);		
				artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
			}
			else if(word.equals("\"type\":")) {
				word = scanner.next(); // "artist",
				//System.out.println("\t\tArtist Type : " + word);
				artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
			}
			else if(word.equals("\"uri\":")) {
				word = scanner.next(); // "spotify:artist:0LyfQWJT6nXafLPZqxe9Of"
				//System.out.println("\t\tArtist URI : " + word);
				artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
				artists.add(artist);
				this.artists.add(artist);
			}
			else if(word.equals("\"available_markets\":")) {
				word = "";
				do {
					word += scanner.next(); // ["AD","AR","AT",..."VN","ZA"],
				}while(!word.contains("],"));
						
				String[] markets = word.substring(word.indexOf("[")+1,word.indexOf("]")).split(",");
				ArrayList<String> availableMarkets = new ArrayList<>(Arrays.asList(markets));
				album.setAvailableMarkets(availableMarkets);
				hasRichedEnd = true;

for(Artist a : artists) {
	artistController.saveArtist(a);
	a.addAlbum(album);
}

album.setArtists(artists);
				
			}
			else if(word.equals("\"limit\":")) {
				limitRiched = true;
				return;
			}
		}
	}

}


