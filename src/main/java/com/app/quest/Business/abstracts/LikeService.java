package com.app.quest.Business.abstracts;

import com.app.quest.Business.requests.LikeCreateRequest;
import com.app.quest.Business.responses.LikeByIdResponse;
import com.app.quest.Business.responses.LikeResponse;
import com.app.quest.entities.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAllLikes(Optional<Long> userId, Optional<Long> postId);

    LikeByIdResponse getLikeById(Long likeId);

    LikeCreateRequest createLike(LikeCreateRequest newLike);

    void deleteLikeById(Long likeId);
}
