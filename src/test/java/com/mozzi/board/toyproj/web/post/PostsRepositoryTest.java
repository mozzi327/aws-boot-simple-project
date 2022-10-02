package com.mozzi.board.toyproj.web.post;

import com.mozzi.board.toyproj.post.domain.post.Posts;
import com.mozzi.board.toyproj.post.repository.PostsRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterReturning
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("mozzi329@naver.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertEquals(posts.getTitle(), title);
        assertEquals(posts.getContent(), content);
    }
}