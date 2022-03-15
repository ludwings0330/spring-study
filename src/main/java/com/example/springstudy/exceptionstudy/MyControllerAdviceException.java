package com.example.springstudy.exceptionstudy;

public class MyControllerAdviceException extends RuntimeException {
    public MyControllerAdviceException() {
    }

    public MyControllerAdviceException(String message) {
        super(message);
    }

    public MyControllerAdviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyControllerAdviceException(Throwable cause) {
        super(cause);
    }

    public MyControllerAdviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
