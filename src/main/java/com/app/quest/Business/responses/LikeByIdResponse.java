package com.app.quest.Business.responses;

import com.app.quest.entities.Like;
import lombok.Data;

@Data
public class LikeByIdResponse {
    private Long id;
    private Long userId;
    private String userName;
    private Long postId;

    public LikeByIdResponse(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.postId = entity.getPost().getId();
    }

}
