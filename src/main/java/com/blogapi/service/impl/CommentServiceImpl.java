package com.blogapi.service.impl;

import com.blogapi.entity.Comment;
import com.blogapi.entity.Post;
import com.blogapi.exceptions.ResourceNotFoundException;
import com.blogapi.payload.CommentDto;
import com.blogapi.repository.CommentRepository;
import com.blogapi.repository.PostRepository;
import com.blogapi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepo;
    private CommentRepository commentRepo;

    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepo, CommentRepository commentRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));

        Comment comment = mapToEntity(commentDto);
//        Comment comment = new Comment();
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());

        comment.setPost(post);

        Comment saved = commentRepo.save(comment);

        CommentDto dto = mapToDto(saved);

//        CommentDto dto = new CommentDto();
//        dto.setId(saved.getId());
//        dto.setName(saved.getName());
//        dto.setEmail(saved.getEmail());
//        dto.setBody(saved.getBody());

        return dto;
    }

    @Override
    public List<CommentDto> findCommentByPostId(long postId) {
        List<Comment> comment = commentRepo.findByPostId(postId);
        List<CommentDto> collect = comment.stream().map(comment1 -> mapToDto(comment1)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteAComment(long id, long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        commentRepo.deleteById(id);
    }

    @Override
    public CommentDto findCommentById(long postId, long id) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        CommentDto commentDto = mapToDto(comment);

        return commentDto;
    }

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> all = commentRepo.findAll();
        List<CommentDto> comments = all.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
        return comments;
    }

    @Override
    public CommentDto updateAComment(CommentDto dto, long id, long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        Comment comment1 = mapToEntity(dto);
        comment1.setId(comment.getId());
        comment1.setPost(post);
        Comment saved = commentRepo.save(comment1);
        CommentDto updatedDto = mapToDto(saved);
        return updatedDto;
    }


    public CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    public Comment mapToEntity(CommentDto dto){
        Comment comment = modelMapper.map(dto, Comment.class);
        return comment;
    }
}
