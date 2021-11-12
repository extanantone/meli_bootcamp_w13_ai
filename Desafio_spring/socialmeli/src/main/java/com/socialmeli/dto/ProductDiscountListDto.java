package com.socialmeli.dto;

import com.socialmeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class ProductDiscountListDto {
    private int userId;
    private String userName;
    List<DiscountDtoWithoutUser> postDiscount;
}
