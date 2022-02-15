package com.manikhweschool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "EXERCISE")
@Component
public class Exercise {

	@Id
    @GeneratedValue
    @Column(name = "Exercise_ID", nullable = false)
	private long exerciseID;
	
	@Column(name = "Exercise_Name", nullable = false)
	private String exerciseName;
	
	@Column(name = "Exercise_Price", nullable = false)
	private double exercisePrice;
	
	@Column(name = "Exercise_Availability", nullable = false)
	private boolean isSolvable; // Tells us whether tutors are allowed to solve it.
	
	@ManyToOne
	@Autowired
	private Book book;
	
	public Exercise() {
		super();
		
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public double getExercisePrice() {
		return exercisePrice;
	}

	public void setExercisePrice(double exercisePrice) {
		this.exercisePrice = exercisePrice;
	}

	public boolean isSolvable() {
		return isSolvable;
	}

	public void setSolvable(boolean isSolvable) {
		this.isSolvable = isSolvable;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
