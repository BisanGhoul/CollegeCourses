package com.Bisan.CollegeCourses.appevent;

import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.repository.CourseIRepo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JpaReadyListener {

    private final CourseIRepo courseIRepo;

    public JpaReadyListener(CourseIRepo courseIRepo) {
        this.courseIRepo = courseIRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void doJpaWork(){

        Course course = courseIRepo.findById(9L).get();
//        courseIRepo.save(); //wworks as insert and update
//        courseIRepo.deleteAllById();
        List<Course> courses = courseIRepo.findAllWithTitleThatContains("course");
        System.out.println(Arrays.toString(courses.toArray()));
    }

}
