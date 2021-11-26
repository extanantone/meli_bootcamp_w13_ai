package com.SocialMeli.Sprint1SocialMeli.Exception;

public class DuplicateFollowedException extends RuntimeException {
    public DuplicateFollowedException(Integer id) {
        super( "YA SIGUES AL VENDEDOR: " + id+" !!!!" );
    }

}
