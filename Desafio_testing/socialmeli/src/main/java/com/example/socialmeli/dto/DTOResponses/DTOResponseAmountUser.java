package com.example.socialmeli.dto.DTOResponses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOResponseAmountUser implements Serializable {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;
    private Integer promo_products_count;
}
