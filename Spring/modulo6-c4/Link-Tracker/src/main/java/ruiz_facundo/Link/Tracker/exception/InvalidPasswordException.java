package ruiz_facundo.Link.Tracker.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String exMessage) {
        super(exMessage);
    }
}
