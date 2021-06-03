package com.manikhweschool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "SESSION")
@Component
public class MySession{

    
    @Id
    @GeneratedValue
    @Column(name = "Session_ID", nullable = false)
    private int sessionId;
    
	@Column(name = "Session_Student_Phone_Number", nullable = false)
    private String sessionPhoneNumber;

    @Column(name = "Session_Student_Grade", nullable = false)
    private String sessionGrade;
    
    @Column(name = "Session_Donation_Email", nullable = false)
    private String sessionDonationEmail;

    @Column(name = "Session_Section", nullable = false)
    private String sessionSectionOfInterest;

    @Column(name = "Session_Prefered_Date", nullable = false)
    private String sessionPreferedDate;
    
    @Column(name = "Session_Address", nullable = false)
    private String sessionAddress;

    @Autowired
    @ManyToOne
    private Student sessionStudent;

    public MySession() {

    	sessionDonationEmail = "Luganyile@gmail.com";
    	sessionPreferedDate = "";
	}
	
	public MySession(String firstName, 
	String lastName, String email, 
	String gender,String password, 
	String phoneNumber, String sessionAddress,
	String sessionDonationEmail,
    boolean signedForUpdates) {
		
		this.sessionPhoneNumber = phoneNumber;
		this.sessionDonationEmail = sessionDonationEmail;
		this.sessionAddress = sessionAddress;
        sessionStudent.setEmail(email) ;
        sessionStudent.setFirstName(firstName);
        sessionStudent.setLastName(lastName);
        sessionStudent.setPassword(password);
        sessionStudent.setJoinedDate(new Date());
		sessionStudent.setSignedForUpdates(signedForUpdates);
        sessionStudent.setGender(gender);
	}

    public String getSessionAddress() {
		return sessionAddress;
	}

	public void setSessionAddress(String sessionAddress) {
		this.sessionAddress = sessionAddress;
	}

	public String getSessionPhoneNumber(){
        return sessionPhoneNumber;
    }

    public void setSessionPhoneNumber(String phoneNumber){
        sessionPhoneNumber = phoneNumber;
    }

    public String getSessionDonationEmail() {
		return sessionDonationEmail;
	}

	public void setSessionDonationEmail(String donationEmail) {
		sessionDonationEmail = donationEmail;
	}

    public void setSessionSectionOfInterest(String sectionOfInterest){
        sessionSectionOfInterest = sectionOfInterest;
    }

    public String getSessionSectionOfInterest(){
        return sessionSectionOfInterest;
    }

    public void setSessionPreferedDate(String preferedDate){
        sessionPreferedDate = preferedDate;
    }

    public String getSessionPreferedDate(){
        return sessionPreferedDate;
    }

	public String getSessionGrade() {
		return sessionGrade;
	}

	public void setSessionGrade(String sessionStudentGrade) {
		this.sessionGrade = sessionStudentGrade;
	}

	public Student getSessionStudent() {
		return sessionStudent;
	}

	public void setSessionStudent(Student sessionStudent) {
		this.sessionStudent = sessionStudent;
	}
	
	public int getSessionId() {
		return sessionId;
	}
}