package com.example.springstudy.exceptionstudy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MyErrorCode {
    LOGIN_ERROR(100, "로그인 에러"),
    LOGOUT_ERROR(101, "로그아웃 에러");

    private final int code;
    private final String description;
}
