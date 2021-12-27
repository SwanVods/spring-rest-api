package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.model.Post;
import com.feirasoft.postservice.repository.PostRepository;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    public List<Post> retreivePosts() {
        return repository.findAll();
    }

    @Override
    public PostDto storePost(PostDto postDto) {
        return null;
    }

    @Override
    public void updatePost(PostDto postDto) {

    }

    @Override
    public void deletePost(PostDto postDto) {

    }

    @Override
    public PostDto viewPost(PostDto postDto) {
        return null;
    }


}
