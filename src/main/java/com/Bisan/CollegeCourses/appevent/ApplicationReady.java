package com.Bisan.CollegeCourses.appevent;

import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.repository.CourseRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class ApplicationReady {

    CourseRepository courseRepository;

    public ApplicationReady(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //will run onc when project is ready
    @EventListener(ApplicationReadyEvent.class)
    public void doSmthAfterStartUP(){
        Course course =courseRepository.getCourse(1L);
        System.out.println(course.toString());
    }
}
