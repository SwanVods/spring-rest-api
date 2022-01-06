package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.dto.LikeDto;
import com.feirasoft.postservice.model.Like;
import com.feirasoft.postservice.repository.LikeRepository;
import com.feirasoft.postservice.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public LikeDto doLike(LikeDto likeDto) {
        Like like = repository.findLikeByUserId(likeDto.getUserId());
        if(like != null) {
            like.setLiked(like.isLiked());
        } else {
            like = new Like()
                    .setLiked(likeDto.isLiked())
                    .setUserId(likeDto.getUserId());
        }
        return modelMapper.map(repository.save(like), LikeDto.class);
    }

}
