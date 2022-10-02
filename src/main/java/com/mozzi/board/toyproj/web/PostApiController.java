package com.mozzi.board.toyproj.web;

import com.mozzi.board.toyproj.post.service.PostsService;
import com.mozzi.board.toyproj.web.request.AddPost;
import com.mozzi.board.toyproj.web.request.EditPost;
import com.mozzi.board.toyproj.web.response.ResponsePost;
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

    @PutMapping("/{post-id}")
    public ResponsePost update(@PathVariable("post-id") Long postId,
                               @RequestBody EditPost editPost) {
        return postsService.update(postId, editPost);
    }

    @DeleteMapping("/{post-id}")
    public Long delete(@PathVariable("post-id") Long postId) {
        postsService.delete(postId);
        return postId;
    }

    @GetMapping("/{post-id}")
    public ResponsePost findById(@PathVariable("post-id") long postId) {
        return postsService.findById(postId);
    }

}
