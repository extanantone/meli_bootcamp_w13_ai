package meli.bootcamp.socialmeli.mapper;

import meli.bootcamp.socialmeli.dto.ProductsDTO;
import meli.bootcamp.socialmeli.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase para mapear entre el modelo y los DTOs los productos que que ingresan (dentro de los post)
 * o salen del sistema.
 * @author andrmorales
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source= "productId", target = "productId"),
            @Mapping(source= "productName", target = "productName"),
            @Mapping(source= "type", target = "type"),
            @Mapping(source= "brand", target = "brand"),
            @Mapping(source= "color", target = "color"),
            @Mapping(source= "notes", target = "notes")
    })
    Product productoPostDTOtoProduct(ProductsDTO productsPostDTO);

    @InheritInverseConfiguration
    ProductsDTO productToProductoPostDTO(Product mProduct);
}
