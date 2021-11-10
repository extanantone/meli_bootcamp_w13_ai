package com.bootcamp.Mensajero.exception;

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


    @ExceptionHandler(MensajeroOffException.class)
    public ResponseEntity<JsonResponse> invalidPasswordException(MensajeroOffException e){
        return new ResponseEntity<>(new JsonResponse(e.getMsg()), HttpStatus.BAD_REQUEST);
    }
}
