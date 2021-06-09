package com.manikhweschool.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "VISITATION_INFO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Component
public class VisitationInfo implements HttpSessionBindingListener,
Serializable{

	
	private static final long serialVersionUID = -1992466193675255606L;

	@Id	
	@Column(name = "Date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(value = TemporalType.DATE)
	protected Calendar calendar;
	
	@Column(name="Total_Day_Visitors", nullable = false)
	protected int dayVisitorNumber;
	
	@Column(name="Chapter1_Visitors", nullable = false)
	protected int chapterOneDayVisitors;
	@Column(name="Chapter2_Visitors", nullable = false)
	protected int chapterTwoDayVisitors;
	@Column(name="Chapter3_Visitors", nullable = false)
	protected int chapterThreeDayVisitors;
	@Column(name="Chapter4_Visitors", nullable = false)
	protected int chapterFourDayVisitors;
	@Column(name="Chapter5_Visitors", nullable = false)
	protected int chapterFiveDayVisitors;
	@Column(name="Chapter6_Visitors", nullable = false)
	protected int chapterSixDayVisitors;
	@Column(name="Chapter7_Visitors", nullable = false)
	protected int chapterSevenDayVisitors;
	@Column(name="Chapter8_Visitors", nullable = false)
	protected int chapterEightDayVisitors;
	@Column(name="Chapter9_Visitors", nullable = false)
	protected int chapterNineDayVisitors;
	@Column(name="Chapter10_Visitors", nullable = false)
	protected int chapterTenDayVisitors;
	@Column(name="Chapter11_Visitors", nullable = false)
	protected int chapterElevenDayVisitors;
	@Column(name="Chapter12_Visitors", nullable = false)
	protected int chapterTwelveDayVisitors;
	@Column(name="Chapter13_Visitors", nullable = false)
	protected int chapterThirteenDayVisitors;
	@Column(name="Chapter14_Visitors", nullable = false)
	protected int chapterForteenDayVisitors;
	@Column(name="Chapter15_Visitors", nullable = false)
	protected int chapterFifteenDayVisitors;
	@Column(name="Chapter16_Visitors", nullable = false)
	protected int chapterSixteenDayVisitors;
	@Column(name="Chapter17_Visitors", nullable = false)
	protected int chapterSeventeenDayVisitors;
	@Column(name="Chapter18_Visitors", nullable = false) 
	protected int chapterEighteenDayVisitors;
	@Column(name="Chapter19_Visitors", nullable = false)
	protected int chapterNinteenDayVisitors;
	@Column(name="Chapter20_Visitors", nullable = false)
	protected int chapterTwentyDayVisitors;
	@Column(name="Chapter21_Visitors", nullable = false)
	protected int chapterTwentyOneDayVisitors;
	@Column(name="Chapter22_Visitors", nullable = false)
	protected int chapterTwentyTwoDayVisitors;
	@Column(name="Chapter23_Visitors", nullable = false)
	protected int chapterTwentyThreeDayVisitors;
	@Column(name="Chapter24_Visitors", nullable = false)
	protected int chapterTwentyFourDayVisitors;
	@Column(name="Chapter25_Visitors", nullable = false)
	protected int chapterTwentyFiveDayVisitors;
	
	@Column(name="Part1_Visitors", nullable = false)
	protected int partOneDayVisitors;
	@Column(name="Part2_Visitors", nullable = false)
	protected int partTwoDayVisitors;
	@Column(name="Part3_Visitors", nullable = false)
	protected int partThreeDayVisitors;
	@Column(name="Part4_Visitors", nullable = false)
	protected int partFourDayVisitors;
	
	protected VisitationInfo() {
		calendar = new GregorianCalendar();
		dayVisitorNumber = 0;
	}
	
	public void initializeDayVisitors() {
		
		partOneDayVisitors = 0;
		partTwoDayVisitors = 0;
		partThreeDayVisitors = 0;
		partFourDayVisitors = 0;
		
		chapterOneDayVisitors = 0;
		chapterTwoDayVisitors = 0;
		chapterThreeDayVisitors = 0;
		chapterFourDayVisitors = 0;
		chapterFiveDayVisitors = 0;
		chapterSixDayVisitors = 0;
		chapterSevenDayVisitors = 0;
		chapterEightDayVisitors = 0;
		chapterNineDayVisitors = 0;
		chapterTenDayVisitors = 0;
		chapterElevenDayVisitors = 0;
		chapterTwelveDayVisitors = 0;
		chapterThirteenDayVisitors = 0;
		chapterForteenDayVisitors = 0;
		chapterFifteenDayVisitors = 0;
		chapterSixteenDayVisitors = 0;
		chapterSeventeenDayVisitors = 0;
		chapterEighteenDayVisitors = 0;
		chapterNinteenDayVisitors = 0;
		chapterTwentyDayVisitors = 0;
		chapterTwentyOneDayVisitors = 0;
		chapterTwentyTwoDayVisitors = 0;
		chapterTwentyThreeDayVisitors = 0;
		chapterTwentyFourDayVisitors = 0;
		chapterTwentyFiveDayVisitors = 0;

	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		// Code to run now that I'm in a session.
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		// Code to run now that I'm no longer in a session.
	}
	
	public void increaseChapterOneDayVisitors() {
		chapterOneDayVisitors++;
	}
	public void increaseChapterTwoDayVisitors() {
		chapterTwoDayVisitors++;
	}
	public void increaseChapterThreeDayVisitors() {
		chapterThreeDayVisitors++;
	}
	public void increaseChapterFourDayVisitors() {
		chapterFourDayVisitors++;
	}
	public void increaseChapterFiveDayVisitors() {
		chapterFiveDayVisitors++;
	}
	public void increaseChapterSixDayVisitors() {
		chapterSixDayVisitors++;
	}
	public void increaseChapterSevenDayVisitors() {
		chapterSevenDayVisitors++;
	}
	public void increaseChapterEightDayVisitors() {
		chapterEightDayVisitors++;
	}
	public void increaseChapterNineDayVisitors() {
		chapterNineDayVisitors++;
	}
	public void increaseChapterTenDayVisitors() {
		chapterTenDayVisitors++;
	}
	public void increaseChapterElevenDayVisitors() {
		chapterElevenDayVisitors++;
	}
	public void increaseChapterTwelveDayVisitors() {
		chapterTwelveDayVisitors++;
	}
	public void increaseChapterThirteenDayVisitors() {
		chapterThirteenDayVisitors++;
	}
	public void increaseChapterForteenDayVisitors() {
		chapterForteenDayVisitors++;
	}
	public void increaseChapterFifteenDayVisitors() {
		chapterFifteenDayVisitors++;
	}
	public void increaseChapterSixteenDayVisitors() {
		chapterSixteenDayVisitors++;
	}
	public void increaseChapterSeventeenDayVisitors() {
		chapterSeventeenDayVisitors++;
	}
	public void increaseChapterEighteenDayVisitors() {
		chapterEighteenDayVisitors++;
	}
	public void increaseChapterNinteenDayVisitors() {
		chapterNinteenDayVisitors++;
	}
	
	public void increaseChapterTwentyDayVisitors() {
		chapterTwentyDayVisitors++;
	}
	public void increaseChapterTwentyOneDayVisitors() {
		chapterTwentyOneDayVisitors++;
	}
	public void increaseChapterTwentyThreeDayVisitors() {
		chapterTwentyThreeDayVisitors++;
	}
	public void increaseChapterTwentyFourDayVisitors() {
		chapterTwentyFourDayVisitors++;
	}
	public void increaseChapterTwentyFiveDayVisitors() {
		chapterTwentyFiveDayVisitors++;
	}
	
	public void increasePartOneDayVisitors() {
		partOneDayVisitors++;
	}
	public void increasePartTwoDayVisitors() {
		partTwoDayVisitors++;
	}
	public void increasePartThreeDayVisitors() {
		partThreeDayVisitors++;
	}
	public void increasePartFourDayVisitors() {
		partFourDayVisitors++;
	}
	
	public int getPartOneDayVisitors() {
		return partOneDayVisitors;
	}
	public int getPartTwoDayVisitors() {
		return partTwoDayVisitors;
	}
	public int getPartThreeDayVisitors() {
		return partThreeDayVisitors;
	}
	public int getPartFourDayVisitors() {
		return partFourDayVisitors;
	}
	
	

	public int getChapterOneDayVisitors() {
		return chapterOneDayVisitors;
	}

	public int getChapterTwoDayVisitors() {
		return chapterTwoDayVisitors;
	}

	public int getChapterThreeDayVisitors() {
		return chapterThreeDayVisitors;
	}

	public int getChapterFourDayVisitors() {
		return chapterFourDayVisitors;
	}

	public int getChapterFiveDayVisitors() {
		return chapterFiveDayVisitors;
	}

	public int getChapterSixDayVisitors() {
		return chapterSixDayVisitors;
	}

	public int getChapterSevenDayVisitors() {
		return chapterSevenDayVisitors;
	}

	public int getChapterEightDayVisitors() {
		return chapterEightDayVisitors;
	}

	public int getChapterNineDayVisitors() {
		return chapterNineDayVisitors;
	}

	public int getChapterTenDayVisitors() {
		return chapterTenDayVisitors;
	}

	public int getChapterElevenDayVisitors() {
		return chapterElevenDayVisitors;
	}

	public int getChapterTwelveDayVisitors() {
		return chapterTwelveDayVisitors;
	}

	public int getChapterThirteenDayVisitors() {
		return chapterThirteenDayVisitors;
	}

	public int getChapterForteenDayVisitors() {
		return chapterForteenDayVisitors;
	}

	public int getChapterFifteenDayVisitors() {
		return chapterFifteenDayVisitors;
	}

	public int getChapterSixteenDayVisitors() {
		return chapterSixteenDayVisitors;
	}

	public int getChapterSeventeenDayVisitors() {
		return chapterSeventeenDayVisitors;
	}

	public int getChapterEighteenDayVisitors() {
		return chapterEighteenDayVisitors;
	}

	public int getChapterNinteenDayVisitors() {
		return chapterNinteenDayVisitors;
	}

	public int getChapterTwentyDayVisitors() {
		return chapterTwentyDayVisitors;
	}

	public int getChapterTwentyOneDayVisitors() {
		return chapterTwentyOneDayVisitors;
	}

	public int getChapterTwentyTwoDayVisitors() {
		return chapterTwentyTwoDayVisitors;
	}

	public int getChapterTwentyThreeDayVisitors() {
		return chapterTwentyThreeDayVisitors;
	}

	public int getChapterTwentyFourDayVisitors() {
		return chapterTwentyFourDayVisitors;
	}

	public int getChapterTwentyFiveDayVisitors() {
		return chapterTwentyFiveDayVisitors;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public int getDayVisitorNumber() {
		return dayVisitorNumber;
	}
	
	public void increaseDayVisitorNumber() {
		dayVisitorNumber++;
	}
	
	@Override
	public boolean equals(Object o) {
		VisitationInfo newInfo = (VisitationInfo)o;
		
		return newInfo.getCalendar().equals(calendar) &&
		newInfo.getDayVisitorNumber()==dayVisitorNumber;
	}
	
	
	
}
