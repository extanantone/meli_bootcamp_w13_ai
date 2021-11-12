package ruiz_facundo.SocialMeli.exception;

public class FollowNotFoundException extends RuntimeException {
    public FollowNotFoundException(Long idFollower, Long idFollowed) {
        super(String.format("El usuario %d no sigue al %d", idFollower, idFollowed));
    }
}
