package com.anfel024.marketplace.persistence.mapper;

import com.anfel024.marketplace.domain.Product;
import com.anfel024.marketplace.persistence.entity.ProductosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    @Mappings({
            @Mapping(source= "productId", target = "productId"),
            @Mapping(source= "name", target = "productId"),
            @Mapping(source= "categoryId", target = "productId"),
            @Mapping(source= "price", target = "productId"),
            @Mapping(source= "stock", target = "productId"),
            @Mapping(source= "isActive", target = "productId"),
            @Mapping(source= "category", target = "productId"),
    })
    Product toProduct (Product mProduct);
}
