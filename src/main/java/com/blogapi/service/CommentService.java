package com.blogapi.service;

import com.blogapi.payload.CommentDto;

import java.util.List;

public interface CommentService {

    public CommentDto createComment(long postId, CommentDto commentDto);

    public List<CommentDto> findCommentByPostId(long postId);

    public void deleteAComment(long id, long postId);

    public CommentDto findCommentById(long postId, long id);

    public List<CommentDto> findAllComments();

    public CommentDto updateAComment(CommentDto dto, long id, long postId);
}
