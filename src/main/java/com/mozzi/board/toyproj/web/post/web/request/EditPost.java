package com.mozzi.board.toyproj.web.post.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// 수정..
@Getter
@Setter
public class EditPost {
    private String title;
    private String content;

    @Builder
    public EditPost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
