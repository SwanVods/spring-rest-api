package com.feirasoft.postservice.service;

import com.feirasoft.postservice.model.post.Post;

import java.util.Collection;

public interface PostService {
    Collection<Post> retreivePosts();
    void storePost(Post post);
    void updatePost(Long id, Post post);
    void deletePost(Long id);
    Post viewPost(Long id);
}