package com.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDtoWithoutUser extends PostDtoWithoutUser{
    private boolean hasPromo;
    private double discount;
    public DiscountDtoWithoutUser(int postId, String date, DetailDto detail, int category, double price) {
        super(postId, date, detail, category, price);
    }

    public DiscountDtoWithoutUser(int id, String date, DetailDto detailDto, int category, double price, boolean hasDiscount, double discount) {
        setPostId(id);
        setDate(date);
        setDetail(detailDto);
        setCategory(category);
        setPrice(price);
        setDiscount(discount);
        setHasPromo(hasDiscount);
    }
}
