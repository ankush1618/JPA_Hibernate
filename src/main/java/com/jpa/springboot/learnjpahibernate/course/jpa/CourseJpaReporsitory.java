package com.jpa.springboot.learnjpahibernate.course.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.springboot.learnjpahibernate.course.Course;

@Repository
@Transactional
public class CourseJpaReporsitory {

	
	//use EntityManger to mange the entity
	//@Autowired
	@PersistenceContext
	EntityManager entityManager;
	
	private static String INSERT_QUERY = "insert into COURSE (id,name,author) " + "values(?,?,?)";

	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		 Course couse=entityManager.find(Course.class, id);
		 entityManager.remove(couse);
	}
}
