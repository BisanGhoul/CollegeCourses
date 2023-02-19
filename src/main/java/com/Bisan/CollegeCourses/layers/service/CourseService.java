package com.Bisan.CollegeCourses.layers.service;

import com.Bisan.CollegeCourses.layers.convert.CourseConvertor;
import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.dto.CourseDto;
import com.Bisan.CollegeCourses.layers.exceptions.DataNotFoundException;
import com.Bisan.CollegeCourses.layers.exceptions.SemanticException;
import com.Bisan.CollegeCourses.layers.repository.CourseIRepo;
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

//    CourseRepository courseRepository;
    CourseIRepo courseIRepo;
    CourseConvertor courseConvertor;

    public CourseService(
//            CourseRepository courseRepository,
            CourseIRepo courseIRepo,
            CourseConvertor courseConvertor) {
//        this.courseRepository = courseRepository;
        this.courseIRepo=courseIRepo;
        this.courseConvertor = courseConvertor;
    }

    public CourseDto getCourse(Long id) {
//todo: optional stuff and java8 features

//        Course course = courseRepository.getCourse(id);
//        if(course==null){
//            throw new DataNotFoundException("Book with id " + id + " is not found");
//        }else {
//           return  courseConvertor.fromDomain(course);
//        }

        return courseIRepo.findById(id)
                .map(b -> courseConvertor.fromDomain(b))
                .orElseThrow(() -> new DataNotFoundException("Book with id " + id + " is not found"));
    }

//    public List<CourseDto> getBooks(Long id) {
//        List<Course> courses = new ArrayList<>();
//        return  courses
//                .stream()
//               .map(course -> courseConvertor.fromDomain(Optional.ofNullable(course)))
//                .toList();
//    }

    public CourseDto createCourse(CourseDto courseDto){
        validate(courseDto);
        Course course = courseConvertor.fromDto(courseDto);
        //when the entity comes with @Id as null, save will be treated as create
        Course createdCourse = courseIRepo.save(course);
        CourseDto createdCourseDto = courseConvertor.fromDomain(createdCourse);
        return createdCourseDto;
    }

    public void deleteCourse(Long id){
        checkCourseExistance(id);
        courseIRepo.deleteById(id);

    }

    public CourseDto updateCourse(CourseDto courseDto, Long id){
        //TODO updateCourse method (CourseService Class)
        checkCourseExistance(id);
        validate(courseDto);
//        Course course = courseConvertor.fromDto(courseDto);
//        Course createdCourse = courseIRepo.save(course);
//        CourseDto createdCourseDto = courseConvertor.fromDomain(Optional.of(createdCourse));

        //when the entity comes with @Id not null, save will be treated as create
        courseIRepo.findById(id)
                .map(course->{
                    Course foundCourse = courseConvertor.fromDto(courseDto);
                    foundCourse.setId(course.getId());
                    return courseIRepo.save(foundCourse);

                }).map(savedCourse->courseConvertor.fromDomain(savedCourse))
                .orElseThrow(()->new RuntimeException());
//        return courseIRepo.save(courseConvertor.fromDto(courseDto),id)
//                .map(b -> courseConvertor.fromDomain(b))
//                .get();
//
//        return createdCourseDto;
        return null;

    }


    public List<CourseDto> getCourseWithTitleThatContains(String word) {
        return courseIRepo.findAllWithTitleThatContains(word)
                .stream()
                .map(course -> courseConvertor.fromDomain(course))
                .toList();
    }

    public List<CourseDto> getAllCourses() {
        return courseIRepo.findAll()
                .stream()
                .map(course -> courseConvertor.fromDomain(course))
                .toList();
    }

    private void checkCourseExistance(Long id) {
        Optional<Course> course = courseIRepo.findById(id);

        courseIRepo
                .findById(id)
                .map(b -> {
                    System.out.println("checkExisting is called with id " + id);
                    return b;
                })
                .orElseThrow(() -> new DataNotFoundException("Course with this id doesn exist!"));

//        if(course != null){
//            System.out.println("deleted successfully");
//        }else{
//            throw new DataNotFoundException("book with this ID does not exist!");
//        }
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
