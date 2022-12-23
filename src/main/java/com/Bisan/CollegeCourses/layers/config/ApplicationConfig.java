package com.Bisan.CollegeCourses.layers.config;

import com.Bisan.CollegeCourses.layers.convert.CourseConvertor;
import com.Bisan.CollegeCourses.layers.domain.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

// this class is going to be class that store META information
// which is going to be used by spring HOW to crete new instances that can injected in the class
// You treat this class as "instructions" how instances can be created
@Configuration
public class ApplicationConfig {

    @Bean
//    @Primary // it marks a bean as a "defaults"
    public String stringTwo() {
        return "Another String";
    }


    @Bean
    // bean is myVeryCoolString based on method name
    public String myVeryCoolString() {
        return "Hello from Config !!!!";
    }

    @Bean("stringbean") // now bean name is "stringbean"
    public String thirdString() {
        return "Third !!!!";
    }

    @Bean
    @Primary
    public RowMapper<Course> courseRowMapper() {
        return new BeanPropertyRowMapper<>(Course.class); // It is a simple implementation of row mapper
    }
//    this way r use @Component on the class
//    @Bean
//    public CourseConvertor courseConvertor(){
//        return new CourseConvertor();
//    }
    @Bean
    public RowMapper<Course> bookRowMapper2() {
        return new BeanPropertyRowMapper<>(Course.class); // It is a simple implementation of row mapper
    }

}