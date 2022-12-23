package com.Bisan.CollegeCourses.layers.service;

import com.Bisan.CollegeCourses.layers.convert.CourseConvertor;
import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.dto.CourseDto;
import com.Bisan.CollegeCourses.layers.exceptions.DataNotFoundException;
import com.Bisan.CollegeCourses.layers.exceptions.SemanticException;
import com.Bisan.CollegeCourses.layers.repository.CourseRepository;
import org.springframework.stereotype.Service;

// This class is use for logic ...
// Example: make validation
@Service  // It is just marker. it works the same as @Component
public class CourseService {

    CourseRepository courseRepository;
    CourseConvertor courseConvertor;

    public CourseService(CourseRepository courseRepository, CourseConvertor courseConvertor) {
        this.courseRepository = courseRepository;
        this.courseConvertor = courseConvertor;
    }


    public CourseDto createCourse(CourseDto courseDto){
        validate(courseDto);
        Course course = courseConvertor.fromDto(courseDto);
        Course createdCourse = courseRepository.createCourse(course);
        CourseDto createdCourseDto = courseConvertor.fromDomain(createdCourse);
        return createdCourseDto;
    }

    public void deleteCourse(Long id){
        checkCourseExistance(id);
        courseRepository.deleteCourse(id);

    }

    public CourseDto updateCourse(CourseDto courseDto, Long id){
        //TODO updateCourse method (CourseService Class)
        return null;
    }

    private void checkCourseExistance(Long id) {
        Course course = courseRepository.getCourse(id);

        if(course != null){
            System.out.println("deleted successfully");
        }else{
            throw new DataNotFoundException("book with this ID does not exist!");
        }
    }

    private void validate(CourseDto courseDto){
        //TODO: more validation for added courses
        if(courseDto.getPrefix().length() < 4){
            throw new SemanticException("Prefix Should Be 4 Characters!");
        }
    }
}
