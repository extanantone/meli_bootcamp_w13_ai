package com.bootcamp.socialmeli.exception.userException;

public class NotFoundFollower extends RuntimeException{
    public NotFoundFollower(Integer purchaserId, Integer sellerId) {
        super("El usuario con id:" + purchaserId
                + ", nunca ha seguido al vendedor con id:"+sellerId);
    }
}
