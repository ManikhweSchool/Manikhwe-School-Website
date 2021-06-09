package com.manikhweschool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "JAVA_VISITATION_INFO")
@Component
public class JavaVisitationInfo extends VisitationInfo 
{

	private static final long serialVersionUID = -3694201522247437996L;
	
	// All 33 below attributes are manipulated by servlet request listeners.
	
	@Column(name="Chapter26_Visitors", nullable = false)
	private int chapterTwentySixDayVisitors;
	@Column(name="Chapter27_Visitors", nullable = false)
	private int chapterTwentySevenDayVisitors;
	@Column(name="Chapter28_Visitors", nullable = false)
	private int chapterTwentyEightDayVisitors;
	@Column(name="Chapter29_Visitors", nullable = false)
	private int chapterTwentyNineDayVisitors;
	@Column(name="Chapter30_Visitors", nullable = false)
	private int chapterThirtyDayVisitors;
	@Column(name="Chapter31_Visitors", nullable = false)
	private int chapterThirtyOneDayVisitors;
	@Column(name="Chapter32_Visitors", nullable = false)
	private int chapterThirtyTwoDayVisitors;
	@Column(name="Chapter33_Visitors", nullable = false)
	private int chapterThirtyThreeDayVisitors;
	
	public JavaVisitationInfo() {
		
		initializeDayVisitors();
	}
	
	
	@Override
	public void initializeDayVisitors() {
		
		super.initializeDayVisitors();
		chapterTwentySixDayVisitors = 0;
		chapterTwentySevenDayVisitors = 0;
		chapterTwentyEightDayVisitors = 0;
		chapterTwentyNineDayVisitors = 0;
		chapterThirtyDayVisitors = 0;
		chapterThirtyOneDayVisitors = 0;
		chapterThirtyTwoDayVisitors = 0;
		chapterThirtyThreeDayVisitors = 0;
	}
	
	
	public void increaseChapterTwentySixDayVisitors() {
		chapterTwentySixDayVisitors++;
	}
	public void increaseChapterTwentySevenDayVisitors() {
		chapterTwentySevenDayVisitors++;
	}
	public void increaseChapterTwentyEightDayVisitors() {
		chapterTwentyEightDayVisitors++;
	}
	public void increaseChapterTwentyNineDayVisitors() {
		chapterTwentyNineDayVisitors++;
	}
	public void increaseChapterThirtyDayVisitors() {
		chapterThirtyDayVisitors++;
	}
	public void increaseChapterThirtyOneDayVisitors() {
		chapterThirtyOneDayVisitors++;
	}
	public void increaseChapterThirtyTwoDayVisitors() {
		chapterThirtyTwoDayVisitors++;
	}
	public void increaseChapterThirtyThreeDayVisitors() {
		chapterThirtyThreeDayVisitors++;
	}
}
