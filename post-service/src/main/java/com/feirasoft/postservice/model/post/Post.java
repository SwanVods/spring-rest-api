package com.feirasoft.postservice.model.post;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Post {
    private Long id;
    private String title;
    private String content;
    private int likeCount;
}
