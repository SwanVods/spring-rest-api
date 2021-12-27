package com.feirasoft.postservice.controller;


import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.dto.Response;
import com.feirasoft.postservice.model.Post;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> retreiveAllPost() {
        List<Post> post = postService.retreivePosts();
        return ResponseEntity.ok(post);
    }

    public ResponseEntity<PostDto> retreivePostById(@RequestParam PostDto postDto) {
        PostDto post = postService.viewPost(postDto);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public Response storePost(@RequestBody PostRequest post) {
        PostDto payload = postService.storePost(new PostDto()
                .setTitle(post.getTitle())
                .setContent(post.getContent())
                .setLikeCount(0));
        return Response.ok().setPayload(payload);
    }

    @PatchMapping
    public ResponseEntity<?> updatePost(@RequestBody PostDto post) {
        postService.updatePost(post);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deletePost(Long id) {
//        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
