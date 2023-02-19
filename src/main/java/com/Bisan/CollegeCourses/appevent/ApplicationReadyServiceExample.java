package com.Bisan.CollegeCourses.appevent;

import com.Bisan.CollegeCourses.layers.dto.CourseDto;
import com.Bisan.CollegeCourses.layers.exceptions.ApplicationException;
import com.Bisan.CollegeCourses.layers.service.CourseService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

//@Component
public class ApplicationReadyServiceExample {
    private CourseService courseService;

    public ApplicationReadyServiceExample(CourseService courseService) {
        this.courseService = courseService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
  //      try {
//            CourseDto course = courseService.createCourse(new CourseDto("datastructure","COMP",2,4,2,70.5,false,Instant.now()));
//            System.out.println(course);

//            courseService.deleteCourse(8L);

//        } catch (ApplicationException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            courseService.deleteCourse(7L);
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }

}