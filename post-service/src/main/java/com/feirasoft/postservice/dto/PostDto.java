package com.feirasoft.postservice.dto;

import com.feirasoft.postservice.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PostDto {
    private String id;
    private String title;
    private String content;
    private int userId;
    private int likeCount;
    private Category category;
    private Collection<CommentDto> comments;
}
