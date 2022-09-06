package com.mozzi.board.toyproj.web.post.web.response;

import com.mozzi.board.toyproj.web.post.domain.post.Posts;
import lombok.Getter;

@Getter
public class ResponsePost {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public ResponsePost(Posts post) {
        this.id = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
