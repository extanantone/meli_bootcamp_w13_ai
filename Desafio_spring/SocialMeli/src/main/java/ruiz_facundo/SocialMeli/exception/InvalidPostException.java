package ruiz_facundo.SocialMeli.exception;

public class InvalidPostException extends RuntimeException {
    public InvalidPostException (String message) {
        super(message);
    }
}
