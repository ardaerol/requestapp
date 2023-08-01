package com.app.quest.Business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeCreateRequest {
    private Long userId;
    private Long postId;

}
