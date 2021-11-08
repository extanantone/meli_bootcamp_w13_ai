package com.example.Blog.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private Long id;

    public NotFoundException(Long id) {
        this.id = id;
    }
}
