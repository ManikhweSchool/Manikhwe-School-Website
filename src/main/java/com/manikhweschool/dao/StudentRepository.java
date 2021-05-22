package com.manikhweschool.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{

	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);
	public List<Student> findByGender(String gender);	
	
	public List<Student> findByJoinedDate(Date joinedDate);
	public List<Student> findByJoinedDateGreaterThan(Date joinedDate);
	public List<Student> findByJoinedDateLessThan(Date joinedDate);
	
}
