package ruiz_facundo.SocialMeli.exception;

public class UserIdNotFoundException extends RuntimeException {
    public UserIdNotFoundException(Long idUser) {
        super(String.format("No se encontraron usuarios con id %d", idUser));
    }
}
