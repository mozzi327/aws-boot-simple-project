package com.mozzi.board.toyproj.web.response;

import com.mozzi.board.toyproj.post.domain.post.Posts;
import lombok.Getter;

@Getter
public class ResponsePost {

    private final Long postId;
    private final String title;
    private final String content;
    private final String author;

    public ResponsePost(Posts post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
