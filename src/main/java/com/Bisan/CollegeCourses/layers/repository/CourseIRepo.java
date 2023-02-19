package com.Bisan.CollegeCourses.layers.repository;

import com.Bisan.CollegeCourses.layers.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //mark it as a bean
//spring creates dynamic implementation of this class
public interface CourseIRepo extends JpaRepository<Course,Long> {
    @Query(value = "SELECT * FROM public.courses WHERE name Ilike %:name% ", nativeQuery = true) // use Native SQL Query
    List<Course> findAllWithTitleThatContains(@Param("name") String name);
}
