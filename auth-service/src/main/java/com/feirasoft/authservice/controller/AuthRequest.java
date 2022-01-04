package com.feirasoft.authservice.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
}
