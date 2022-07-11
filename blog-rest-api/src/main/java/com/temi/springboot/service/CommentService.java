package com.temi.springboot.service;

import com.temi.springboot.payload.CommentDto;

public interface CommentService {
    CommentDto creteComment(long postId, CommentDto commentDto);
}
