package com.manikhweschool.music.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*@Entity
@Table(name = "TRACK")
@Component*/
public class Track implements Serializable,Cloneable,Comparable<Track>{

	private static final long serialVersionUID = -5646821396794741818L;
	
	/*	A link to the Web API endpoint 
	 * providing full details of the track.*/
	//@Column(name = "Track_URL", nullable = false)
	private String trackURL;
	
	//@Column(name = "Track_Name", nullable = false)
	private String trackName = "";

	//@Column(name = "Track_Type", nullable = false)
	private String trackType;
	
	/*@ManyToMany
	@JoinTable(
		name = "Track_Rhythm_Bridge",
		joinColumns = @JoinColumn(name = "Track_FK"),
		inverseJoinColumns = @JoinColumn(name = "Rhythm_FK"))*/
    private Collection<Rhythm> rhythms;
	
	// The album to which this track belongs.
	/*@ManyToOne
	@JoinColumn(name="owning_album_id")*/
	private Album album;
	
	// Artists involved on this track.
	/*@ManyToMany(mappedBy = "tracks",
	cascade = CascadeType.ALL)*/
	private Collection<Artist> artists;
	
	/*A list of the countries in which the 
	 * track can be played, identified by 
	 * their ISO 3166-1 alpha-2 code.*/
	//@ElementCollection
	private Collection<String> availableMarkets;
	
	/*The disc number (usually 1 unless the 
	 * album consists of more than one disc)*/
	//@Column(name = "Disc_Number", nullable = false)
	private int discNumber;
	
	/*The track length in milliseconds.*/
	//@Column(name = "Duration_MS", nullable = false)
	private long duration_ms;
	
	/*The Spotify ID for the track.*/
	//@Id
	//@Column(name = "Spotify_Id", nullable = false)
	private String trackId;
	
	/*Part of the response when Track Relinking 
	 * is applied. If true , the track is playable 
	 * in the given market. Otherwise false.*/
	//@Column(name = "Is_Playable", nullable = false)
	private boolean isPlayable;
    
	/*Generally speaking, songs that are being played 
	 * a lot now will have a higher popularity than 
	 * songs that were played a lot in the past. 
	 * Duplicate tracks (e.g. the same track from a 
	 * single and an album) are rated independently. 
	 * Artist and album popularity is derived mathematically 
	 * from track popularity. Note that the popularity value 
	 * may lag actual popularity by a few days: the value is 
	 * not updated in real time.*/
	//@Column(name = "Popularity", nullable = false)
	private int popularity;
	
	/*The Spotify URI for the track.*/
	//@Column(name = "Track_URI", nullable = false)
	private String trackURI;
	
	//@Column(name = "Track_Number", nullable = false)
	private int trackNumber;
	
    public Track() {
    	rhythms = new ArrayList<>();
    	availableMarkets = new HashSet<>();
    	artists = new HashSet<>(); 
    }
    
