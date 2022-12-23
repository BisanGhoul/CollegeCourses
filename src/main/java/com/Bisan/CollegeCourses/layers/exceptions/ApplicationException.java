package com.Bisan.CollegeCourses.layers.exceptions;

//// All your custom exception MUST be extended from RuntimeException (based on best practice)
// RunTimeException can be thrown but Exception can not be thrown
public class ApplicationException extends RuntimeException{

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }
}
