package com.temi.springboot.service.impl;

import com.temi.springboot.entity.Comment;
import com.temi.springboot.entity.Post;
import com.temi.springboot.exception.ResourceNotFoundException;
import com.temi.springboot.payload.CommentDto;
import com.temi.springboot.repository.CommentRepository;
import com.temi.springboot.repository.PostRepository;
import com.temi.springboot.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImplementation(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto creteComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId)
        );
        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);


        return mapToDTO(newComment);
    }

    private CommentDto mapToDTO (Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());

        return commentDto;
    }

    private Comment mapToEntity (CommentDto commentDto){
        Comment comment = new Comment();
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());
        comment.setId(comment.getId());

        return comment;
    }
}
