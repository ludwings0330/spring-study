package com.example.springstudy.login;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginReqDto {
    private String id;
    private String password;
}
