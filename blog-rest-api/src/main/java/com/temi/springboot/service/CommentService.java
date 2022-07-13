package com.temi.springboot.service;

import com.temi.springboot.entity.Comment;
import com.temi.springboot.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto creteComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentByPostId(Long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commonRequest);
}
