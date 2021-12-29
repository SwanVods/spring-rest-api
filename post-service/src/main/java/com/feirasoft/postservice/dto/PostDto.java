package com.feirasoft.postservice.dto;

import com.feirasoft.postservice.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PostDto {
    private String id;
    private String title;
    private String content;
    private int likeCount;
    private Category category;
}
