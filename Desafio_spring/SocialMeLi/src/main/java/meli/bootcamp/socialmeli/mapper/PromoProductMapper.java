package meli.bootcamp.socialmeli.mapper;

import meli.bootcamp.socialmeli.dto.ProductsPostByUserDTO;
import meli.bootcamp.socialmeli.dto.ProductsPostDTO;
import meli.bootcamp.socialmeli.dto.ProductsPromoPostDTO;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PromoProductMapper {
    @Mappings({
            @Mapping(source= "user_id", target = "userId"),
            @Mapping(source= "id_post", target = "postId"),
            @Mapping(source= "date", target = "date", dateFormat = "dd-MM-yyyy"),
            @Mapping(source= "detail", target = "detail"),
            @Mapping(source= "category", target = "category"),
            @Mapping(source= "price", target = "price"),
            @Mapping(source= "has_promo", target = "hasPromo"),
            @Mapping(source= "discount", target = "discount")
    })
    PromoPost productoPromoPostDTOtoPromoPost(ProductsPromoPostDTO productsPostDTO);

    @InheritInverseConfiguration
    ProductsPromoPostDTO promoPostToproductoPromoPostDTO(PromoPost mPost);

    @Mappings(value = {
            @Mapping(source= "postId", target = "id_post"),
            @Mapping(source= "date", target = "date"),
            @Mapping(source= "detail", target = "detail"),
            @Mapping(source= "category", target = "category"),
            @Mapping(source= "price", target = "price")
    })
    ProductsPostByUserDTO postToProductsPostByUserDTO(Post productsPostDTO);
}