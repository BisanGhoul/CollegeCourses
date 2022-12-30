package com.Bisan.CollegeCourses.layers.service;

import com.Bisan.CollegeCourses.layers.convert.CourseConvertor;
import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.dto.CourseDto;
import com.Bisan.CollegeCourses.layers.exceptions.DataNotFoundException;
import com.Bisan.CollegeCourses.layers.exceptions.SemanticException;
import com.Bisan.CollegeCourses.layers.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

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

    public CourseDto getCourse(Long id) {


        Course course = courseRepository.getCourse(id);
        if(course==null){
            throw new DataNotFoundException("Book with id " + id + " is not found");
        }else {
           return  courseConvertor.fromDomain(course);
        }

    }

    public List<CourseDto> getBooks(Long id) {
        List<Course> courses = new ArrayList<>();
        return  courses
                .stream()
               .map(course -> courseConvertor.fromDomain(course))
                .toList();
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
        checkCourseExistance(id);
        validate(courseDto);
        Course course = courseConvertor.fromDto(courseDto);
        Course createdCourse = courseRepository.createCourse(course);
        CourseDto createdCourseDto = courseConvertor.fromDomain(createdCourse);
        return createdCourseDto;

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
        if(courseDto.getLevel()>6){
            throw new SemanticException("Level should be less than 6 and more than 0!");

        }else{
            System.out.println(courseDto.getAverage()>100.0);
        }
        if(courseDto.getAverage()>100.0 && courseDto.getAverage()<0.0){
            throw new SemanticException("Average Should Be Between 0 and 100!");
        }
        if(courseDto.getPrefix().length() > 4){
            throw new SemanticException("Prefix Should Be 4 Characters!");
        }

    }
}
