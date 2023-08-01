package com.app.quest.webApi.Controllers;

import com.app.quest.Business.abstracts.PostService;
import com.app.quest.Business.requests.PostCreateRequest;
import com.app.quest.Business.requests.PostUpdateRequest;
import com.app.quest.Business.responses.PostResponse;
import com.app.quest.entities.Post;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public PostResponse getPostById(@RequestParam Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createPost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest) {
        return postService.updatePost(postId,postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

}
