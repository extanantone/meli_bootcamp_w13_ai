package com.bootcamp.blog.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicatedBlogException extends RuntimeException{

    public DuplicatedBlogException(String message) {
        super(message);
    }

}
