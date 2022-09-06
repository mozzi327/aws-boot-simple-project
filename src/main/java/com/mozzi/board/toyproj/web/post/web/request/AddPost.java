package com.mozzi.board.toyproj.web.post.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// 추가..
@Getter
@Setter
public class AddPost {

    private String title;
    private String content;
    private String author;

    @Builder
    public AddPost(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
