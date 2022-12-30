package com.Bisan.CollegeCourses.layers.web;


import com.Bisan.CollegeCourses.layers.dto.CourseDto;
import com.Bisan.CollegeCourses.layers.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// Controller is a class that service as "API" that our service expose
@RestController
@RequestMapping("/courses") // all mapping methods will have a "books" as a parent path
public class CourseController {

    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public CourseDto getCourse(@PathVariable Long id){
      return  courseService.getCourse(id);
    }

    // POST http://localhost:8080/books/
    @RequestMapping(method = RequestMethod.POST) // POST method is ALWAYS for save new resource
    @ResponseStatus(HttpStatus.CREATED) //status -> 201
    public CourseDto createBook(@RequestBody CourseDto courseDto) { // Spring will convert HTTP body to the instance of
        // @RequestBody argument
        return courseService.createCourse(courseDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CourseDto updateBook(@PathVariable Long id,
                              @RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseDto, id);
    }
}
