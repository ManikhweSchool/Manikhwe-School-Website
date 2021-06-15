package com.manikhweschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.dao.TodayVisitationRepository;
import com.manikhweschool.model.TodayVisitation;

@Service
public class TodayVisitationService {

	@Autowired
	private TodayVisitationRepository repository;
	
	public void save(TodayVisitation info) {
		repository.save(info);
	}
	
	public List<TodayVisitation> findAll(){
		return repository.findAll();
	}
}
