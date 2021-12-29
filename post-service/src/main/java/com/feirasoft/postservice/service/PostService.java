package com.feirasoft.postservice.service;

import com.feirasoft.postservice.dto.PostDto;

import java.util.Collection;

public interface PostService {

    Collection<PostDto> retrievePosts();

    PostDto storePost(PostDto postDto);

    PostDto updatePost(String id, PostDto postDto);

    boolean deletePost(String id);

    PostDto viewPost(String id);

    void likePost(String id);
}