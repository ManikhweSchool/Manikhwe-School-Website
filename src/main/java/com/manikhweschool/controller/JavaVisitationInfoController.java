package com.manikhweschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.manikhweschool.model.JavaVisitationInfo;
import com.manikhweschool.service.JavaVisitationInfoService;

@Controller
public class JavaVisitationInfoController {

	@Autowired
	private JavaVisitationInfoService service;
	
	public void save(JavaVisitationInfo info) {
		service.save(info);
	}
	
	public List<JavaVisitationInfo> findAll(){
		return service.findAll();
	}
}
