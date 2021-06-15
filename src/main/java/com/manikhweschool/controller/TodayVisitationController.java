package com.manikhweschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.manikhweschool.model.TodayVisitation;
import com.manikhweschool.service.TodayVisitationService;

@Controller
public class TodayVisitationController {

	@Autowired
	private TodayVisitationService service;
	
	public void save(TodayVisitation info) {
		service.save(info);
	}
	
	public List<TodayVisitation> findAll(){
		return service.findAll();
	}
}
