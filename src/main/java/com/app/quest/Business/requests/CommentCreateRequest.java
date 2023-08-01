package com.app.quest.Business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentCreateRequest {
//    private Long id;
    private Long postId;
    private Long userId;
    private String text;
}
