package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    protected Map<Integer, Product> products;
}
