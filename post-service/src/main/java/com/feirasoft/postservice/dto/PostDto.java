package com.feirasoft.postservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PostDto {
    private String title;
    private String content;
    private int likeCount;
    private Set<CategoryDto> categories;
}
