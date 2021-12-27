package com.feirasoft.postservice.service;

import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.model.Post;

import java.util.Collection;
import java.util.List;

public interface PostService {

    List<Post> retreivePosts();

    PostDto storePost(PostDto postDto);

    void updatePost(PostDto postDto);

    void deletePost(PostDto postDto);

    PostDto viewPost(PostDto postDto);
}