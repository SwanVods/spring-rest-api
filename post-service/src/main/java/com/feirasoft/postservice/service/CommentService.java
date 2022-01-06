package com.feirasoft.postservice.service;

import com.feirasoft.postservice.dto.CommentDto;

import java.util.Collection;

public interface CommentService {

    // post behavior
    Collection<CommentDto> retreiveComments(String id);

    // user behavior
    CommentDto storeComment(CommentDto comment);
    CommentDto updateComment(String id, CommentDto comment);
    boolean deleteComment(String id);
}
