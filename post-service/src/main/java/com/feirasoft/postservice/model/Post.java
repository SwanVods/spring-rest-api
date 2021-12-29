package com.feirasoft.postservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private Category category;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;
}
