package com.Bisan.CollegeCourses.appevent;

import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.repository.CourseRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.time.Instant;

//@Component
public class ApplicationReady {

    CourseRepository courseRepository;

    public ApplicationReady(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //will run onc when project is ready
    @EventListener(ApplicationReadyEvent.class)
    public void doSmthAfterStartUP(){
        Course course =courseRepository.getCourse(1L);
       // System.out.println(course.toString());

        Course courseToBeCreated = new Course("javaFX","COMP",3,2,10,70.5,false,Instant.now());
        //c1.createCode();
        //System.out.println(c1.toString());
        //Course createdCourse = courseRepository.createCourse(courseToBeCreated);
        //System.out.println(createdCourse.toString());


//        Course updatedCourse = courseRepository.updateCourse(courseToBeCreated,1L);
//        System.out.println(updatedCourse.toString());

        courseRepository.deleteCourse(3L);
        courseRepository.deleteCourse(4L);

    }


}
