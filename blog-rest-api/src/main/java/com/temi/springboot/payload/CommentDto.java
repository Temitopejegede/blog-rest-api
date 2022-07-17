package com.temi.springboot.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty()
    @Email(message = "Please provide a valid email")
    private String email;

    @NotEmpty
    @Size(min = 10, message = "Comment body should not be less that 10 characters")
    private String body;
}
