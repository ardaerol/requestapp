package com.app.quest.Business.concretes;

import com.app.quest.Business.abstracts.LikeService;
import com.app.quest.Business.abstracts.PostService;
import com.app.quest.Business.abstracts.UserService;
import com.app.quest.Business.requests.LikeCreateRequest;
import com.app.quest.Business.responses.LikeByIdResponse;
import com.app.quest.Business.responses.LikeResponse;
import com.app.quest.Business.responses.PostResponse;
import com.app.quest.dataAcess.abstracts.LikeRepository;
import com.app.quest.entities.Like;
import com.app.quest.entities.Post;
import com.app.quest.entities.User;
import com.app.quest.utilities.mapper.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;
    private ModelMapperService modelMapperService;

    @Override
    public List<LikeResponse> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        List<Like> likes;
        if (userId.isPresent() &&  postId.isPresent()) {
            likes =likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            likes = likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            likes = likeRepository.findByPostId(postId.get());
        }else {
            likes = likeRepository.findAll();

        }
        return likes.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());

    }

    @Override
    public LikeByIdResponse getLikeById(Long likeId) {
        Like like = likeRepository.findById(likeId).orElseThrow();
        return new LikeByIdResponse(like);
    }

    @Override
    public LikeCreateRequest createLike(LikeCreateRequest newLike) {
        User user = userService.getUserById(newLike.getUserId());
        Post post  = this.modelMapperService.forRequest().map(newLike, Post.class);

        if (user != null && post != null){
            Like likeToSave = new Like();
            likeToSave.setUser(user);
            likeToSave.setPost(post);

            return likeRepository.save(likeToSave);
        }else {
            return null;
        }

    }

    @Override
    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
