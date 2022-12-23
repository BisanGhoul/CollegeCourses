package com.Bisan.CollegeCourses.layers.dto;

import java.time.Instant;

public class CourseDto {

    private String name;
    private String prefix;
    private int credits;
    private int level;//1st year = level 1, 2nd year = level 2,  etc..
    private int number;
    private double average;
    private boolean updated;
    private String code;
    private Instant releaseDate;

    public CourseDto(String name, String prefix, int credits, int level, int number, double average, boolean updated, Instant releaseDate) {
        this.name = name;
        this.prefix = prefix;
        this.credits = credits;
        this.level = level;
        this.number = number;
        this.average = average;
        this.updated = updated;
        this.releaseDate = releaseDate;
    }

    public CourseDto(String name, String prefix, int credits, int level, int number, double average, boolean updated, String code, Instant releaseDate) {
        this.name = name;
        this.prefix = prefix;
        this.credits = credits;
        this.level = level;
        this.number = number;
        this.average = average;
        this.updated = updated;
        this.code = code;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", credits=" + credits +
                ", level=" + level +
                ", number=" + number +
                ", average=" + average +
                ", updated=" + updated +
                ", code='" + code + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
