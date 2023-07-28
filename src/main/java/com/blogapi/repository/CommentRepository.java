package com.blogapi.repository;

import com.blogapi.entity.Comment;
import com.blogapi.payload.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

   public List<Comment> findByPostId(long id);

}

