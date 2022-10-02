package com.mozzi.board.toyproj.web;

import com.mozzi.board.toyproj.post.dto.PostsResponseDto;
import com.mozzi.board.toyproj.post.service.PostsService;
import com.mozzi.board.toyproj.web.response.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{postId}")
    public String postsUpdate(@PathVariable("postId") Long postId, Model model) {
        ResponsePost dto = postsService.findById(postId);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
