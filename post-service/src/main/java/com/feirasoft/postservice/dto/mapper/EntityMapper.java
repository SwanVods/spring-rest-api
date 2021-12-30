package com.feirasoft.postservice.dto.mapper;

import com.feirasoft.postservice.dto.CategoryDto;
import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.model.Category;
import com.feirasoft.postservice.model.Post;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public static PostDto toPostDto (Post post){
        return new PostDto()
                .setId(post.getId())
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(post.getLikeCount())
                .setCategory(null);
    }

    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto()
                .setId(category.getId())
                .setName(category.getName());
    }
}
