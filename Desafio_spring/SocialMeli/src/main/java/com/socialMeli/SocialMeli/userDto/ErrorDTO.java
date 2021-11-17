package com.socialMeli.SocialMeli.userDto;

public class ErrorDTO {
    private String message="";

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
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
