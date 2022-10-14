package com.manikhweschool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "STUDENT")
@Inheritance(strategy = InheritanceType.JOINED)
@Component
public class Student implements Comparable<Student>,Serializable{

	private static final long serialVersionUID = -3260535014484825041L;

    @Column(name = "Student_First_Name", nullable = false)
    private String firstName;
	
    @Column(name = "Student_last_Name", nullable = false)
    private String lastName;
	
    @Column(name = "Student_Password", nullable = false)
    private String password;
    
    @Column(name = "Student_CPassword", nullable = false)
    private String confirmPassword;
	
    @Id
	@Column(name = "Student_Email", nullable = false)
    private String email;

    @Column(name = "Sign_For_Updates", nullable = false)
    private boolean signedForUpdates;
	
    @Temporal(TemporalType.DATE)
    @Column(name = "Student_Joined_Date", nullable = false)
    private Date joinedDate;
    
    @Column(name = "Gender", nullable = false)
    private String gender;

    @ElementCollection
    private Collection<String> courses = new HashSet<>();;
    
    //@OneToMany(mappedBy="student")
    //private List<Rhythm> rhythms;
    
    private boolean isMember = false;
    
    private boolean hasSubscribed = false;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Student_SubscriptionDate_Date", nullable = false)
    private Date subscriptionDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Student_Unsubscription_Date", nullable = false)
    private Date unsubscriptionDate;
    
    @OneToMany
    private Collection<ConsultationSession> consultationSessions;
    

	public Student() {
	
		joinedDate = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(1000);
		subscriptionDate = calendar.getTime();
		unsubscriptionDate = calendar.getTime();
		/*rhythms = new ArrayList<>();*/
		consultationSessions = new ArrayList<>();
	}
	
	public Student(String firstName, 
	String lastName, Gender gender,String password, 
	String email, boolean signedForUpdates) {
		
		this.firstName = firstName;
		//this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.signedForUpdates = signedForUpdates;
		
	}
	
	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// Retrieve first name for this user.
	public String getFirstName() {
		return firstName;
	}

	// Change first name for this user.
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Retrieve last name for this user.
	public String getLastName() {
		return lastName;
	}

	// Change last name for this user.
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Retrieve password for this user.
	public String getPassword() {
		return password;
	}

	// Change password for this user.
	public void setPassword(String password) {
		this.password = password;
	}

	// Retrieve the email address of this user.
	public String getEmail() {
		return email;
	}

	// Change the email address of this user.
	public void setEmail(String email) {
		this.email = email;
	}

	// Return the date this user registered became a member.
	public Date getJoinedDate() {
		return joinedDate;
	}
		
	// Retrieve a value determining whether or not a user is signed for updates.
	public boolean getSignedForUpdates() {
		return signedForUpdates;
	}
	
		
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
		
	public void setSignedForUpdates(boolean signedForUpdates) {
		this.signedForUpdates = signedForUpdates;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public Collection<String> getCourses() {
		return courses;
	}

	public void setCourses(Collection<String> courses) {
		this.courses = courses;
	}
	
	public String processStudentRegistration(){
        /*
        if(!StudentController.studentExist(this)) return "Confirm_Registration";
        else return "";*/
		return "";
    }
	
	@Override
	public boolean equals(Object object) {
		
		return 
		password.equals(((Student)object).getPassword()) &&
		email.equals(((Student)object).getEmail());
	}
	
	public boolean doPasswordsMatch(String confirmationEmail){ return email.equals(confirmationEmail);} 

	@Override
	public int compareTo(Student student) {

		int returnedValue = firstName.compareTo(
		student.getFirstName());
		
		if(returnedValue==0) {
			returnedValue = lastName.compareTo(
			student.getLastName());
			if(returnedValue==0)
				returnedValue = email.compareTo(
				student.getEmail());
		}

		return returnedValue;
	}
	
	public boolean isHasSubscribed() {
		return hasSubscribed;
	}

	public void setHasSubscribed(boolean hasSubscribed) {
		this.hasSubscribed = hasSubscribed;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Date getUnsubscriptionDate() {
		return unsubscriptionDate;
	}

	public void setUnsubscriptionDate(Date unsubscriptionDate) {
		this.unsubscriptionDate = unsubscriptionDate;
	}

	public Collection<ConsultationSession> getConsultationSessions() {
		return consultationSessions;
	}

	public void setConsultationSessions(Collection<ConsultationSession> consultationSessions) {
		this.consultationSessions = consultationSessions;
	}
	
	public void addConsultationSession(ConsultationSession consultationSession) {
		consultationSessions.add(consultationSession);
	}
	
	/*
	public List<Rhythm> getRhythms() {
		return rhythms;
	}

	public void setRhythms(List<Rhythm> rhythms) {
		this.rhythms = rhythms;
	}
	
	public void addRhythm(Rhythm rhythm) {
		rhythms.add(rhythm);
	}*/
}