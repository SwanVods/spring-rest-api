package com.feirasoft.postservice.repository;

import com.feirasoft.postservice.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "PostRepository")
public interface PostRepository extends MongoRepository<Post, String> {
    Post findByTitle(String title);
}
