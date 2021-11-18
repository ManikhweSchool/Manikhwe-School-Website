package com.manikhweschool.music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.manikhweschool.music.model.Image;
import com.manikhweschool.music.service.ImageService;

//@Controller
public class ImageController {

	//@Autowired
	private ImageService service;
	
	public HttpStatus saveImage(Image image) {
		
		return service.saveImage(image);
	}
	
	public Optional<Image> findImage(String imageURL){
		return service.findImage(imageURL);
	}
	
	public List<Image> findAll(){
		return service.findAll();
	}

	public ImageService getService() {
		return service;
	}

	public void setService(ImageService service) {
		this.service = service;
	}
	
	
}

