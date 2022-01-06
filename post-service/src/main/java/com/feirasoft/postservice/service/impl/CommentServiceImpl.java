package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.dto.CommentDto;
import com.feirasoft.postservice.dto.mapper.EntityMapper;
import com.feirasoft.postservice.model.Comment;
import com.feirasoft.postservice.repository.CommentRepository;
import com.feirasoft.postservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    private final EntityMapper entityMapper;

    @Override
    public Collection<CommentDto> retreiveComments(String id) {
        return repository.findAll()
                .stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto storeComment(CommentDto comment) {
        Comment commentModel = new Comment().setComment(comment.getComment())
                .setId(comment.getId())
                .setPostId(comment.getPostId())
                .setUserId(comment.getUserId());
        return modelMapper.map(repository.save(commentModel), CommentDto.class);
    }

    @Override
    public CommentDto updateComment(String id, CommentDto commentDto) {
        Optional<Comment> comment = repository.findById(id);
        if(comment.isPresent()) {
            Comment commentModel = comment.get();
            commentModel.setComment(commentModel.getComment());
            return modelMapper.map(repository.save(commentModel), CommentDto.class);
        }
        return null;
    }

    @Override
    public boolean deleteComment(String id) {
        Optional<Comment> comment = repository.findById(id);
        if(comment.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
