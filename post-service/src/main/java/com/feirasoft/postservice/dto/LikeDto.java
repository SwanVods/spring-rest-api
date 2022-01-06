package com.feirasoft.postservice.dto;

import lombok.Data;

@Data
public class LikeDto {
    int userId;
    String postId;
    boolean isLiked;
}
