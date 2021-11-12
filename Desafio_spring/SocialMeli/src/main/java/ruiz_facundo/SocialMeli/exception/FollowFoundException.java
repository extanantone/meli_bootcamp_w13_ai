package ruiz_facundo.SocialMeli.exception;

public class FollowFoundException extends RuntimeException {
    public FollowFoundException(Long idFollower, Long idFollowed) {
        super(String.format("El usuario %d ya sigue al %d", idFollower, idFollowed));
    }
}
