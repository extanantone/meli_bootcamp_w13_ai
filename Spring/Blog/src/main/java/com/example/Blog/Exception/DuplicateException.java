package com.example.Blog.Exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DuplicateException extends RuntimeException {
    private Long id;

    public DuplicateException(Long id) {
        this.id = id;
    }
}
