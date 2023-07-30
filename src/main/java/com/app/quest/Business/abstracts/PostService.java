package com.app.quest.Business.abstracts;

import com.app.quest.Business.requests.PostCreateRequest;
import com.app.quest.Business.requests.PostUpdateRequest;
import com.app.quest.entities.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts( Optional<Long> userId);
    Post getPostById( Long postId);
    Post createPost( PostCreateRequest newPostRequest);
    Post updatePost(Long postId, PostUpdateRequest postUpdateRequest);
    void deletePost( Long postId);
}
