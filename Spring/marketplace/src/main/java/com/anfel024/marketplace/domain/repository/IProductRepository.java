package com.anfel024.marketplace.domain.repository;

import com.anfel024.marketplace.persistence.entity.ProductosEntity;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<ProductosEntity> getAll();
    Optional<List<ProductosEntity>> getByCategory(int categoryId);
    Optional<List<ProductosEntity>> getScarseProducts(int quantity);
    Optional<ProductosEntity> getProduct(int productId);
    ProductosEntity save(ProductosEntity productosEntity);
    void delete(int productId);
}
