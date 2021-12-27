package com.feirasoft.postservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
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

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
}
