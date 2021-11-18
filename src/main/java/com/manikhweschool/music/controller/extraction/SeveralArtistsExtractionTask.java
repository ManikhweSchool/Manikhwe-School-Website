package com.manikhweschool.music.controller.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manikhweschool.music.controller.ArtistController;
import com.manikhweschool.music.controller.ImageController;
import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Image;

/*
 * curl -X GET "https://api.spotify.com/v1/artists?
 * ids=0oSGxfWSnnOXhD2fKuz2Gy,3dBVyJ7JuOMt4GE9607Qin" 
 * -H "Authorization: Bearer {your access token}"
 * */
// Maximum: 50 IDs
//@Component
public class SeveralArtistsExtractionTask extends ExtractionTask{

	private ArrayList<Artist> artists = new ArrayList<>();
	
	//@Autowired
	private ArtistController artistController;
	
	//@Autowired
	private ImageController imageController;
	
	public SeveralArtistsExtractionTask() {
		
	}
	
	public ArrayList<Artist> getArtists(){
		
		return artists;
	}
	
	@Override
	protected void fillFileNames() {
		
		int i = 1;
		
		while(i > 0) {
			fileNames.add("C:\\Users\\Test"
			+ "\\OneDrive\\Documents\\My-God's-"
			+ "Path-On-Earth\\Manikhwe Programming "
			+ "School\\Manikhwe-Programming-School\\"
			+ "src\\main\\java\\com\\manikhweschool\\"
			+ "music\\controller\\extraction\\"
			+ "ForSeveralArtist.json");
			i--;
		}
	}

	@Override
	protected void fetch() {
		
		if(fileNameIndex < fileNames.size()) {
			file = new File(fileNames.get(fileNameIndex++));
			
			Artist artist = new Artist();
			Image image = new Image();
			
			try {
				scanner = new Scanner(file);
				String word;
				
				PrintWriter writer = new PrintWriter("Artists_Needed.txt");
				
				while(scanner.hasNext()) {
					word = scanner.next();
					if(word.equals("\"followers\"")) {
						artist = new Artist();
						do {
							word = scanner.next();
						}while(!word.equals("\"total\""));
						scanner.next(); // :
						word = scanner.next(); // 306565
						artist.setNumberOfFollowers(Integer.parseInt(word));
					}
					else if(word.equals("\"genres\"")) {
						scanner.next(); // :
						String genres = scanner.nextLine(); // [ ],
						ArrayList<String> genreList = new ArrayList<>();
						if(!genres.contains("[ ],")) {
	
							String[] availableGenres = genres.substring(genres.indexOf("\""), genres.lastIndexOf(" ")).split(",");
							for(int i = 0; i < availableGenres.length;i++) 
								genreList.add(availableGenres[i]);
						}
						artist.setGenres(genreList);
					}
					else if(word.equals("\"href\"")) {
						scanner.next(); // :
						word = scanner.next(); // "https://api.spotify.com/v1/artists/0OdUWJ0sBjDrqHygGUXeCF",
						//System.out.println("Artist URL : " + word);
						artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
								
					}
					else if(word.equals("\"id\"")) {
						scanner.next(); // :
						word = scanner.next(); // "0OdUWJ0sBjDrqHygGUXeCF",
						//System.out.println("Artist ID : " + word);
						artist.setArtistId(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
								
					}
					else if(word.equals("\"height\"")) {
						image = new Image();
						scanner.next(); // :
						word = scanner.next(); // 816,
						image.setHeight(Short.parseShort(
						word.substring(0, word.indexOf(","))));
					}
					else if(word.equals("\"url\"")) {
						scanner.next(); // :
						word = scanner.next(); // "https://i.scdn.co/image/eb266625dab075341e8c4378a177a27370f91903",
						image.setImageURL(word.substring(0, 
						word.indexOf(",")));
					}
					else if(word.equals("\"width\"")) {
						scanner.next(); // :
						word = scanner.next(); // 1000
						image.setWidth(Short.parseShort(word));
						image.setArtist(artist);
						artist.getArtistImages().add(image);
					}
					else if(word.equals("\"name\"")) {
						scanner.next(); // :
						word = scanner.nextLine(); // "Band of Horses",
						//System.out.println("Artist Name : " + word);		
						artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
								
					}
					else if(word.equals("\"popularity\"")) {
						scanner.next(); // :
						word = scanner.next(); // 59,
						//System.out.println("Artist Popularity : " + word);
						artist.setPopularity(Integer.parseInt(
						word.substring(0, word.indexOf(","))));
						
					}
					else if(word.equals("\"type\"")) {
						scanner.next(); // :
						word = scanner.next(); // "artist",
						//System.out.println("Artist Type : " + word);
						artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
					}
					else if(word.equals("\"uri\"")) {
						scanner.next(); // :
						word = scanner.next(); // "spotify:artist:0OdUWJ0sBjDrqHygGUXeCF"
						//System.out.println("Artist URI : " + word);
						artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						artists.add(artist);
						artistController.saveArtist(artist);
						writer.println(artist.getArtistId());
					}
					
				}

				writer.close();
				scanner.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}


