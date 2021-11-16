package com.anfel024.marketplace.domain;

import com.anfel024.marketplace.persistence.entity.CategoriasEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean isActive;
    private Category category;
}
