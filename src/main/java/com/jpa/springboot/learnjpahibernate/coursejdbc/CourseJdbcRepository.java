package com.jpa.springboot.learnjpahibernate.coursejdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpa.springboot.learnjpahibernate.course.Course;

//for talking to a database

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springjdbcTemplate;

//	private static String INSERT_QUERY=
//			"insert into COURSE (id,name,author) "
//			+ "values(2,'Komal','pal')"; 
//	
//	public void insert() {
//		//update method will allow you to add, update and delete the data from database
//		springjdbcTemplate.update(INSERT_QUERY);
//	}

	private static String INSERT_QUERY = "insert into COURSE (id,name,author) " + "values(?,?,?)";

	private static String DELETE_QUERY = "delete from COURSE where id = ?";

	private static String SELECT_QUERY = "select * from COURSE where id = ?";

	// using Course bean
	public void insert(Course cource) {
		// update method will allow you to add, update and delete the data from database
		springjdbcTemplate.update(INSERT_QUERY, cource.getId(), cource.getName(), cource.getAuthor());
	}

	public void deleteById(long id) {
		// update method will allow you to add, update and delete the data from database
		springjdbcTemplate.update(DELETE_QUERY, id);

	}

	public Course findById(long id) {
		// update method will allow you to add, update and delete the data from database
		// for select query we have to do Resultset --Bean mapping-called Row
		// Mapper-(second parameter)
		// new BeanPropertyRowMapper<>(Course.class)
		// each row in a resultset to a specific bean.
		// column name in table maps exact names in the bean
		return springjdbcTemplate.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Course.class), id);

	}

}
