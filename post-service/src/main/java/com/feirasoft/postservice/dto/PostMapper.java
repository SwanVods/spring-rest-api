package com.feirasoft.postservice.dto;

import com.feirasoft.postservice.model.Category;
import com.feirasoft.postservice.model.Post;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public static PostDto toPostDto (Post post){
        return new PostDto()
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(post.getLikeCount())
                .setCategories(null);
    }
}
