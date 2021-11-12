package ruiz_facundo.SocialMeli.mapper;

import org.springframework.stereotype.Component;
import ruiz_facundo.SocialMeli.dto.*;
import ruiz_facundo.SocialMeli.model.Post;
import ruiz_facundo.SocialMeli.model.PostProduct;
import ruiz_facundo.SocialMeli.model.PromoPost;
import ruiz_facundo.SocialMeli.model.User;

@Component
public class SocialMeliMapper {
    public UserDTO userToUserDTO (User inUser) {
        return new UserDTO(inUser.getId(), inUser.getName());
    }

    public Post RequestPostDTOToPost (RequestPostDTO req) {
        PostProduct outProd = this.PostProductDTOToPostProduct(req.getDetail());
        return new Post(req.getIdPost(), req.getDate(), outProd, req.getCategory(),
                req.getPrice());
    }

    private PostProduct PostProductDTOToPostProduct (PostProductDTO detail) {
        return new PostProduct(detail.getProductId(), detail.getProductName(),
                detail.getType(), detail.getBrand(), detail.getColor(), detail.getNotes());
    }

    public PostDTO PostToPostDTO (Post post) {
        PostProductDTO outProdDTO = this.PostProductToPostProductDTO(post.getProductOnSale());
        return new PostDTO(post.getId(), post.getPublishDate(), outProdDTO, post.getCategory(),
                post.getPrice());
    }

    private PostProductDTO PostProductToPostProductDTO (PostProduct detail) {
        return new PostProductDTO(detail.getId(), detail.getName(), detail.getType(),
                detail.getBrand(), detail.getColor(), detail.getNotes());
    }

    public PromoPost RequestPromoPostDTOToPromoPost (RequestPromoPostDTO req) {
        PostProduct outProd = this.PostProductDTOToPostProduct(req.getDetail());
        return new PromoPost(req.getIdPost(), req.getDate(), outProd, req.getCategory(),
                req.getPrice(), req.isHasPromo(), req.getDiscount());
    }
}