    @Override
    public String toString() {
    	String representation = 
    	"\n\tTrack Name : " + trackName +
    	"\n\tTrack Number : " + trackNumber +
    	"\n\tDisc Number : " + discNumber + 
    	"\n\tDuration(ms) : " + duration_ms +
    	"\n\tTrack Id : " + trackId +
    	"\n\tIs Playable : " + isPlayable +
    	"\n\tPopularity : " + popularity +
    	"\n\tTrack URL : " + trackURL +
    	"\n\tTrack URI : " + trackURI + "\n\t";
    	
    	if(!artists.isEmpty()){
	    	byte count = 0;
	    	for(Artist artist : artists) {
	    		if(artist != null) {
	    		representation += artist.toString();
	    		if(count<artists.size()-1)
	    			representation += ", ";
	    		count++;
	    		}
	    		else System.out.println("Artist Is Null");
	    	}
    	}
    	
    	representation += "\n\tAvailable Market => \n\t\t";
    	
    	for(int i = 0; i < availableMarkets.size();i++) {
    		representation += ((java.util.List<String>)availableMarkets).get(i);
    		if(i<availableMarkets.size()-1)
    			representation += ", ";
    		if((i+1)%10==0)
    			representation += "\n\t\t";
    			
    	}
    	
    	representation += "\n\n\t\tAlbum Info =>" +
    	"\n\t\t\tAlbum Name : " + album.getAlbumName() +
    	"\n\t\t\tAlbum Type : " + album.getAlbumType() +
    	"\n\t\t\tAlbum Id : " + album.getAlbumId() +
    	"\n\t\t\tAlbum URI : " + album.getAlbumURI() +
    	"\n\t\t\tAlbum URL : " + album.getAlbumURL() +
    	"\n\t\t\tAlbum Release Date : " + album.getReleaseDate() +
    	"\n\t\t\tAlbum Release Date Precision : " + album.getReleaseDatePrecision() +
    	"\n\n\t\t\tArtists On This Album => " +
    	"\n\t\t\t";
    	
    	for(int i = 0; i < album.getArtists().size();i++) {
    		representation += "\tName : " + ((java.util.List<Artist>)album.getArtists()).get(i).getArtistName();
    		representation += "\n\t\t\t\tID : " + ((java.util.List<Artist>)album.getArtists()).get(i).getArtistId();
    		representation += "\n\t\t\t\tURI : " + ((java.util.List<Artist>)album.getArtists()).get(i).getArtistURI();
    		representation += "\n\t\t\t\tURL : " + ((java.util.List<Artist>)album.getArtists()).get(i).getArtistURL();
    		representation += "\n\n\t\t\t";
    	}
    	representation = representation.trim();
    	representation += "\n\n\t\tAlbum Available Market => \n\t\t";
    	
    	for(int i = 0; i < album.getAvailableMarkets().size();i++) {
    		representation += "\t";
    		representation += ((java.util.List<String>)album.getAvailableMarkets()).get(i);
    		if(i<album.getAvailableMarkets().size()-1)
    			representation += ", ";
    		if((i+1)%10==0)
    			representation += "\n\t\t";
    			
    	}
    	
    	return representation;
    }
    
    @Override
    public Object clone() throws 
    CloneNotSupportedException { 
    	return super.clone();
    }
    
    @Override
    public boolean equals(Object object) {
    	
    	return ((Track) object).getTrackId().equals(trackId);
    }
    
    public void viewTrack() {
    	System.out.print(toString());
    }
    
    public void addArtist(Artist artist) {
    	if(artists==null) artists = new HashSet<>();
    	artists.add(artist);
    }

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

    public void addRhythm(Rhythm rhythm){
        rhythms.add(rhythm);
    }
    
    public Collection<Rhythm> getRhythms(){
        return rhythms;
    }

    public Rhythm getRhythm(int index) {
	return ((ArrayList<Rhythm>) rhythms).get(index);
    }

    public void setRhythm(Rhythm rhythm, int index) {
        ((ArrayList<Rhythm>) rhythms).set(index, rhythm);
    }

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<Artist> artist) {
		this.artists = artist;
	}

	public Collection<String> getAvailableMarkets() {
		return availableMarkets;
	}

	public void setAvailableMarkets(Collection<String> availableMarkets) {
		this.availableMarkets = availableMarkets;
	}

	public int getDiscNumber() {
		return discNumber;
	}

	public void setDiscNumber(int discNumber) {
		this.discNumber = discNumber;
	}

	public long getDuration_ms() {
		return duration_ms;
	}

	public void setDuration_ms(long duration_ms) {
		this.duration_ms = duration_ms;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String spotifyId) {
		this.trackId = spotifyId;
	}

	public boolean isPlayable() {
		return isPlayable;
	}

	public void setPlayable(boolean isPlayable) {
		this.isPlayable = isPlayable;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getTrackURI() {
		return trackURI;
	}

	public void setTrackURI(String spotifyURI) {
		this.trackURI = spotifyURI;
	}

	public void setRhythms(Collection<Rhythm> rhythms) {
		this.rhythms = rhythms;
	}

	public String getTrackURL() {
		return trackURL;
	}

	public void setTrackURL(String trackURL) {
		this.trackURL = trackURL;
	}

	public String getTrackType() {
		return trackType;
	}

	public void setTrackType(String trackType) {
		this.trackType = trackType;
	}

	@Override
	public int compareTo(Track track) {
		
		if(trackNumber<track.getTrackNumber()) return -1;
		else if(trackNumber>track.getTrackNumber()) return 1;
		return 0;
	}
	
}

