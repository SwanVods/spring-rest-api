package com.feirasoft.userservice.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    private String token;
}
