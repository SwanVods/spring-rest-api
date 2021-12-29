package com.feirasoft.postservice.controller;


import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(@Qualifier("postServiceImpl") PostService postService) {
        this.postService = postService;
    }

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
        return ResponseEntity.ok(post);
    }

    @PostMapping("/create")
    public ResponseEntity storePost(@RequestBody @Valid PostRequest post) {
        PostDto postDto = postService.storePost(new PostDto()
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(0));
        return ResponseEntity.ok(postDto);
    }

    @PatchMapping("/update/{id}")
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

    @DeleteMapping("/delete/{id}")
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
}
