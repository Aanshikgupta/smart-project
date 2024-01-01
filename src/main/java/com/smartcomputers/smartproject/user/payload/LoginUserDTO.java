package com.smartcomputers.smartproject.user.payload;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String email;
    private String password;
}