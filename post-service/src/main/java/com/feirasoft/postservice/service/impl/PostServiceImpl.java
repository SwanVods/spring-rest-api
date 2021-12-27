package com.feirasoft.postservice.service.impl;


import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.dto.PostMapper;
import com.feirasoft.postservice.model.Category;
import com.feirasoft.postservice.model.Post;
import com.feirasoft.postservice.repository.CategoryRepository;
import com.feirasoft.postservice.repository.PostRepository;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.feirasoft.postservice.dto.Response.Status.DUPLICATE_ENTITY;
import static com.feirasoft.postservice.dto.Response.Status.EXCEPTION;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final PostMapper postMapper;

    @Override
    public List<Post> retreivePosts() {
        return postRepository.findAll();
    }

    @Override
    public PostDto storePost(PostDto postDto) {
        Post post = postRepository.findByTitle(postDto.getTitle());
        if(post == null) {
            post = new Post()
                    .setTitle(postDto.getTitle())
                    .setContent(postDto.getContent())
                    .setLikeCount(postDto.getLikeCount());
            return PostMapper.toPostDto(postRepository.save(post));
        }
        return null;
    }

    @Override
    public void updatePost(PostDto post) {
//        List<Post> postById = postRepository.findAll();
//        if(postById.isPresent()) {
//            Post postModel = postById.get();
//            postModel.setTitle(post.getTitle())
//                    .setContent(post.getContent())
//                    .setLikeCount(post.getLikeCount());
//        }
    }

    @Override
    public void deletePost(PostDto postDto) {
//        postRepository.delete(postDto);
    }

    @Override
    public PostDto viewPost(PostDto postDto) {
        return null;
    }
}
