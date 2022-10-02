package com.mozzi.board.toyproj.web.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mozzi.board.toyproj.post.domain.post.Posts;
import com.mozzi.board.toyproj.post.repository.PostsRepository;
import com.mozzi.board.toyproj.web.request.AddPost;
import com.mozzi.board.toyproj.web.request.EditPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class PostApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostsRepository postsRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void clean() throws Exception {
        postsRepository.deleteAll();
    }

    @DisplayName("글이 저장된다.")
    @Test
    public void addPost() throws Exception {
        // given
        AddPost addPost = AddPost.builder()
                .title("제목")
                .content("내용")
                .author("길동이")
                .build();


        // then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addPost)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("제목"))
                .andExpect(jsonPath("$.content").value("내용"))
                .andExpect(jsonPath("$.author").value("길동이"))
                .andDo(print());
    }

    @Test
    @DisplayName("글이 수정된다.")
    public void editPost() throws Exception {
        // given
        Posts post = Posts.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build();

        postsRepository.save(post);

        EditPost editPost = EditPost.builder()
                .title("title")
                .content("content")
                .build();

        // when
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/post/{post-id}", post.getPostId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(editPost)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post.getPostId()))
                .andExpect(jsonPath("$.title").value("title"))
                .andExpect(jsonPath("$.content").value("content"))
                .andExpect(jsonPath("$.author").value("작성자"))
                .andDo(print());
        // then
    }

    @Test
    @DisplayName("BaseTimeEntity 등록")
    public void EnableBaseTimeEntityTest() {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 9, 7, 0, 11, 0);
        postsRepository.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createdAt="+posts.getCreatedAt() +
                ", modifiedAt="+posts.getModifiedAt());
        Assertions.assertEquals(posts.getCreatedAt(), now);
        Assertions.assertEquals(posts.getModifiedAt(), now);
    }
}