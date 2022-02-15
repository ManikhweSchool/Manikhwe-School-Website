package com.manikhweschool.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "BOOK")
@Component
public class Book {

	@Id
    @Column(name = "Book_ISBN", nullable = false)
	private String isbn;
	
	@Column(name = "Book_Cover_Page_Url", nullable = false)
	private String coverPageUrl;
	
	@Column(name = "Book_Title", nullable = false)
	private String title;
	
	@OneToMany
	private Set<Exercise> exercises;
	
	public Book() {
		super();
		coverPageUrl = "";
		title = "";
		isbn = "";
		exercises = new LinkedHashSet<>();
	}

	public String getCoverPageUrl() {
		return coverPageUrl;
	}

	public void setCoverPageUrl(String coverPageUrl) {
		this.coverPageUrl = coverPageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void addExercise(Exercise exercise) {
		exercises.add(exercise);
	}
	
	
	
	
}
