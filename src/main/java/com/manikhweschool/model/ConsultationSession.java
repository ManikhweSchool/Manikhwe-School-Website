package com.manikhweschool.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "ConsultationSession")
@Component
public class ConsultationSession implements Comparable<ConsultationSession>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Session_Id", nullable = false)
	private long sessionId;
	
	@Column(name = "Session_Query_Date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(value = TemporalType.DATE)
	private Date sessionQueryDate;
	
	@Column(name="Session_Prefered_Date", nullable = false)
	private String sessionPreferedDate = "";
	
	@Column(name="Session_Done", nullable = false)
	private boolean isSessionDone = false;
	
	@Column(name="Session_Selected_Date", nullable = false)
	private static String sessionSelectedDay = "";
	
	@ElementCollection
	private Set<String> languages;
	
	@Column(name="Session_Phone_Number", nullable = false)
	private String sessionPhoneNumber;
	
	@Column(name = "Session_Address", nullable = false)
	private String sessionAddress;
	
	@ManyToOne
	@Autowired
	Student student;

	public ConsultationSession() {
		sessionQueryDate = new Date();
		languages = new HashSet<>();
	}

	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	public Date getSessionQueryDate() {
		return sessionQueryDate;
	}

	public void setSessionQueryDate(Date sessionQueryDate) {
		this.sessionQueryDate = sessionQueryDate;
	}

	public String getSessionPreferedDate() {
		return sessionPreferedDate;
	}

	public void setSessionPreferedDate(String sessionPreferedDate) {
		this.sessionPreferedDate = sessionPreferedDate;
	}

	public boolean isSessionDone() {
		return isSessionDone;
	}

	public void setSessionDone(boolean isSessionDone) {
		this.isSessionDone = isSessionDone;
	}

	public String getSessionSelectedDay() {
		return sessionSelectedDay;
	}

	public void setSessionSelectedDay(String sessionSelectedDay) {
		ConsultationSession.sessionSelectedDay = sessionSelectedDay;
	}

	public Set<String> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<String> languages) {
		this.languages = languages;
	}

	public String getSessionPhoneNumber() {
		return sessionPhoneNumber;
	}

	public void setSessionPhoneNumber(String sessionPhoneNumber) {
		this.sessionPhoneNumber = sessionPhoneNumber;
	}

	public String getSessionAddress() {
		return sessionAddress;
	}

	public void setSessionAddress(String sessionAddress) {
		this.sessionAddress = sessionAddress;
	}
	
	@Override
	public int compareTo(ConsultationSession session) {
		return sessionPreferedDate.compareTo(session.getSessionPreferedDate());
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
