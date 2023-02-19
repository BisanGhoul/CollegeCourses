package com.Bisan.CollegeCourses.layers.domain;

import javax.persistence.*;
import java.time.Instant;


@Entity //tells JPA provider (hibernate) that this is meta info for SQL table
@Table(name="courses", schema = "public") //represents table courses in DB
public class Course {
    @Id
    @GeneratedValue(generator = "courses_id_seq") // we put a name of sequence that what generated when we added a new table
     private Long id; //maps boo id in DB table
    private String name;
    private String prefix;
    private int credits;
    private int level;//1st year = level 1, 2nd year = level 2,  etc..
    private int number;
    private double average;
    private boolean updated;
    private String code;
    private Instant releaseDate;

    //violates SOLID
    @Transient //field not managrd by hibernate
    private String newString;

    public Course(String name, String prefix, int credits, int level, int number, double average, boolean updated,  String code, Instant releaseDate) {
        this.name = name;
        this.prefix = prefix;
        this.credits = credits;
        this.level = level;
        this.number = number;
        this.average = average;
        this.updated = updated;
        this.releaseDate = releaseDate;
        this.code = code;
    }

    public Course(String name, String prefix, int credits, int level, int number, double average, boolean updated, Instant releaseDate) {
        this.name = name;
        this.prefix = prefix;
        this.credits = credits;
        this.level = level;
        this.number = number;
        this.average = average;
        this.updated = updated;
        this.releaseDate = releaseDate;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*
        returns the code for a specific course like this for example:
        prefix: COMP (Technology Faculty)
        level: 2 (2nd year)
        credits: 3 (3 hours per week)
        number: 1 (course number in a specific level)

        code: COMP231 which is code for java course.
         */
    public String createCode(){
        this.code = prefix+level+credits+number;
        return this.code;
    }
    public String createCode(String prefix, int level, int credits, int number){
        this.code = prefix+level+credits+number;
        return this.code;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", credits=" + credits +
                ", level=" + level +
                ", number=" + number +
                ", average=" + average +
                ", updated=" + updated +
                ", releaseDate=" + releaseDate +
                ", code='" + code + '\'' +
                '}';
    }
}
