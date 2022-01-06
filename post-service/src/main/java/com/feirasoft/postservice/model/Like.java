package com.feirasoft.postservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "likes")
public class Like {
    @Id
    private String id;
    private int userId;
    private String postId;
    private boolean isLiked;
}
