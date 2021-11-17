package com.bootcamp.socialmeliSprint1.exception.userException;

public class PurchaserAlreadyFollowSeller extends RuntimeException{

    public PurchaserAlreadyFollowSeller(Integer purchaserId, Integer sellerId) {
        super("El usuario con id:" + purchaserId
                + ", ya sigue al vendedor con id:"+sellerId);
    }
}
