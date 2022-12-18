package com.Bisan.CollegeCourses.layers.repository;

import com.Bisan.CollegeCourses.layers.domain.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// ORM - object related mapping
//this class is responsible for communicating between dat storages (DB, text ,etc...)
//spring uses java reflect package
// CRUD operations
@Repository //for compiler - IoC - has component annotation
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println(jdbcTemplate);
        //   System.out.println(getCourse(1L));

        //was called from main w/o actually calling it because of the @Repository annotation
    }

    public Course getCourse(Long id){
        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);

        Course course = jdbcTemplate.queryForObject("SELECT * FROM public.courses where id=?", rowMapper,id);
        System.out.println(course);
        return course;
    }
}
