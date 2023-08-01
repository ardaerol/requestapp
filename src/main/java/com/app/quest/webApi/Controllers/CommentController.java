package com.app.quest.webApi.Controllers;

import com.app.quest.Business.abstracts.CommentService;
import com.app.quest.Business.requests.CommentCreateRequest;
import com.app.quest.Business.requests.CommentUpdateRequest;
import com.app.quest.entities.Comment;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId ) {
        return commentService.getAllComments(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);

    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest newComment) {
        return commentService.createComment(newComment);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateCommentById(commentId,commentUpdateRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
