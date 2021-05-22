package com.manikhweschool.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikhweschool.dao.StudentRepository;
import com.manikhweschool.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<Student> findByFirstName(String firstName){return repository.findByFirstName(firstName);}
	public List<Student> findByLastName(String lastName){ return repository.findByLastName(lastName);}
	public List<Student> findByGender(String gender){ return repository.findByGender(gender);}
	
	public List<Student> findByJoinedDate(Date joinedDate){return repository.findByJoinedDate(joinedDate);}
	public List<Student> findByJoinedDateGreaterThan(Date joinedDate){return repository.findByJoinedDateGreaterThan(joinedDate);}
	public List<Student> findByJoinedDateLessThan(Date joinedDate){ return repository.findByJoinedDateLessThan(joinedDate);}
	
	public StudentRepository getRepository() {
		return repository;
	}
	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	public void addStudent(Student newStudent) {
		
		repository.save(newStudent);
		
	}
	
	public long count() {
		return repository.count();
	}
	
	public Optional<Student> findStudent(String email) {
		
		return repository.findById(email);
	}
	
	public List<Student> findAllStudents() {
		return repository.findAll();
	}

	public void deleteStudent(String email) {
		
		repository.deleteById(email);
	}
}
