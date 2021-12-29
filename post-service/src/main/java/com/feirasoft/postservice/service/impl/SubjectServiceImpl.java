package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.repository.PostRepository;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    public Collection<PostDto> retrievePosts() {
        return null;
    }

    @Override
    public PostDto storePost(PostDto postDto) {
        return null;
    }

    @Override
    public PostDto updatePost(String id, PostDto postDto) {
        return null;
    }

    @Override
    public boolean deletePost(String id) {
        return false;
    }

    @Override
    public PostDto viewPost(String id) {
        return null;
    }

    @Override
    public void likePost(String id) {

    }


}
