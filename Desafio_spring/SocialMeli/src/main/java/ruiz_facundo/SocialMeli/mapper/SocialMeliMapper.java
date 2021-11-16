package ruiz_facundo.SocialMeli.mapper;

import org.springframework.stereotype.Component;
import ruiz_facundo.SocialMeli.dto.*;
import ruiz_facundo.SocialMeli.model.Post;
import ruiz_facundo.SocialMeli.model.RetailProduct;
import ruiz_facundo.SocialMeli.model.Promotion;
import ruiz_facundo.SocialMeli.model.User;

@Component
public class SocialMeliMapper {
    public UserDTO UserToUserDTO(User inUser) {
        return new UserDTO(inUser.getId(), inUser.getName());
    }

    public Post RequestPostDTOToPost (RequestPostDTO req) {
        RetailProduct outProd = this.RetailProductDTOToRetailProduct(req.getDetail());
        return new Post(req.getIdPost(), req.getDate(), outProd, req.getCategory(),
                req.getPrice());
    }

    private RetailProduct RetailProductDTOToRetailProduct(RetailProductDTO detail) {
        return new RetailProduct(detail.getProductId(), detail.getProductName(),
                detail.getType(), detail.getBrand(), detail.getColor(), detail.getNotes());
    }

    public PostDTO PostToPostDTO (Post post) {
        RetailProductDTO outProdDTO = this.RetailProductToRetailProductDTO(post.getProductOnSale());
        return new PostDTO(post.getId(), post.getPublishDate(), outProdDTO, post.getCategory(),
                post.getPrice());
    }

    private RetailProductDTO RetailProductToRetailProductDTO(RetailProduct detail) {
        return new RetailProductDTO(detail.getId(), detail.getName(), detail.getType(),
                detail.getBrand(), detail.getColor(), detail.getNotes());
    }

    public Promotion RequestPromotionDTOToPromotion(RequestPromotionDTO req) {
        RetailProduct outProd = this.RetailProductDTOToRetailProduct(req.getDetail());
        return new Promotion(req.getIdPost(), req.getDate(), outProd, req.getCategory(),
                req.getPrice(), req.isHasPromo(), req.getDiscount());
    }

    public PromotionDTO PromotionToPromotionDTO(Post post) {
        RetailProductDTO outProd = this.RetailProductToRetailProductDTO(post.getProductOnSale());
        return new PromotionDTO(post.getId(), post.getPublishDate(), outProd,
                post.getCategory(), post.getPrice(), post.isHasPromo(), post.getDiscount());
    }
}
