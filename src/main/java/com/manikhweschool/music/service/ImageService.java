package com.manikhweschool.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.manikhweschool.music.model.Image;
import com.manikhweschool.music.repository.ImageRepository;

@Service
@Component
public class ImageService {

	@Autowired
	private ImageRepository repository;
	
	public HttpStatus saveImage(Image image) {
		if(repository.findById(image.getImageURL()).isPresent())
			return HttpStatus.NOT_ACCEPTABLE;
		repository.save(image);
		return HttpStatus.ACCEPTED;
	}
	
	public Optional<Image> findImage(String imageURL){
		return repository.findById(imageURL);
	}
	
	public List<Image> findAll(){
		return repository.findAll();
	}

	public ImageRepository getRepository() {
		return repository;
	}

	public void setRepository(ImageRepository repository) {
		this.repository = repository;
	}
	
	
}

