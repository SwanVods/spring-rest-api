package com.feirasoft.postservice.repository;

import com.feirasoft.postservice.dto.CommentDto;
import com.feirasoft.postservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Collection<CommentDto> findCommentsByPostId(String id);
}
