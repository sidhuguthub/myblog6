package com.blogapi.controller;

import com.blogapi.payload.CommentDto;
import com.blogapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/comment/id

    @PostMapping("/comment/{postId}")
    public ResponseEntity<CommentDto> saveComment(@PathVariable("postId") long postId,
                                                  @RequestBody CommentDto commentDto){

        CommentDto savedComment = commentService.createComment(postId, commentDto);

        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/comment/{postId}")
    public List<CommentDto> findAllComments(@PathVariable("postId") long postId){
        List<CommentDto> allComments = commentService.findCommentByPostId(postId);
        return allComments;
    }

    //http://localhost:8080/api/comment/id=/postId=

    @DeleteMapping("/comment/{postId}/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") long postId,@PathVariable("id") long id){
        commentService.deleteAComment(postId,id);
        return new ResponseEntity<>("Comment Deleted For Id Number :"+id, HttpStatus.OK);
    }

    @GetMapping("/comment/{postId}/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("postId") long postId,@PathVariable("id") long id){
       CommentDto dto = commentService.findCommentById(postId,id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/comment")
    public List<CommentDto> getAllComments(){
        List<CommentDto> comments = commentService.findAllComments();
        return comments;
    }

    @PutMapping("/comment/{postId}/{id}")
    public CommentDto updateComment(@RequestBody CommentDto dto,@PathVariable("id") long id,@PathVariable("postId") long postId){
        CommentDto updatedDto = commentService.updateAComment(dto,id,postId);
        return updatedDto;
    }

}
