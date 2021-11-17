package com.SocialMeli.Sprint1SocialMeli.Exception;

public class PostIdDuplicateVendedorExeption extends RuntimeException {

    public PostIdDuplicateVendedorExeption(Integer vendedorid, int postId) {
        super("Ya existe la publicacion " + postId + " Para el vendedor " + vendedorid);
    }


}
