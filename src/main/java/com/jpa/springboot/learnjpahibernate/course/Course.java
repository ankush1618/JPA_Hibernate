package com.jpa.springboot.learnjpahibernate.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Bean	
//Entity to map Table to Course bean
@Entity
public class Course {

	@Id //defining as primary
	private long id;
	
	//mapping course table entity with SQL table
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	
	public Course() {
		
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
	
}
