package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DuplicateException extends RuntimeException {

    Long id;
    String msg;

    public DuplicateException(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }
}
