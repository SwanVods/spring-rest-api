package com.feirasoft.postservice.service.impl;


import com.feirasoft.postservice.dto.PostDto;
import com.feirasoft.postservice.dto.PostMapper;
import com.feirasoft.postservice.model.Post;
import com.feirasoft.postservice.repository.CategoryRepository;
import com.feirasoft.postservice.repository.PostRepository;
import com.feirasoft.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "postServiceImpl")
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Collection<PostDto> retrievePosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto storePost(PostDto postDto) {
        Post post = postRepository.findByTitle(postDto.getTitle());
        if(post == null) {
            post = new Post()
                    .setTitle(postDto.getTitle())
                    .setContent(postDto.getContent())
                    .setLikeCount(postDto.getLikeCount())
                    .setCategory(postDto.getCategory());
            return PostMapper.toPostDto(postRepository.save(post));
        }
        return null;
    }

    @Override
    public PostDto updatePost(String id, PostDto postDto) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            Post postModel = post.get();
            postModel.setTitle(postDto.getTitle())
                    .setContent(postDto.getContent())
                    .setLikeCount(postDto.getLikeCount())
                    .setCategory(postDto.getCategory());
            return PostMapper.toPostDto(postRepository.save(postModel));
        }
        return null;
    }

    @Override
    public boolean deletePost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public PostDto viewPost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            Post postModel = post.get();
            return PostMapper.toPostDto(postModel);
        }
        return null;
    }

    @Override
    public void likePost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            Post postModel = post.get();
            postModel.setLikeCount(postModel.getLikeCount()+1);
            PostMapper.toPostDto(postRepository.save(postModel));
        }
    }

}
