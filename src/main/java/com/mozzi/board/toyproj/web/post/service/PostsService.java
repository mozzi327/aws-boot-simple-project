package com.mozzi.board.toyproj.web.post.service;

import com.mozzi.board.toyproj.web.post.repository.PostsRepository;
import com.mozzi.board.toyproj.web.post.domain.post.Posts;
import com.mozzi.board.toyproj.web.post.dto.PostsResponseDto;
import com.mozzi.board.toyproj.web.post.dto.PostsSaveRequestDto;
import com.mozzi.board.toyproj.web.post.dto.PostsUpdateRequestDto;
import com.mozzi.board.toyproj.web.post.web.request.AddPost;
import com.mozzi.board.toyproj.web.post.web.request.EditPost;
import com.mozzi.board.toyproj.web.post.web.response.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public ResponsePost save(AddPost addPost) {
        Posts post = Posts.builder()
                .title(addPost.getTitle())
                .content(addPost.getContent())
                .author(addPost.getAuthor())
                .build();

        postsRepository.save(post);
        return new ResponsePost(post);
    }

    @Transactional
    public ResponsePost update(long postId,
                                 EditPost editPost){
        Posts findPost = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다! : posts-id["+postId+"]"));

        findPost.editPost(editPost);

        postsRepository.save(findPost);

        return new ResponsePost(findPost);

    }

    public PostsResponseDto findById(long postsId) {
        Posts entity = postsRepository.findById(postsId)
                .orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다! : posts-id[" + postsId + "]"));
        return new PostsResponseDto(entity);
    }
}
