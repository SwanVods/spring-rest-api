package com.feirasoft.postservice.service.impl;


import com.feirasoft.postservice.model.post.Post;
import com.feirasoft.postservice.repository.PostRepository;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Collection<Post> retreivePosts() {
        return postRepository.findAll();
    }

    @Override
    public void storePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post post) {
        postRepository.findById(id).get();
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
