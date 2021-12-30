package com.feirasoft.postservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CommentDto {
    UserDto userDto;
    String comment;
}
