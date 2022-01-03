package com.feirasoft.userservice.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private boolean isAdmin;
    private RoleDto role;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
