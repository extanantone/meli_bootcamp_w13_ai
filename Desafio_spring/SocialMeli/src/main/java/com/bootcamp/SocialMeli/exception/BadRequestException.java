package com.bootcamp.SocialMeli.exception;


public class BadRequestException extends RuntimeException {

    public BadRequestException(String mensaje) {
        super(formatMessage(mensaje));
    }

    private static String formatMessage(String mensaje) {
        return new StringBuilder()
                .append(mensaje)
                .toString();
    }
}
