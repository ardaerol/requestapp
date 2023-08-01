package com.app.quest.Business.abstracts;

import com.app.quest.Business.requests.CommentCreateRequest;
import com.app.quest.Business.requests.CommentUpdateRequest;
import com.app.quest.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAllComments( Optional<Long> userId,  Optional<Long> postId );
    Comment getCommentById( Long commentId);
    Comment createComment( CommentCreateRequest newComment);

    Comment updateCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest);

    void deleteCommentById(Long commentId);
}
