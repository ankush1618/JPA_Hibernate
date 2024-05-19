package com.jpa.springboot.learnjpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.springboot.learnjpahibernate.course.Course;
import com.jpa.springboot.learnjpahibernate.course.jpa.CourseJpaReporsitory;
import com.jpa.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import com.jpa.springboot.learnjpahibernate.coursejdbc.CourseJdbcRepository;

//to make it run at startup we implement CommandLineRunner
//(to execute some logic at the start of the spring boot application)

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaReporsitory repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	public void run(String... args) throws Exception {
		//here on startup we need to fire up few SQL queries for jdbc and JPA
//		repository.insert(new Course(1,"Learn AWS JPA","Gora Rang1"));
//		repository.insert(new Course(2,"Learn microservices JPA","pal Saab"));
//		repository.insert(new Course(3,"Learn Azure JPA","Gora Rang"));
//		repository.insert(new Course(4,"Learn React JPA","Gora Rang2"));
		
		//changing insert() to save() for springdatajpa
		repository.save(new Course(1,"Learn AWS JPA","Gora Rang1"));
		repository.save(new Course(2,"Learn microservices JPA","pal Saab"));
		repository.save(new Course(3,"Learn Azure JPA","Komal"));
		repository.save(new Course(4,"Learn React JPA","Gora Rang2"));
		repository.save(new Course(5,"Learn Java","pal Saab"));
		
		
//		repository.deleteById(1);
//		repository.deleteById(4);
		
		//passing long l for integers while working with spring data JPA
		repository.deleteById(1l);
		repository.deleteById(4l);
		
		//passing long l for integers while working with spring data JPA
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("pal Saab"));
		System.out.println(repository.findByAuthor(""));
		System.out.println(repository.findByName("Learn Java"));
	}

}
