package com.feirasoft.postservice.dto;

import com.feirasoft.postservice.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public static PostDto toPostDto (Post post){
        return new PostDto()
                .setId(post.getId())
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(post.getLikeCount())
                .setCategory(null);
    }
}
