package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDTO {
    protected int product_id;
    protected String product_name;
    protected String type;
    protected String brand;
    protected String color;
    protected String notes;
}
