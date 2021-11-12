package ruiz_facundo.SocialMeli.exception;

public class PostFoundException extends RuntimeException {
    public PostFoundException (Long id) {
        super(String.format("Ya existe una publicación con id %d", id));
    }
}
