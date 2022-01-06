package com.feirasoft.postservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CommentDto {
    String id;
    String comment;
    String postId;
    int userId;
}
