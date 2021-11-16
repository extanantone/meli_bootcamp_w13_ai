package com.bootcamp.socialmeli.exception.UserException;

public class NotFoundFollower extends RuntimeException{
    public NotFoundFollower(Integer purchaserId, Integer sellerId) {
        super("El vendedor con id:" + purchaserId
                + ", nunca ha seguido al vendedor con id:"+sellerId);
    }
}
