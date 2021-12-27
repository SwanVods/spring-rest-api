package com.feirasoft.postservice.controller;

import com.feirasoft.postservice.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PostRequest {

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String title;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String content;

    private Set<Category> category;
}
