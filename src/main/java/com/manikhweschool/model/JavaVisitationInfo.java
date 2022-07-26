package com.manikhweschool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

@Embeddable
@Component
public class JavaVisitationInfo extends VisitationInfo implements HttpSessionBindingListener,
Serializable{

	private static final long serialVersionUID = -3694201522247437996L;
	
	// All 33 below attributes are manipulated by servlet request listeners.
	@Column(name="Java_C1_Visitors", nullable = false)
	private int chapterOneDayVisitors;
	@Column(name="Java_C2_Visitors", nullable = false)
	private int chapterTwoDayVisitors;
	@Column(name="Java_C3_Visitors", nullable = false)
	private int chapterThreeDayVisitors;
	@Column(name="Java_C4_Visitors", nullable = false)
	private int chapterFourDayVisitors;
	@Column(name="Java_C5_Visitors", nullable = false)
	private int chapterFiveDayVisitors;
	@Column(name="Java_C6_Visitors", nullable = false)
	private int chapterSixDayVisitors;
	@Column(name="Java_C7_Visitors", nullable = false)
	private int chapterSevenDayVisitors;
	@Column(name="Java_C8_Visitors", nullable = false)
	private int chapterEightDayVisitors;
	@Column(name="Java_C9_Visitors", nullable = false)
	private int chapterNineDayVisitors;
	@Column(name="Java_C10_Visitors", nullable = false)
	private int chapterTenDayVisitors;
	@Column(name="Java_C11_Visitors", nullable = false)
	private int chapterElevenDayVisitors;
	@Column(name="Java_C12_Visitors", nullable = false)
	private int chapterTwelveDayVisitors;
	@Column(name="Java_C13_Visitors", nullable = false)
	private int chapterThirteenDayVisitors;
	@Column(name="Java_C17_Visitors", nullable = false)
	private int chapterSeventeenDayVisitors;
	@Column(name="Java_C18_Visitors", nullable = false) 
	private int chapterEighteenDayVisitors;
	@Column(name="Java_C19_Visitors", nullable = false)
	private int chapterNinteenDayVisitors;
	@Column(name="Java_C20_Visitors", nullable = false)
	private int chapterTwentyDayVisitors;
	@Column(name="Java_C21_Visitors", nullable = false)
	private int chapterTwentyOneDayVisitors;
	@Column(name="Java_C22_Visitors", nullable = false)
	private int chapterTwentyTwoDayVisitors;
	@Column(name="Java_C23_Visitors", nullable = false)
	private int chapterTwentyThreeDayVisitors;
	@Column(name="Java_C24_Visitors", nullable = false)
	private int chapterTwentyFourDayVisitors;
	@Column(name="Java_C25_Visitors", nullable = false)
	private int chapterTwentyFiveDayVisitors;
	
	@Column(name="Java_P1_Visitors", nullable = false)
	private int partOneDayVisitors;
	@Column(name="Java_P2_Visitors", nullable = false)
	private int partTwoDayVisitors;
	@Column(name="Java_P3_Visitors", nullable = false)
	private int partThreeDayVisitors;
	@Column(name="Java_P4_Visitors", nullable = false)
	private int partFourDayVisitors;
	
	@Column(name="Java_C26_Visitors", nullable = false)
	private int chapterTwentySixDayVisitors;
	@Column(name="Java_C27_Visitors", nullable = false)
	private int chapterTwentySevenDayVisitors;
	@Column(name="Java_C28_Visitors", nullable = false)
	private int chapterTwentyEightDayVisitors;
	@Column(name="Java_C29_Visitors", nullable = false)
	private int chapterTwentyNineDayVisitors;
	@Column(name="Java_C30_Visitors", nullable = false)
	private int chapterThirtyDayVisitors;
	@Column(name="Java_C31_Visitors", nullable = false)
	private int chapterThirtyOneDayVisitors;
	@Column(name="Java_C32_Visitors", nullable = false)
	private int chapterThirtyTwoDayVisitors;
	
	public JavaVisitationInfo() {
		
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

		chapterSeventeenDayVisitors = 0;
		chapterEighteenDayVisitors = 0;
		chapterNinteenDayVisitors = 0;
		chapterTwentyDayVisitors = 0;
		chapterTwentyOneDayVisitors = 0;
		chapterTwentyTwoDayVisitors = 0;
		chapterTwentyThreeDayVisitors = 0;
		chapterTwentyFourDayVisitors = 0;
		chapterTwentyFiveDayVisitors = 0;
		chapterTwentySixDayVisitors = 0;
		chapterTwentySevenDayVisitors = 0;
		chapterTwentyEightDayVisitors = 0;
		chapterTwentyNineDayVisitors = 0;
		chapterThirtyDayVisitors = 0;
		chapterThirtyOneDayVisitors = 0;
		chapterThirtyTwoDayVisitors = 0;

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

	@Override
	public void increaseChapterForteenDayVisitors() {
		
		
	}

	@Override
	public void increaseChapterFifteenDayVisitors() {
		
		
	}

	@Override
	public void increaseChapterSixteenDayVisitors() {
		
		
	}

	@Override
	public int getChapterForteenDayVisitors() {
		
		return -1;
	}

	@Override
	public int getChapterFifteenDayVisitors() {
		
		return -1;
	}

	@Override
	public int getChapterSixteenDayVisitors() {
		
		return -1;
	}
	
}
