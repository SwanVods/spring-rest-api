package com.feirasoft.authservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthDto {
    private String username;
    private String password;
    private String email;
}
