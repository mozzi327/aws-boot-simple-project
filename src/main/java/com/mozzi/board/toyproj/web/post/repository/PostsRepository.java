package com.mozzi.board.toyproj.web.post.repository;

import com.mozzi.board.toyproj.web.post.domain.post.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
