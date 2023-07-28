package com.blogapi.service;

import com.blogapi.payload.PostDto;
import java.util.List;

public interface PostService {

    public PostDto updateThePost(PostDto postDto, long id);


    public PostDto createPost(PostDto postDto);


    public PostDto getPostById(long id);

    public List<PostDto> getAllPost(int pageNo, int PageSize, String sortBy, String sortDir);

    public void deletePost(long id);

}
