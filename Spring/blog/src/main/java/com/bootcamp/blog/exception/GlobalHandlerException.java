package com.bootcamp.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class GlobalHandlerException {

    private class JsonResponse {
        String error;

        public JsonResponse() {
        }

        public JsonResponse(String error) {
            super();
            this.error = error;
        }

        public String getMessage() {
            return error;
        }

        public void setMessage(String error) {
            this.error = error;
        }
    }

    @ExceptionHandler(DuplicateBlogException.class)
    public ResponseEntity<JsonResponse> duplicateHandlerException(){
        return new ResponseEntity<>(new JsonResponse("Id duplicada"), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<JsonResponse> notFoundException(){
        return new ResponseEntity<>(new JsonResponse("Id no encontrada"), HttpStatus.NOT_FOUND);
    }
}
