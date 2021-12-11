package com.feirasoft.service;

import com.feirasoft.domain.model.post.Post;

import java.util.Collection;

public interface PostService {
    Collection<Post> retreivePosts();
    void storePost(Post post);
    void updatePost(Long id, Post post);
    void deletePost(Long id);

}