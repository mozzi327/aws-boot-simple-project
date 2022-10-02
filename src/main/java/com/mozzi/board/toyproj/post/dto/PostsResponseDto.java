package com.mozzi.board.toyproj.post.dto;

import com.mozzi.board.toyproj.post.domain.post.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
