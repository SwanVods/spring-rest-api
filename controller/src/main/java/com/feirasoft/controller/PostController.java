package com.feirasoft.controller;

import com.feirasoft.domain.model.post.Post;
import com.feirasoft.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<Collection<Post>> retreiveAllPost() {
        Collection<Post> post = postService.retreivePosts();
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<?> storePost(@RequestBody Post post) {
        postService.storePost(post);
        return ResponseEntity.noContent().build();
    }
}
