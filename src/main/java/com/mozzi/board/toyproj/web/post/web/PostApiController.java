package com.mozzi.board.toyproj.web.post.web;

import com.mozzi.board.toyproj.web.post.dto.PostsResponseDto;
import com.mozzi.board.toyproj.web.post.dto.PostsSaveRequestDto;
import com.mozzi.board.toyproj.web.post.dto.PostsUpdateRequestDto;
import com.mozzi.board.toyproj.web.post.service.PostsService;
import com.mozzi.board.toyproj.web.post.web.request.AddPost;
import com.mozzi.board.toyproj.web.post.web.request.EditPost;
import com.mozzi.board.toyproj.web.post.web.response.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostApiController {
    private final PostsService postsService;

    @PostMapping
    public ResponsePost save(@RequestBody AddPost addPost) {
        return postsService.save(addPost);
    }

    @PatchMapping("/{post-id}")
    public ResponsePost update(@PathVariable("post-id") long postId,
                               @RequestBody EditPost editPost) {
        return postsService.update(postId, editPost);
    }

    @GetMapping("/{post-id}")
    public PostsResponseDto findById(@PathVariable("post-id") long postId) {
        return postsService.findById(postId);
    }

}
