package com.feirasoft.postservice.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class CategoryRequest {
    @NotBlank(message = "Category name field cannot be empty.")
    private String name;
}
