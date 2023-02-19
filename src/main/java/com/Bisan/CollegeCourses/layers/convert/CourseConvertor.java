package com.Bisan.CollegeCourses.layers.convert;

import com.Bisan.CollegeCourses.layers.domain.Course;
import com.Bisan.CollegeCourses.layers.dto.CourseDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //this or define it as a Bean in AppConfig
public class CourseConvertor {
    public CourseDto fromDomain(Course course) {
        CourseDto courseDto = new CourseDto(course.getName(),course.getPrefix(),course.getCredits(),course.getLevel(),course.getNumber(), course.getAverage(),course.isUpdated(), course.getCode(),course.getReleaseDate());
        return courseDto;
    }

    public Course fromDto(CourseDto courseDto) {
        Course course = new Course(courseDto.getName(),courseDto.getPrefix(),courseDto.getCredits(),courseDto.getLevel(),courseDto.getNumber(), courseDto.getAverage(),courseDto.isUpdated(), courseDto.getCode(),courseDto.getReleaseDate());

        return course;
    }
}
