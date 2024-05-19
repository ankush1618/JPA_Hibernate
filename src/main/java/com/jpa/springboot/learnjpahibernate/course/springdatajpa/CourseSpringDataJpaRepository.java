package com.jpa.springboot.learnjpahibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.springboot.learnjpahibernate.course.Course;

//Taking Course Bean as Entity
//Using Interface we can also have custom methods
public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long>{

	
	//function to search by author-need to take care of naming of parameters
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
