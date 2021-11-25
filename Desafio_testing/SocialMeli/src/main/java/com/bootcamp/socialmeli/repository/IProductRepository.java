package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Product;

public interface IProductRepository {

    public Product getProduct(long id);
    public Product createProduct(Product product);
    public void deleteProduct(long id);
}
