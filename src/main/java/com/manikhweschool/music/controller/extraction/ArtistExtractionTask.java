package com.manikhweschool.music.controller.extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manikhweschool.music.controller.ArtistController;
import com.manikhweschool.music.controller.ImageController;
import com.manikhweschool.music.model.Artist;
import com.manikhweschool.music.model.Image;

@Component
public class ArtistExtractionTask extends ExtractionTask{

	@Autowired
	private ImageController imageController;
	
	@Autowired
	private ArtistController artistController;
	
	private Artist artist;
	
	// Has to be modified later.
	@Override
	protected void fillFileNames() {
		
		int i = 3;
		
		while(i > 0) {
			fileNames.add("C:\\Users\\Test\\OneDrive\\Documents\\My-God's-Path-On-Earth\\Manikhwe Programming School\\Manikhwe-Programming-School\\src\\main\\java\\com\\manikhweschool\\music\\controller\\extraction\\ForArtist.json");
			i--;
		}
	}

	@Override
	protected void fetch() {
		
		if(fileNameIndex < fileNames.size()) {
			file = new File(fileNames.get(fileNameIndex++));
			
			artist = new Artist();
			Image image = new Image();
			
			try {
				scanner = new Scanner(file);
				String word;
				
				while(scanner.hasNext()) {
					word = scanner.next();
					if(word.equals("\"followers\"")) {
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
						artist.setArtistURL(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
								
					}
					else if(word.equals("\"id\"")) {
						scanner.next(); // :
						word = scanner.next(); // "0OdUWJ0sBjDrqHygGUXeCF",
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
						artist.setArtistName(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
								
					}
					else if(word.equals("\"popularity\"")) {
						scanner.next(); // :
						word = scanner.next(); // 59,
						artist.setPopularity(Integer.parseInt(
						word.substring(0, word.indexOf(","))));
						
					}
					else if(word.equals("\"type\"")) {
						scanner.next(); // :
						word = scanner.next(); // "artist",
						artist.setArtistType(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
					}
					else if(word.equals("\"uri\"")) {
						scanner.next(); // :
						word = scanner.next(); // "spotify:artist:0OdUWJ0sBjDrqHygGUXeCF"
						artist.setArtistURI(word.substring(word.indexOf("\"")+1,word.lastIndexOf("\"")));
						
					}
					
				}
				
				artistController.saveArtist(artist);

				scanner.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}

	public ImageController getImageController() {
		return imageController;
	}

	public void setImageController(ImageController imageController) {
		this.imageController = imageController;
	}

	public ArtistController getArtistController() {
		return artistController;
	}

	public void setArtistController(ArtistController artistController) {
		this.artistController = artistController;
	}

}
