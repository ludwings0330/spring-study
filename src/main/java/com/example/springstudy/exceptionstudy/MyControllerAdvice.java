package com.example.springstudy.exceptionstudy;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = MyControllerAdviceException.class)
    public String handleControllerAdviceException() {
        return "handleControllerAdviceException";
    }

    @ExceptionHandler(value = MyCustomException.class)
    public String handleMyCustomException(Exception e) {
        System.out.println("e.getMessage() = " + e.getMessage());
        return "myCustomException occurred";
    }
}
