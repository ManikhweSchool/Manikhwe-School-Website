package com.manikhweschool.music.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ARTIST")
@Component
public class Artist implements Serializable,Cloneable, Comparable<Artist>{

	private static final long serialVersionUID = 2265046550690982257L;

	// Spotify Id
	@Id
	@Column(name = "Artist_Id", nullable = false)
	private String artistId;
	
	/*The name of the artist.*/
	@Column(name = "Artist_Name", nullable = false)
	private String artistName;
	
	/*The popularity of the artist. 
	 * The value will be between 0 
	 * and 100, with 100 being the 
	 * most popular. The artist’s 
	 * popularity is calculated from 
	 * the popularity of all the artist’s 
	 * tracks.*/
	@Column(name = "Popularity", nullable = false)
	private int popularity;
	
	// The Spotify URI for the artist.
	@Column(name = "Spotify_URI", nullable = false)
	private String artistURI;
	
	@Column(name = "Artist_Type", nullable = false)
	private String artistType;
	
	/*A link to the Web API endpoint 
	 * providing full details of the 
	 * artist.*/
	@Column(name = "Artist_URL", nullable = false)
	private String artistURL;
	
	@ElementCollection
	private Collection<String> genres;
	
	private int numberOfFollowers;
	
	@ManyToMany
	@JoinTable(
		name = "Artist_Track_Bridge",
		joinColumns = @JoinColumn(name="artist_fk"),
		inverseJoinColumns = @JoinColumn(name="track_fk")
	)
	private Collection<Track> tracks;
	
	@ManyToMany
	@JoinTable(
		name = "Artist_Album_Bridge",
		joinColumns = @JoinColumn(name="artist_fk"),
		inverseJoinColumns = @JoinColumn(name="album_fk")
	)
	private Collection<Album> albums;
	
	@OneToMany(
		mappedBy = "artist",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private Collection<Image> artistImages;
	
	@ManyToMany
	private Collection<ArtistsAlbums> artistsAlbums;
	
	@Column(name = "Useful_URL", nullable = false)
	private String crucialInfo;

	public Artist() {
		artistName = "N/A";
		artistId = "N/A";
		artistURL = "N/A";
		artistURI = "N/A";
		artistType = "N/A";
		crucialInfo = "N/A";
		popularity = -1;
		numberOfFollowers = -1;
		genres = new ArrayList<>();
		artistImages = new ArrayList<>();
		albums = new TreeSet<>();
		artistsAlbums = new TreeSet<>();
		tracks = new HashSet<>();
	}
	
	public void addArtistAlbum(ArtistsAlbums artistsAlbum) {
		this.artistsAlbums.add(artistsAlbum);
	}
	
	@Override
	public String toString() {
		
		
		String representation = "";
		
		
		representation += "\nArtist Name : " + artistName;
		representation += "\nArtist Id : " + artistId;
		representation += "\nArtist URL : " + artistURL;
		representation += "\nArtist URI : " + artistURI;
		representation += "\nArtist Type : " + artistType;
		representation += "\nArtist Popularity : " + popularity;
		representation += "\nArtist Followers : " + numberOfFollowers;
		representation += "\nArtist Genres : " + genres;
		representation += "\nArtist Images : ";
		
		if(artistImages!=null)
			for(Image image : artistImages) {
				representation += ("\n\tImage Width : " + image.getWidth() + 
				" Image Height : " + image.getHeight() + 
				"\n\tImage URL : " + image.getImageURL() + "\n");
			}
		
		return representation;
	}
	
	public void viewArtist() {
		
		System.out.println(toString());
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getArtistURI() {
		return artistURI;
	}

	public void setArtistURI(String artistURI) {
		this.artistURI = artistURI;
	}
	
	public String getArtistURL() {
		return artistURL;
	}

	public void setArtistURL(String artistURL) {
		this.artistURL = artistURL;
	}

	public Collection<String> getGenres() {
		return genres;
	}

	public void setGenres(Collection<String> genres) {
		this.genres = genres;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	public String getArtistType() {
		return artistType;
	}

	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}
	
	public Collection<Image> getArtistImages() {
		return artistImages;
	}

	public void setArtistImages(Collection<Image> artistImages) {
		this.artistImages = artistImages;
	}

	public int getNumberOfFollowers() {
		return numberOfFollowers;
	}

	public void setNumberOfFollowers(int numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}

	@Override
    public Object clone() throws 
    CloneNotSupportedException { 
    	return super.clone();
    }

	public Collection<ArtistsAlbums> getArtistAlbums() {
		return artistsAlbums;
	}

	public void setArtistAlbums(Collection<ArtistsAlbums> artistAlbums) {
		this.artistsAlbums = artistAlbums;
	}


	public Collection<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<Track> tracks) {
		this.tracks = tracks;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Collection<Album> albums) {
		this.albums = albums;
	}
	
	public void addAlbum(Album album) {
		albums.add(album);
	}

	public String getCrucialInfo() {
		return crucialInfo;
	}

	public void setCrucialInfo(String crucialInfo) {
		this.crucialInfo = crucialInfo;
	}

	@Override
	public int compareTo(Artist artist) {
		
		return artistName.compareTo(artist.getArtistName());
	}
	
	@Override
	public boolean equals(Object anotherArtist) {
		
		return artistId.equals(((Artist)anotherArtist).getArtistId());
	}
	
}

