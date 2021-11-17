package com.SocialMeli.Sprint1SocialMeli.Exception;

public class PostIdDuplicateVendedor extends RuntimeException {

    public PostIdDuplicateVendedor(Integer vendedorid, int postId) {
        super("Ya existe la publicacion " + postId + " Para el vendedor " + vendedorid);
    }


}
