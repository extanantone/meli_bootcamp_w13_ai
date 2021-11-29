package com.bootcamp.SocialMeli.dto;

public class ErrorDTO {
    private String message = "";

    public ErrorDTO(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return
                "message= '" + message;
    }
}