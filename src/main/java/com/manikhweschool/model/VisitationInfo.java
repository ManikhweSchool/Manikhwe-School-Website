package com.manikhweschool.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

@Component
public abstract class VisitationInfo implements HttpSessionBindingListener,
Serializable{

	
	private static final long serialVersionUID = -1992466193675255606L;

	
	
	protected VisitationInfo() {
		initializeDayVisitors();
	}
	
	public abstract void initializeDayVisitors();
	
	public abstract void increaseChapterOneDayVisitors();
	public abstract void increaseChapterTwoDayVisitors();
	public abstract void increaseChapterThreeDayVisitors();
	public abstract void increaseChapterFourDayVisitors();
	public abstract void increaseChapterFiveDayVisitors();
	public abstract void increaseChapterSixDayVisitors();
	public abstract void increaseChapterSevenDayVisitors();
	public abstract void increaseChapterEightDayVisitors();
	public abstract void increaseChapterNineDayVisitors();
	public abstract void increaseChapterTenDayVisitors();
	public abstract void increaseChapterElevenDayVisitors();
	public abstract void increaseChapterTwelveDayVisitors();
	public abstract void increaseChapterThirteenDayVisitors();
	public abstract void increaseChapterForteenDayVisitors();
	public abstract void increaseChapterFifteenDayVisitors();
	public abstract void increaseChapterSixteenDayVisitors();
	public abstract void increaseChapterSeventeenDayVisitors();
	public abstract void increaseChapterEighteenDayVisitors();
	public abstract void increaseChapterNinteenDayVisitors() ;
	public abstract void increaseChapterTwentyDayVisitors();
	public abstract void increaseChapterTwentyOneDayVisitors();
	public abstract void increaseChapterTwentyTwoDayVisitors();
	public abstract void increaseChapterTwentyThreeDayVisitors();
	public abstract void increaseChapterTwentyFourDayVisitors();
	public abstract void increaseChapterTwentyFiveDayVisitors();
	
	public abstract void increasePartOneDayVisitors();
	public abstract void increasePartTwoDayVisitors();
	public abstract void increasePartThreeDayVisitors();
	public abstract void increasePartFourDayVisitors();
	
	public abstract int getPartOneDayVisitors();
	public abstract int getPartTwoDayVisitors();
	public abstract int getPartThreeDayVisitors();
	public abstract int getPartFourDayVisitors();
	
	

	public abstract int getChapterOneDayVisitors();

	public abstract int getChapterTwoDayVisitors();

	public abstract int getChapterThreeDayVisitors();

	public abstract int getChapterFourDayVisitors();

	public abstract int getChapterFiveDayVisitors();

	public abstract int getChapterSixDayVisitors();

	public abstract int getChapterSevenDayVisitors();

	public abstract int getChapterEightDayVisitors();

	public abstract int getChapterNineDayVisitors();

	public abstract int getChapterTenDayVisitors();

	public abstract int getChapterElevenDayVisitors();

	public abstract int getChapterTwelveDayVisitors();

	public abstract int getChapterThirteenDayVisitors();

	public abstract int getChapterForteenDayVisitors();

	public abstract int getChapterFifteenDayVisitors();

	public abstract int getChapterSixteenDayVisitors();

	public abstract int getChapterSeventeenDayVisitors();

	public abstract int getChapterEighteenDayVisitors();

	public abstract int getChapterNinteenDayVisitors();

	public abstract int getChapterTwentyDayVisitors();

	public abstract int getChapterTwentyOneDayVisitors();

	public abstract int getChapterTwentyTwoDayVisitors();

	public abstract int getChapterTwentyThreeDayVisitors();

	public abstract int getChapterTwentyFourDayVisitors();

	public abstract int getChapterTwentyFiveDayVisitors();
	
	
	
}
