package com.manikhweschool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

@Embeddable
@Component
public class DartVisitationInfo extends VisitationInfo implements HttpSessionBindingListener,
Serializable{

	private static final long serialVersionUID = -3694201522247437996L;
	
	// All 33 below attributes are manipulated by servlet request listeners.
	@Column(name="Dart_C1_Visitors", nullable = false)
	private int chapterOneDayVisitors;
	@Column(name="Dart_C2_Visitors", nullable = false)
	private int chapterTwoDayVisitors;
	@Column(name="Dart_C3_Visitors", nullable = false)
	private int chapterThreeDayVisitors;
	@Column(name="Dart_C4_Visitors", nullable = false)
	private int chapterFourDayVisitors;
	@Column(name="Dart_C5_Visitors", nullable = false)
	private int chapterFiveDayVisitors;
	@Column(name="Dart_C6_Visitors", nullable = false)
	private int chapterSixDayVisitors;
	@Column(name="Dart_C7_Visitors", nullable = false)
	private int chapterSevenDayVisitors;
	@Column(name="Dart_C8_Visitors", nullable = false)
	private int chapterEightDayVisitors;
	@Column(name="Dart_C9_Visitors", nullable = false)
	private int chapterNineDayVisitors;
	@Column(name="Dart_C10_Visitors", nullable = false)
	private int chapterTenDayVisitors;
	@Column(name="Dart_C11_Visitors", nullable = false)
	private int chapterElevenDayVisitors;
	@Column(name="Dart_C12_Visitors", nullable = false)
	private int chapterTwelveDayVisitors;
	@Column(name="Dart_C13_Visitors", nullable = false)
	private int chapterThirteenDayVisitors;
	@Column(name="Dart_C14_Visitors", nullable = false)
	private int chapterForteenDayVisitors;
	@Column(name="Dart_C15_Visitors", nullable = false)
	private int chapterFifteenDayVisitors;
	@Column(name="Dart_C16_Visitors", nullable = false)
	private int chapterSixteenDayVisitors;
	@Column(name="Dart_C17_Visitors", nullable = false)
	private int chapterSeventeenDayVisitors;
	@Column(name="Dart_C18_Visitors", nullable = false) 
	private int chapterEighteenDayVisitors;
	@Column(name="Dart_C19_Visitors", nullable = false)
	private int chapterNinteenDayVisitors;
	@Column(name="Dart_C20_Visitors", nullable = false)
	private int chapterTwentyDayVisitors;
	@Column(name="Dart_C21_Visitors", nullable = false)
	private int chapterTwentyOneDayVisitors;
	@Column(name="Dart_C22_Visitors", nullable = false)
	private int chapterTwentyTwoDayVisitors;
	@Column(name="Dart_C23_Visitors", nullable = false)
	private int chapterTwentyThreeDayVisitors;
	@Column(name="Dart_C24_Visitors", nullable = false)
	private int chapterTwentyFourDayVisitors;
	
	@Column(name="Dart_P1_Visitors", nullable = false)
	private int partOneDayVisitors;
	@Column(name="Dart_P2_Visitors", nullable = false)
	private int partTwoDayVisitors;
	@Column(name="Dart_P3_Visitors", nullable = false)
	private int partThreeDayVisitors;
	
	
	
	public DartVisitationInfo() {
		
		initializeDayVisitors();
	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		// Code to run now that I'm in a session.
		System.out.println("now that I'm in a session");
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		// Code to run now that I'm no longer in a session.
		System.out.println("now that I'm no longer in a session");
	}
	
	
	@Override
	public void initializeDayVisitors() {
		
		partOneDayVisitors = 0;
		partTwoDayVisitors = 0;
		partThreeDayVisitors = 0;
		
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
	public void increaseChapterTwentyTwoDayVisitors() {
		chapterTwentyTwoDayVisitors++;
	}
	public void increaseChapterTwentyThreeDayVisitors() {
		chapterTwentyThreeDayVisitors++;
	}
	public void increaseChapterTwentyFourDayVisitors() {
		chapterTwentyFourDayVisitors++;
	}
	public void increaseChapterTwentyFiveDayVisitors() {
	
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
		return -1;
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
		return -1;
	}
	
	public void increaseChapterTwentySixDayVisitors() {
		
	}
	public void increaseChapterTwentySevenDayVisitors() {
		
	}
	public void increaseChapterTwentyEightDayVisitors() {
		
	}
	public void increaseChapterTwentyNineDayVisitors() {
		
	}
	public void increaseChapterThirtyDayVisitors() {
		
	}
	public void increaseChapterThirtyOneDayVisitors() {
		
	}
	public void increaseChapterThirtyTwoDayVisitors() {
		
	}
	public void increaseChapterThirtyThreeDayVisitors() {
		
	}
}
