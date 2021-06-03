package com.manikhweschool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.model.MySession;

@Repository
public interface MySessionRepository extends JpaRepository<MySession, Integer>{
    
}