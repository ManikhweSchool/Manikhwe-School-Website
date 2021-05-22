package com.manikhweschool.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.music.model.Rhythm;
import com.manikhweschool.music.repository.RhythmRepository;

@Service
public class RhythmService {

	@Autowired
	private RhythmRepository repository;

	public Rhythm saveRhythm(Rhythm rhythm){
		return repository.save(rhythm);
	}
	
	public Optional<Rhythm> findRhythm(long rhythmIndex){
		return repository.findById(rhythmIndex);
	}
	
	public void deleteRhythm(long rhythmIndex) {
		repository.deleteById(rhythmIndex);
	}
	
	public List<Rhythm> findAllRhythms(){
		return repository.findAll();
	}
}

