package com.feirasoft.postservice.controller;

import com.feirasoft.postservice.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PostRequest {

    @NotBlank(message = "Title field cannot be empty.")
    private String title;

    @NotBlank(message = "Content field cannot be empty.")
    private String content;

    private int userId;
    private int likeCount;
    private Category category;
}
