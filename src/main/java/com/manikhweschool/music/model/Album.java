package com.manikhweschool.music.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*@Entity
@Table(name = "ALBUM")
@Component*/
public class Album implements Serializable,Cloneable,Comparable<Album>{

	private static final long serialVersionUID = 1L;

	// Spotify Id
	//@Id
	//@Column(name = "Album_Id", nullable = false)
	private String albumId;
	
	/*	The name of the album. 
	 * In case of an album takedown, 
	 * the value may be an empty string.*/
	//@Column(name = "Album_Name", nullable = false)
	private String albumName;
	
	/*The type of the album: one of "album" , 
	 * "single" , or "compilation"*/
	//@Column(name = "Album_Type", nullable = false)
	private String albumType;
	
	/*The date the album was first released, 
	 * for example "1981-12-15". Depending on 
	 * the precision, it might be shown as 
	 * "1981" or "1981-12"*/
	//@Column(name = "Release_Date", nullable = false)
	private String releaseDate;
	
	/*The precision with which release_date 
	 * value is known: "year" , "month" , or 
	 * "day".*/
	//@Column(name = "Release_Date_Precision", nullable = false)
	private String releaseDatePrecision;
	
	/*@OneToMany(
		mappedBy = "album",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)*/
	private Collection<Track> tracks;
	
	/*@OneToMany(
		mappedBy = "album",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)*/
	private Collection<Image> images;
	
	/*The Spotify URI for the album.*/
	//@Column(name = "Album_URI", nullable = false)
	private String albumURI;
	
	/*The Spotify URL for the album.*/
	//@Column(name = "Album_URL", nullable = false)
	private String albumURL;
	
	//@ManyToMany(mappedBy="albums")
	private Collection<Artist> artists;
	
	//@ElementCollection
	private Collection<String> availableMarkets;
	
	//@ElementCollection
	private Collection<String> genres;
	
	// The label for the album.
	//@Column(name = "Album_Label", nullable = false)
	private String label;
	
	//@Column(name = "Album_Limit", nullable = false)
	private byte limit;
	
	//@Column(name = "Album_Total", nullable = false)
	private byte total;
	
	//@Column(name = "Album_Offset", nullable = false)
	private byte offset;
	
	//@Column(name = "Album_Popularity", nullable = false)
	private int popularity;
	
	//@Column(name = "Useful_Info", nullable = false)
	private String crucialInfo;
	
	

	public Album() {
		super();
		
		limit = -1;
		total = -1;
		offset = -1;
		popularity = -1;
		crucialInfo = "N/A";
		label = "N/A";
		releaseDate = "";
		releaseDatePrecision = "";
		
		albumName = "N/A";
		albumURI = "N/A";
		albumURL = "N/A";
		albumType = "N/A";
		albumId = "N/A";
		
		
		tracks = new ArrayList<>();
		artists = new ArrayList<>();
		genres = new ArrayList<>();
		availableMarkets = new ArrayList<>();
		images = new LinkedHashSet<>();
	}
	
	public void addImage(Image image) { images.add(image);}
	
	@Override
	public String toString() {
		
		String representation = "";
		
		representation += "Album Name : " + albumName + "\n";
		representation += "Album Id : " + albumId + "\n";
		representation += "Album URI : " + albumURI + "\n";
		representation += "Album URL : " + albumURL + "\n";
		representation += "Album Limit : " + limit + "\n";
		representation += "Album Offset : " + offset + "\n";
		representation += "Album Total : " + total + "\n";
		representation += "Album Popularity : " + popularity + "\n";
		representation += "Album Type : " + albumType + "\n";
		representation += "Album Genre : " + genres + "\n";
		representation += "Album Release Date : " + releaseDate + "\n";
		representation += "Album Release Date Precision : " + releaseDatePrecision + "\n";
		
		
		for(int i = 0; i < tracks.size();i++) {
			Track track = ((ArrayList<Track>) tracks).get(i);
			representation += "-------------------------------------Track : " 
			+ track.getTrackNumber() + " Info " +
			"--------------------------------------------\n";
			representation += track.toString();

		}
		
		representation += "\n^^^^^^^^^^^^Info On All Artists On This Album^^^^^^^^^^^^^^ \n";
		for(int i = 0; i < artists.size();i++) {
			Artist artist = ((ArrayList<Artist>) artists).get(i);
			representation += "Artist No : ";
			representation += (i+1);
			representation += artist.toString();
		}
		
		return representation;
	}
	
	public void viewAlbum() {
		System.out.print(toString());
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumType() {
		return albumType;
	}

	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseDatePrecision() {
		return releaseDatePrecision;
	}

	public void setReleaseDatePrecision(String releaseDatePrecision) {
		this.releaseDatePrecision = releaseDatePrecision;
	}

	public Collection<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<Track> tracks) {
		this.tracks = tracks;
	}

	public String getAlbumURI() {
		return albumURI;
	}

	public void setAlbumURI(String albumURI) {
		this.albumURI = albumURI;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<Artist> artists) {
		this.artists = artists;
	}

	public Collection<String> getAvailableMarkets() {
		return availableMarkets;
	}

	public void setAvailableMarkets(Collection<String> availableMarkets) {
		this.availableMarkets = availableMarkets;
	}

	public String getAlbumURL() {
		return albumURL;
	}

	public void setAlbumURL(String albumURL) {
		this.albumURL = albumURL;
	}

	public Collection<String> getGenres() {
		return genres;
	}

	public void setGenres(Collection<String> genres) {
		this.genres = genres;
	}

	public String getAlbumId() {
		return albumId;
	}
	
	public int getPopularity() {
		return popularity;
	}
	
	@Override
	public int compareTo(Album album) {
		
		if(releaseDatePrecision.isEmpty()
		|| album.getReleaseDatePrecision().isEmpty()) {
			return 0;
		}
		
		if(releaseDatePrecision.equalsIgnoreCase(
		album.getReleaseDatePrecision())) {
			
			return releaseDate.compareTo(album.getReleaseDate());
		}
		else {
			
			String year = releaseDate.substring(0,4);
			if(releaseDate.equalsIgnoreCase("day")) {
				
				return year.compareTo(
				album.getReleaseDate());
			}
			else {
				return year.compareTo(
				album.getReleaseDate().substring(0,4));
				
			}
			
		}
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getCrucialInfo() {
		return crucialInfo;
	}

	public void setCrucialInfo(String crucialInfo) {
		this.crucialInfo = crucialInfo;
	}

	@Override
    public Object clone() throws 
    CloneNotSupportedException { 
    	return super.clone();
    }

	public byte getLimit() {
		return limit;
	}

	public void setLimit(byte limit) {
		this.limit = limit;
	}

	public byte getTotal() {
		return total;
	}

	public void setTotal(byte total) {
		this.total = total;
	}

	public byte getOffset() {
		return offset;
	}

	public void setOffset(byte offset) {
		this.offset = offset;
	}
	
	public void addTrack(Track track) {
		tracks.add(track);
	}

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}
	
	@Override
	public boolean equals(Object newAlbum) {
		
		return albumId.equals(((Album)newAlbum).getAlbumId());
	}
	
}

