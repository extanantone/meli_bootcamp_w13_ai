package ruiz_facundo.SocialMeli.exception;

public class InvalidSortCriteriaException extends RuntimeException {
    public InvalidSortCriteriaException () {
        super(String.format("El parámetro order no es válido"));
    }
}
