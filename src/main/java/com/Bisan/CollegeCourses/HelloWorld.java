package com.Bisan.CollegeCourses;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello/")
public class HelloWorld {
    @GetMapping
    public String getStringHello() {
        return "Hello world!";
    }
}
