package com.feirasoft.postservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Set;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private int likeCount;

    @DBRef
    private Set<Category> categories;

    @CreatedDate
    private Timestamp created_at;
    @LastModifiedDate
    private Timestamp updated_at;
}