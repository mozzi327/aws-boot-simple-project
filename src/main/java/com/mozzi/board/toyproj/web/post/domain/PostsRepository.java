package com.mozzi.board.toyproj.web.post.domain;

import com.mozzi.board.toyproj.web.post.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
