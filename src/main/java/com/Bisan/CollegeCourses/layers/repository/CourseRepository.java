package com.Bisan.CollegeCourses.layers.repository;

import com.Bisan.CollegeCourses.layers.domain.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
// ORM - object related mapping
//this class is responsible for communicating between dat storages (DB, text ,etc...)
//spring uses java reflect package
// CRUD operations
@Repository //for compiler - IoC - has component annotation
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;
    //        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);

    private RowMapper<Course> courseRowMapper; // spring will find its bean in the AppConfig class
    public CourseRepository(JdbcTemplate jdbcTemplate, RowMapper<Course> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.courseRowMapper = rowMapper;
        //error ^: Consider defining a bean of type 'org.springframework.jdbc.core.RowMapper' in your configuration.
        //solution:


       // System.out.println(jdbcTemplate);
        //   System.out.println(getCourse(1L));

        //was called from main w/o actually calling it because of the @Repository annotation
    }

    // If data is not found in repository we return null or return Optinal<> type ( java 8 feature)
    public Course getCourse(Long id){
        //remove rowMapper and make it a global variable that will be instaniated by spring
//        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);

        try {
            Course course = jdbcTemplate.queryForObject("SELECT * FROM public.courses where id=?", courseRowMapper,id);
            return course;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public Course createCourse(Course course) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
                                @Override
                                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                    PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO public.courses(\n" +
                                                    "\tname, prefix, credits, level, \"number\", average, updated, code, \"releaseDate\")\n" +
                                                    "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                                            new String[]{"id"});
                                    preparedStatement.setString(1,course.getName() );
                                    preparedStatement.setString(2, course.getPrefix());
                                    preparedStatement.setInt(3, course.getCredits());
                                    preparedStatement.setInt(4, course.getLevel());
                                    preparedStatement.setInt(5, course.getNumber());
                                    preparedStatement.setDouble(6, course.getAverage());
                                    preparedStatement.setBoolean(7, course.isUpdated());
                                    course.createCode();
                                    preparedStatement.setString(8, course.getCode());
                                    preparedStatement.setTimestamp(9, Timestamp.from(course.getReleaseDate())); // static method from



                                    return preparedStatement;
                                }
                            },
                keyHolder);

        long generatedKey = keyHolder.getKey().longValue();

        return getCourse(generatedKey);
    }

    public Course updateCourse(Course course, Long id) {
        jdbcTemplate.update(new PreparedStatementCreator() {
                                @Override
                                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                    PreparedStatement preparedStatement = con.prepareStatement("UPDATE public.courses\n" +
                                                    "\tSET name=?, prefix=?, credits=?, level=?, \"number\"=?, average=?, updated=?, code=?, \"releaseDate\"=?" +
                                                    "\tWHERE id=?");
                                    preparedStatement.setString(1,course.getName() );
                                    preparedStatement.setString(2, course.getPrefix());
                                    preparedStatement.setInt(3, course.getCredits());
                                    preparedStatement.setInt(4, course.getLevel());
                                    preparedStatement.setInt(5, course.getNumber());
                                    preparedStatement.setDouble(6, course.getAverage());
                                    preparedStatement.setBoolean(7, course.isUpdated());
                                    course.createCode();
                                    preparedStatement.setString(8, course.getCode());
                                    preparedStatement.setTimestamp(9, Timestamp.from(course.getReleaseDate())); // static method from
                                    preparedStatement.setLong(10, id);



                                    return preparedStatement;
                                }
                            });


        return getCourse(id);
    }

    public void deleteCourse(Long id) {
        jdbcTemplate.update("delete from courses where id = ?", id);
    }

}
