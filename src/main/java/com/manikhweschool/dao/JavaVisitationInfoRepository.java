package com.manikhweschool.dao;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.model.JavaVisitationInfo;

@Repository
public interface JavaVisitationInfoRepository extends JpaRepository<JavaVisitationInfo,Calendar>{

}
