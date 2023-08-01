package com.app.quest.webApi.Controllers;

import com.app.quest.Business.abstracts.LikeService;
import com.app.quest.Business.requests.LikeCreateRequest;
import com.app.quest.Business.responses.LikeByIdResponse;
import com.app.quest.Business.responses.LikeResponse;
import com.app.quest.entities.Like;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
public class LikeController {

    private LikeService likeService;

    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return likeService.getAllLikes(userId, postId);
    }

    @GetMapping("/{likeId}")
    public LikeByIdResponse getLikeById(@PathVariable Long likeId) {
        return likeService.getLikeById(likeId);
    }

    @PostMapping
    public LikeCreateRequest createLike(@RequestBody LikeCreateRequest newLike) {
        return likeService.createLike(newLike);
    }


    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Long likeId) {
        likeService.deleteLikeById(likeId);
    }


}
