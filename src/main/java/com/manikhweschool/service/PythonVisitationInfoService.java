package com.manikhweschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.dao.PythonVisitationInfoRepository;
import com.manikhweschool.model.PythonVisitationInfo;

@Service
public class PythonVisitationInfoService {

	@Autowired
	private PythonVisitationInfoRepository repository;
	
	public void save(PythonVisitationInfo info) {
		repository.save(info);
	}
	
	public List<PythonVisitationInfo> findAll(){
		return repository.findAll();
	}
}
