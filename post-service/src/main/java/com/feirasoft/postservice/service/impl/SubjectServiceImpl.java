package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.model.post.Post;
import com.feirasoft.postservice.repository.CategoryRepository;
import com.feirasoft.postservice.repository.PostRepository;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    @Query(value = "SELECT c.name FROM Category c WHERE c.name = \"subject\"")
    public Collection<Post> retreivePosts() {
        return repository.findAll();
    }

    @Override
    public void storePost(Post post) {

    }

    @Override
    public void updatePost(Long id, Post post) {

    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public Post viewPost(Long id) {
        return null;
    }
}
