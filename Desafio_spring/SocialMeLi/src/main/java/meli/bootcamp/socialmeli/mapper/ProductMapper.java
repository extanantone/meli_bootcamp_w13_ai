package meli.bootcamp.socialmeli.mapper;

import meli.bootcamp.socialmeli.dto.ProductsDTO;
import meli.bootcamp.socialmeli.dto.ProductsPostDTO;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source= "product_id", target = "productId"),
            @Mapping(source= "product_name", target = "productName"),
            @Mapping(source= "type", target = "type"),
            @Mapping(source= "brand", target = "brand"),
            @Mapping(source= "color", target = "color"),
            @Mapping(source= "notes", target = "notes")
    })
    Product productoPostDTOtoProduct(ProductsDTO productsPostDTO);

    @InheritInverseConfiguration
    ProductsDTO productToProductoPostDTO(Product mProduct);
}
