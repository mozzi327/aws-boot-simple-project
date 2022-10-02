package com.mozzi.board.toyproj.post.service;

import com.mozzi.board.toyproj.post.dto.PostsListResponseDto;
import com.mozzi.board.toyproj.web.request.AddPost;
import com.mozzi.board.toyproj.web.request.EditPost;
import com.mozzi.board.toyproj.web.response.ResponsePost;
import com.mozzi.board.toyproj.post.repository.PostsRepository;
import com.mozzi.board.toyproj.post.domain.post.Posts;
import com.mozzi.board.toyproj.post.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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


    @Transactional
    public void delete(long postId) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. posts-id["+postId+"]"));
        postsRepository.delete(posts);
    }


    public ResponsePost findById(Long postId) {
        Posts entity = postsRepository.findById(postId).orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다! : posts-id[" + postId + "]"));
        return new ResponsePost(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
