package com.temi.springboot.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {
    private Long id;

    //title should not be empty or null
    //title should have at least two characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have a least two characters")
    private String title;

    //Post description should not be null or empty
    //must have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
