package com.feirasoft.postservice.repository;

import com.feirasoft.postservice.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LikeRepository extends MongoRepository<Like, String> {
    Like findLikeByUserId(int id);

    @Query(value = "{is_liked: ?0}", count = true)
    int countPostLikeByLiked(String id, boolean isLiked);
}
