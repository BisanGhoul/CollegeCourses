package com.Bisan.CollegeCourses;

import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.awt.print.Book;

@SpringBootApplication
public class CollegeCoursesApplication {

	public static void main(String[] args) {
//		DataSource source =  new SimpleDriverDataSource();
//		JdbcTemplate template = new JdbcTemplate(source);
//		CourseRepository repo = new CourseRepository(template);
//		Course book = repo.getCourse(1L);
		SpringApplication.run(CollegeCoursesApplication.class, args);
	}

}
