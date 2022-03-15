package com.example.springstudy.exceptionstudy;

public class MyCustomException2 extends RuntimeException {
    public MyCustomException2() {
    }

    public MyCustomException2(String message) {
        super(message);
    }

    public MyCustomException2(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCustomException2(Throwable cause) {
        super(cause);
    }

    public MyCustomException2(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
