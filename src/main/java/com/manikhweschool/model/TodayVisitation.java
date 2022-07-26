package com.manikhweschool.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "TODAY_VISITATION")
@Component
public class TodayVisitation implements Serializable{

	private static final long serialVersionUID = -3935420195086572801L;

	@Id
	@Column(name = "Date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(value = TemporalType.DATE)
	private Calendar calendar;
	
	@Column(name="Total_Day_Visitors", nullable = false)
	private int dayVisitorNumber;
	
	@Embedded
	private JavaVisitationInfo javaVisitationInfo;
	
	@Embedded
	private PythonVisitationInfo pythonVisitationInfo;
	
	@Embedded
	private DartVisitationInfo dartVisitationInfo;
	
	public TodayVisitation() {
		calendar = new GregorianCalendar();
		dayVisitorNumber = 0;
	}
	
	public TodayVisitation(GregorianCalendar calendar,
	JavaVisitationInfo javaVisitationInfo,
	PythonVisitationInfo pythonVisitationInfo,
	DartVisitationInfo dartVisitationInfo) {
		this.calendar = calendar;
		dayVisitorNumber = 0;
		this.javaVisitationInfo = javaVisitationInfo;
		this.pythonVisitationInfo = pythonVisitationInfo;
		this.dartVisitationInfo = dartVisitationInfo;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}
	
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setJavaVisitationInfo(JavaVisitationInfo javaVisitationInfo) {
		this.javaVisitationInfo = javaVisitationInfo;
	}

	public void setPythonVisitationInfo(PythonVisitationInfo pythonVisitationInfo) {
		this.pythonVisitationInfo = pythonVisitationInfo;
	}

	public JavaVisitationInfo getJavaVisitationInfo() {
		return javaVisitationInfo;
	}

	public PythonVisitationInfo getPythonVisitationInfo() {
		return pythonVisitationInfo;
	}

	public DartVisitationInfo getDartVisitationInfo() {
		return dartVisitationInfo;
	}

	public void setDartVisitationInfo(DartVisitationInfo dartVisitationInfo) {
		this.dartVisitationInfo = dartVisitationInfo;
	}

	public int getDayVisitorNumber() {
		return dayVisitorNumber;
	}
	
	public void increaseDayVisitorNumber() {
		dayVisitorNumber++;
	}
	
	@Override
	public String toString() {
		return calendar.toString() + " " + dayVisitorNumber + " : visitors.";
	}
	
	@Override
	public boolean equals(Object o) {
		TodayVisitation newInfo = (TodayVisitation)o;
		
		return newInfo.getCalendar().equals(calendar) &&
		newInfo.getDayVisitorNumber()==dayVisitorNumber;
	}
}
