package com.feirasoft.postservice.controller;


import com.feirasoft.postservice.dto.CategoryDto;
import com.feirasoft.postservice.dto.LikeDto;
import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.service.LikeService;
import com.feirasoft.postservice.service.PostCategoryService;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final LikeService likeService;
    private final PostCategoryService postCategoryService;


    @GetMapping
    public ResponseEntity retrieveAllPost() {
        Collection<PostDto> post = postService.retrievePosts();
        return ResponseEntity.ok(post);
    }

    @GetMapping("/{id}")
    public ResponseEntity retrievePostById(@PathVariable String id) {
        PostDto post = postService.viewPost(id);
        if(post == null) {
            return ResponseEntity.notFound().build();
        }
        post.setLikeCount(postService.countPostLike(post));
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity storePost(@RequestBody @Valid PostRequest post) {
        PostDto postDto = postService.storePost(new PostDto()
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(0));
        return ResponseEntity.ok(postDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable String id, @RequestBody @Valid PostRequest post) {
        PostDto postDto = postService.updatePost(id, new PostDto()
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(post.getLikeCount()));
        if(postDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable String id) {
        boolean deleted = postService.deletePost(id);
        if(deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/like")
    public ResponseEntity likePost(@PathVariable String id) {
        postService.likePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories")
    public ResponseEntity retrieveAllCategories() {
        Collection<CategoryDto> category = postCategoryService.retrieveCategories();
        return ResponseEntity.ok(category);
    }

    @PostMapping("/categories")
    public ResponseEntity storeCategory(@RequestBody @Valid CategoryRequest category) {
        CategoryDto categoryDto = postCategoryService.createCategory(
                new CategoryDto().setName(category.getName())
        );
        if(categoryDto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.ok(categoryDto);
    }

    @PatchMapping("/categories/{name}")
    public ResponseEntity updateCategory(
            @PathVariable String name,
            @RequestBody @Valid CategoryRequest category) {

        CategoryDto categoryDto = postCategoryService.updateCategory(name, new CategoryDto()
                .setName(category.getName()));

        if(categoryDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/categories/{name}")
    public ResponseEntity deleteCategory(@PathVariable String name) {
        boolean deleted = postCategoryService.deleteCategory(name);
        if(deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/like")
    public ResponseEntity doLike(@RequestBody LikeDto likeDto) {
        likeService.doLike(likeDto);
        return ResponseEntity.noContent().build();
    }
}
