package com.Bisan.CollegeCourses.layers.config;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateProvider {

    public static JdbcTemplate getJDBCTemplate(){

        return new JdbcTemplate();
    }
}
