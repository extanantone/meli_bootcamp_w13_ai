package com.example.SocialMeli.mapper;

import com.example.SocialMeli.dto.ProductDto;
import com.example.SocialMeli.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class);

    //@Mapping(target = "")
    ProductDto productToProductDto(Product product);
}
