package com.temi.springboot.service;

import com.temi.springboot.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
