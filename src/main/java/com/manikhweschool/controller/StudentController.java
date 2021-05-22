package com.manikhweschool.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manikhweschool.model.Student;
import com.manikhweschool.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	private StudentService service;
			
	@Autowired
	private Student student;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signIn(Model model) {
		
		model.addAttribute("student", student);
		return "SignIn";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signIn(@ModelAttribute(name="student")Student student, Model model) {
		
		String status;
		String page;
		
		
		if(service.findStudent(student.getEmail()).isPresent()) {
			model.addAttribute("invalidStudent", true);
			page = "SignIn";
			status = "Email Already Exist";
			model.addAttribute("invalidStudent", true);
		}
		else {
			service.addStudent(student);
			model.addAttribute("invalidStudent", false);
			status = "Student Succefully Registered";
			page = "RegistrationConfirmation";
		}
		
		model.addAttribute("status", status );
		
		return page;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		model.addAttribute("student", student);
		return "Login";
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(@ModelAttribute(name="student")Student student, Model model) {
		
		String page;
		String status;
		
		Optional<Student> retrievedStudent = findStudent(student.getEmail());
		
		if(retrievedStudent.isPresent()) {
			if(!retrievedStudent.get().equals(student)) {
				model.addAttribute("invalidCredetials",true);
				
				status = "Incorrect Credentials";
				page = "Login";
			}
			else {
				model.addAttribute("invalidCredetials",false);
				model.addAttribute("student",student);
				status = "Correct Credentials";
				page = "index";
			}
			
		}
		else {
			model.addAttribute("invalidCredetials", true);
			status = "Incorrect Credentials";
			page = "Login";
			
		}
		
		model.addAttribute("status", status);
		return page;
	}
	
	@RequestMapping(value = "/find/student/{email}", method = RequestMethod.GET)
	public Optional<Student> findStudent(@RequestParam("email") String email) {
		
		return service.findStudent(email);
	}
	
	@RequestMapping(value = "/delete/student/{email}", method = RequestMethod.DELETE)
	public void deleteStudent(@RequestParam("email")String email) {
		
		service.deleteStudent(email);
	}
	
	@RequestMapping(value = "/games", 
	method = RequestMethod.GET)
	public String visitGames() {
						
		return "Games";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> findAllStudents() {
		return service.findAllStudents();
	}
	
	@RequestMapping(value = "/find/students/{firstname}", method = RequestMethod.GET)
	public List<Student> findByFirstName(@RequestParam("firstname")String firstName){return service.findByFirstName(firstName);}
	@RequestMapping(value = "/find/students/{lastname}", method = RequestMethod.GET)
	public List<Student> findByLastName(@RequestParam("lastname")String lastName){ return service.findByLastName(lastName);}
	@RequestMapping(value = "/find/students/{gender}", method = RequestMethod.GET)
	public List<Student> findByGender(@RequestParam("gender")String gender){ return service.findByGender(gender);}
	
	@RequestMapping(value = "/find/student/{datejoined}", method = RequestMethod.GET)
	public List<Student> findByJoinedDate(@RequestParam("datejoined")Date joinedDate){return service.findByJoinedDate(joinedDate);}
	@RequestMapping(value = "/find/student/after/{datejoined}", method = RequestMethod.GET)
	public List<Student> findByJoinedDateGreaterThan(@RequestParam("datejoined")Date joinedDate){return service.findByJoinedDateGreaterThan(joinedDate);}
	@RequestMapping(value = "/find/student/before/{datejoined}", method = RequestMethod.GET)
	public List<Student> findByJoinedDateLessThan(@RequestParam("datejoined")Date joinedDate){ return service.findByJoinedDateLessThan(joinedDate);}

	public boolean studentExist(Student student){
		
        return findStudent(student.getEmail()) != null;
    }
}
