package com.manikhweschool.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manikhweschool.model.Student;
import com.manikhweschool.model.TodayVisitation;
import com.manikhweschool.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	private StudentService service;
			
	@Autowired
	private Student student;
	
	@Autowired
	private
	PythonChapterController pythonChapterController;
	
	@Autowired
	private
	JavaChapterController javaChapterController;
	
	
	//@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signIn(
		Model model, 
		HttpSession session,
		@RequestParam("previousPage") String previousPage
	) {
		
		model.addAttribute("student", student);
		model.addAttribute("previousPage", previousPage);
		
		
		return "SignIn";
	}
	
	// PayFast subscription return page
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signIn(
		// The student parameter is only passed if students can register without subscribing.
		/*@ModelAttribute(name="student")
		Student student, */
		@ModelAttribute(name="previousPage")
		String previousPage,
		Model model,
		HttpSession session
	) {
		
		
		String status;
		String page;
		
		if(service.findStudent(student.getEmail()).isPresent()) {
			model.addAttribute("invalidStudent", true);
			page = "SignIn";
			status = "Email Already Exist";
			
		}
		else {
			if(student.getPassword().equals(student.getConfirmPassword())) {
				service.addStudent(student);
				model.addAttribute("invalidStudent", false);
				model.addAttribute("previousPage", "index");
				status = "Student Succefully Registered";
				page = "RegistrationConfirmation";
				if(session.getAttribute("student")==null)
					session.setAttribute("student", student);
				// The else part is only useful if students only register after subscription.
				else
					student.setHasSubscribed(true);
			}
			else {
				model.addAttribute("invalidStudent", true);
				page = "SignIn";
				status = "Password Don't Match";
			}
		}
		
		model.addAttribute("status", status );
		
		return page;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
		@RequestParam("previousPage") 
		String previousPage, 
		Model model, 
		HttpSession session
	) {
		
		
		model.addAttribute("student", student);
		model.addAttribute("previousPage", previousPage);
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			System.out.println("Session Created...");
		}
		
		return "Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
		HttpSession session,
		@ModelAttribute(name="student")Student student, 
		@ModelAttribute(name="previousPage")String previousPage,
		Model model
	) {
		
		
		String status;
		
		Optional<Student> retrievedStudent = findStudent(student.getEmail());
		
		if(retrievedStudent.isPresent()) {
			if(!retrievedStudent.get().equals(student)) {
				model.addAttribute("invalidCredetials",true);
				
				status = "Incorrect Credentials";
				return "Login";
				
			}
			else {
				
				model.addAttribute("invalidCredetials",false);
				//model.addAttribute("student",student);
				
				session.setAttribute("student", student);
				status = "Correct Credentials";
				
				
				String language = previousPage.substring(0,
				previousPage.indexOf('-'));
				
				byte chapterNumber = Byte.parseByte(
				previousPage.substring(previousPage.
				indexOf('-')+1));
				
				
				switch(language) {
				case "python":
					if(chapterNumber<15)
						return pythonChapterController.visitPartOne("{"+chapterNumber+"}", session);
					else if(chapterNumber<19)
						return pythonChapterController.visitPartTwo("{"+chapterNumber+"}", session);
					else 
						return pythonChapterController.visitPartThree("{"+chapterNumber+"}", session);
					
					
				case "java":
					if(chapterNumber<9)
						return javaChapterController.visitPartOne("{"+chapterNumber+"}", session);
					else if(chapterNumber<14 || chapterNumber==17)
						return javaChapterController.visitPartTwo("{"+chapterNumber+"}", session);
					else if(chapterNumber<17)
						return javaChapterController.visitPartThree("{"+chapterNumber+"}", session);
					else if(chapterNumber<30)
						return javaChapterController.visitPartFour("{"+chapterNumber+"}", session);
					else 
						return javaChapterController.visitPartFive("{"+chapterNumber+"}", session);
					
				default:
					System.out.println("Programming Language Is Neither Java Nor Python.");
					return "index";
				}
				
				
				
			}
			
		}
		else {
			model.addAttribute("invalidCredetials", true);
			status = "Incorrect Credentials";
			model.addAttribute("status", status);
			return "Login";
			
		}
		
		
		
	}
	
	// Paypal subscription return page
	@RequestMapping(value = "/welcome", 
	method = RequestMethod.POST)
	public String subscribe(HttpSession session) {
				
		String email = ((Student)session.getAttribute("student")).getEmail();
		Student retrievedStudent = service.findStudent(email).get();
		retrievedStudent.setHasSubscribed(true);
		retrievedStudent.setSubscriptionDate(new Date());
		
		return "SubscriptionConfirmation";
	}
	
	// Paypal cancel return page
	@RequestMapping(value = "/cancel", 
	method = RequestMethod.POST)
	public String unsubscribe(HttpSession session) {
						
		String email = ((Student)session.getAttribute("student")).getEmail();
		Student retrievedStudent = service.findStudent(email).get();
		retrievedStudent.setHasSubscribed(false);
		retrievedStudent.setUnsubscriptionDate(new Date());
		
		return "SubscriptionCancellation";
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
	public String visitGames(HttpSession session) {
					
		
		if(session.isNew()) {
			
			TodayVisitation todayVisitation = (TodayVisitation)session.getServletContext().getAttribute("todayVisitation");
			todayVisitation.increaseDayVisitorNumber();
			System.out.println("Session Created...");
		}
		
		return "clock";
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
