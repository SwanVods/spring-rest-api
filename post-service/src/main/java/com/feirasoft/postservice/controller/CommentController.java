package com.feirasoft.postservice.controller;

import com.feirasoft.postservice.dto.CommentDto;
import com.feirasoft.postservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @PostMapping
    public ResponseEntity<?> store(@RequestBody CommentDto comment) {
        service.storeComment(comment);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody CommentDto commentDto) {
        service.updateComment(id, commentDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        if(service.deleteComment(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
