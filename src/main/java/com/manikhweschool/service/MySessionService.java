package com.manikhweschool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.dao.MySessionRepository;
import com.manikhweschool.model.MySession;

@Service
public class MySessionService{
    
     @Autowired
    private MySessionRepository repository;

    public void saveSession(MySession session){
        repository.save(session);
    }
    
	public Optional<MySession> findSession(int id) {
		
		return repository.findById(id);
	}

    public List<MySession> findAllSessions(){
        return repository.findAll();
    }
}