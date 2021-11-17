package com.bootcamp.socialmeliSprint1.exception.postException;

public class PostIdAlreadyExists extends RuntimeException{
    public PostIdAlreadyExists(Integer userId,Integer idPost) {
        super( "El usuario con id:"+ userId + ", ya ha publicado un Post con id:" + idPost + ".");
    }
}
