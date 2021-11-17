package meli.bootcamp.socialmeli.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.model.PromoPost;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase para mapear entre el modelo y los DTOs los promo post que ingresan o salen del sistema.
 * @author andrmorales
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PromoProductMapper {
    @Mappings({
            @Mapping(source= "userId", target = "userId"),
            @Mapping(source= "idPost", target = "postId"),
            @Mapping(source= "date", target = "date", dateFormat = "dd-MM-yyyy"),
            @Mapping(source= "detail", target = "detail"),
            @Mapping(source= "category", target = "category"),
            @Mapping(source= "price", target = "price"),
            @Mapping(source= "hasPromo", target = "hasPromo"),
            @Mapping(source= "discount", target = "discount")
    })
    PromoPost productoPromoPostDTOtoPromoPost(ProductsPromoPostDTO productsPostDTO);

    @InheritInverseConfiguration
    @Mapping(source = "postId", target = "idPost")
    PromoPostBaseDTO promoPostToPromoPostDTO(PromoPost mPost);

}