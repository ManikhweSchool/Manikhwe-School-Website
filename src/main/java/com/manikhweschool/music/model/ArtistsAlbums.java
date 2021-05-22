package com.manikhweschool.music.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ARTIST_ALBUMS")
@Component
public class ArtistsAlbums implements Serializable,Cloneable, Comparable<ArtistsAlbums>{

	private static final long serialVersionUID = 4240312753588530203L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long artistAlbumsId;
	
	@Column(name = "Number_Of_Albums", nullable = false)
	private short numberOfAlbums;
	
	@Column(name = "Albums_Limit", nullable = false)
	private byte albumsLimit;
	
	@Column(name = "Albums_Offset", nullable = false)
	private byte albumsOffset;
	
	@Column(name = "Next_Album_Info", nullable = false)
	private String nextAlbumInfo;
	
	@Column(name = "Previous_Album_Info", nullable = false)
	private String previousAlbumInfo;
	
	
	@ManyToMany
	private Collection<Artist> artists;
	
	@OneToMany
	private Set<Album> albums;
	
	public ArtistsAlbums() {
		
		numberOfAlbums = 0;
		albumsLimit = 0;
		albumsOffset = 0;
		nextAlbumInfo = "";
		previousAlbumInfo = "";
		albums = new TreeSet<>();
		artists = new TreeSet<>();
	}

	@Override
	public String toString() {
		String representation = "";
		
		//representation += artist.toString();
		representation += "\nArtist number Of Albums : " + numberOfAlbums;
		representation += "\nArtist Albums Limit : " + albumsLimit;
		representation += "\nArtist Albums Offset : " + albumsOffset;
		representation += "\nArtist Albums  Next Album URI: " + nextAlbumInfo;
		representation += "\nArtist Albums  Prev Album URI: " + previousAlbumInfo;
		
		return representation;
	}
	
	public void viewArtistAlbums() {
		System.out.println(toString());
	}

	public short getNumberOfAlbums() {
		return numberOfAlbums;
	}


	public void setNumberOfAlbums(short numberOfAlbums) {
		this.numberOfAlbums = numberOfAlbums;
	}


	public byte getAlbumsLimit() {
		return albumsLimit;
	}


	public void setAlbumsLimit(byte albumsLimit) {
		this.albumsLimit = albumsLimit;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public byte getAlbumsOffset() {
		return albumsOffset;
	}


	public void setAlbumsOffset(byte albumsOffset) {
		this.albumsOffset = albumsOffset;
	}


	public String getNextAlbumInfo() {
		return nextAlbumInfo;
	}


	public void setNextAlbumInfo(String nextAlbumInfo) {
		this.nextAlbumInfo = nextAlbumInfo;
	}


	public String getPreviousAlbumInfo() {
		return previousAlbumInfo;
	}


	public void setPreviousAlbumInfo(String previousAlbumInfo) {
		this.previousAlbumInfo = previousAlbumInfo;
	}

	public Long getArtistAlbumsId() {
		return artistAlbumsId;
	}
	
	public Collection<Artist> getArtists() {
		return artists;
	}
	

	public void setArtists(Collection<Artist> artists) {
		this.artists = artists;
	}

	@Override
	public int compareTo(ArtistsAlbums artistsAlbums) {
		
		int result = 0;
		
		Object[] newArtists = artistsAlbums.getArtists().toArray();
		Object[] oldArtists = artists.toArray();
		
		for(int i = 0; i < newArtists.length && 
		i < oldArtists.length && result==0;i++) 
			result = ((Artist)oldArtists[i]).compareTo(((Artist)newArtists[i]));
			
		return result;
			
	}
	
}

