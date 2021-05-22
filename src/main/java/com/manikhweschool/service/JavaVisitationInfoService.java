package com.manikhweschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.dao.JavaVisitationInfoRepository;
import com.manikhweschool.model.JavaVisitationInfo;

@Service
public class JavaVisitationInfoService {

	@Autowired
	private JavaVisitationInfoRepository repository;
	
	public void save(JavaVisitationInfo info) {
		repository.save(info);
	}
	
	public List<JavaVisitationInfo> findAll(){
		return repository.findAll();
	}
}
