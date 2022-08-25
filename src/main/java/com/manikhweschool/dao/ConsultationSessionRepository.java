package com.manikhweschool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.model.ConsultationSession;

@Repository
public interface ConsultationSessionRepository extends JpaRepository<ConsultationSession,Long>{

}
