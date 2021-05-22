package com.manikhweschool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.dao.SessionRepository;
import com.manikhweschool.model.Session;

@Service
public class SessionService{
    
     @Autowired
    private SessionRepository repository;

    public void saveSession(Session session){
        repository.save(session);
    }
    
	public Optional<Session> findSession(int id) {
		
		return repository.findById(id);
	}

    public List<Session> findAllSessions(){
        return repository.findAll();
    }
}