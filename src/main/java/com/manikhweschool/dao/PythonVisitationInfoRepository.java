package com.manikhweschool.dao;

import java.util.GregorianCalendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.model.PythonVisitationInfo;

@Repository
public interface PythonVisitationInfoRepository extends JpaRepository<PythonVisitationInfo,GregorianCalendar>{

}
