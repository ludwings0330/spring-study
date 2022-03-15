package com.example.springstudy.exceptionstudy;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @ExceptionHandler(value = RuntimeException.class)
    public String myExceptionHandler1(Exception e) {
        System.out.println("e.getMessage() = " + e.getMessage());
        return "RuntimeException";
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public String myExceptionHandler2() {
        return "IllegalStateException";
    }

    @ExceptionHandler(value = {MyCustomException.class, MyCustomException2.class})
    public String myExceptionHandler3(Exception e) {
        System.out.println("e.getMessage = " + e.getMessage());
        return "MyCustomException";
    }

    @GetMapping("/exception/1")
    public String exceptionHandlerTest1() {
        throw new RuntimeException();
    }
    @GetMapping("/exception/2")
    public String exceptionHandlerTest2() {
        throw new IllegalStateException();
    }
    @GetMapping("/exception/3")
    public String exceptionHandlerTest3() {
        throw new MyCustomException("몰?루");
    }
    @GetMapping("/exception/4")
    public String exceptionHandlerTest4() {
        throw new MyCustomException2("MyCustomException 2 error 발생");
    }
}
