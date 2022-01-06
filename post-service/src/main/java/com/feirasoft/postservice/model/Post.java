package com.feirasoft.postservice.model;

import com.feirasoft.postservice.dto.CommentDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
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
    private Collection<CommentDto> comments;

    @DBRef
    private Category category;

    private int userId;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;
}
