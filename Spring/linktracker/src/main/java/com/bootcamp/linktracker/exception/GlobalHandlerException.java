package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    private class JsonResponse {
        String error;

        public JsonResponse() {
        }

        public JsonResponse(String error) {
            this.error = error;
        }

        public String getMessage() {
            return error;
        }

        public void setMessage(String error) {
            this.error = error;
        }
    }


    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<JsonResponse> invalidPasswordException(){
        return new ResponseEntity<>(new JsonResponse("Contraseña incorrecta"), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(DisabledLinkException.class)
    public ResponseEntity<JsonResponse> disabledLinkException(){
        return new ResponseEntity<>(new JsonResponse("Link deshabilitado"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<JsonResponse> invalidLinkException(){
        return new ResponseEntity<>(new JsonResponse("Link Invalido"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<JsonResponse> nullPointerException(){
        return new ResponseEntity<>(new JsonResponse("Bad Request"), HttpStatus.BAD_REQUEST);
    }


}
