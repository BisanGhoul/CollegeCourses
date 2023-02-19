package com.Bisan.CollegeCourses.layers.web;

import com.Bisan.CollegeCourses.layers.exceptions.ApplicationException;
import com.Bisan.CollegeCourses.layers.exceptions.DataNotFoundException;
import com.Bisan.CollegeCourses.layers.exceptions.SemanticException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice //for handling rest exceptions
public class GlobalExceptionHandler {


    @ResponseBody //to convert the error message to json
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleDataNotFoundException(DataNotFoundException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(SemanticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleSemanticException(SemanticException exception) {
        return new ErrorMessage(exception.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleGeneralApplicationException(ApplicationException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(Exception exception) {
        //returning the stack trace for the error is bad practice
        return new ErrorMessage(exception.getMessage());
    }


}
