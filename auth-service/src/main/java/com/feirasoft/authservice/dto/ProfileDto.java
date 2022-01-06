package com.feirasoft.authservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProfileDto {
    private String firstName;
    private String lastName;
    private Date dob;
    private String bio;
    private String image;
}
