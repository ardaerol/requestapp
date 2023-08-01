package com.app.quest.Business.concretes;

import com.app.quest.Business.abstracts.CommentService;
import com.app.quest.Business.abstracts.PostService;
import com.app.quest.Business.abstracts.UserService;
import com.app.quest.Business.requests.CommentCreateRequest;
import com.app.quest.Business.requests.CommentUpdateRequest;
import com.app.quest.dataAcess.abstracts.CommentRepository;
import com.app.quest.entities.Comment;
import com.app.quest.entities.Post;
import com.app.quest.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;
    @Override
    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }else {
            return commentRepository.findAll();
        }

    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow();
    }

    @Override
    public Comment createComment(CommentCreateRequest newComment) {
        User user = userService.getUserById(newComment.getUserId());
        Post post = postService.getPostById(newComment.getPostId());
        if (user != null && post != null){
            Comment commenToSave = new Comment();

            commenToSave.setPost(post);
            commenToSave.setUser(user);
            commenToSave.setText(newComment.getText());
            return commentRepository.save(commenToSave);
        }else {
            return null;
        }

    }

    @Override
    public Comment updateCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(commentToUpdate);
        }else {
            return null;
        }

    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
