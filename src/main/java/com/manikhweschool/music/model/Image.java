package com.manikhweschool.music.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*@Entity
@Table(name = "IMAGE")
@Component*/
public class Image implements Serializable,Cloneable{

	private static final long serialVersionUID = -8986839815197264420L;

	/*@Id
	@Column(name = "Image_Location", nullable = false)*/
	private String imageURL;
	
	//@Column(name = "Image_Width", nullable = false)
	private short width;
	
	//@Column(name = "Image_Height", nullable = false)
	private short height;
	
	/*@ManyToOne
	@JoinColumn(name="owning_artist_id")*/
	private Artist artist;
	
	/*@ManyToOne
	@JoinColumn(name="owning_album_id")*/
	private Album album;
	
	public Image() {
		imageURL = "";
		width = 0;
		height = 0;
	}
	
	@Override
	public String toString() {
		return "Image Width : " + width +
		"\tImage Height : " + height +
		"\nImage URL : " + imageURL + "\n";
	}
	
	@Override
    public Object clone() throws 
    CloneNotSupportedException { 
    	return super.clone();
    }

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public short getWidth() {
		return width;
	}

	public void setWidth(short width) {
		this.width = width;
	}

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}

