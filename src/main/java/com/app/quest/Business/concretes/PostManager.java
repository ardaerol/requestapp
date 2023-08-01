package com.app.quest.Business.concretes;

import com.app.quest.Business.abstracts.PostService;
import com.app.quest.Business.abstracts.UserService;
import com.app.quest.Business.requests.PostCreateRequest;
import com.app.quest.Business.requests.PostUpdateRequest;
import com.app.quest.Business.responses.PostResponse;
import com.app.quest.dataAcess.abstracts.PostRepository;
import com.app.quest.entities.Post;
import com.app.quest.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostManager implements PostService {
    private PostRepository postRepository;
    private UserService userService;

    @Override
    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> posts;
        if (userId.isPresent()) {
            posts = postRepository.findByUserId(userId.get());

        }else {
           posts =  postRepository.findAll();
        }
        return posts.stream().map(post -> new PostResponse(post)).collect(Collectors.toList());

    }

    @Override
    public PostResponse getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        return new PostResponse(post);
    }

    @Override
    public Post createPost(PostCreateRequest newPostRequest) {
       User user = userService.getUserById(newPostRequest.getUserId());
       if (user == null){
           return null;
       }
       Post toSave = new Post();
       toSave.setText(newPostRequest.getText());
       toSave.setTitle(newPostRequest.getTitle());
       toSave.setUser(user);
        return postRepository.save(toSave);
    }

    @Override
    public Post updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(postUpdateRequest.getText());
            toUpdate.setTitle(postUpdateRequest.getTitle());
             postRepository.save(toUpdate);
             return toUpdate;
        }
        return null;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
