package SocialMeli.mapper;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.request.NewUserDTO;
import SocialMeli.dto.response.*;
import SocialMeli.dto.response.count.FollowersCountDTO;
import SocialMeli.dto.response.count.PromoCountDTO;
import SocialMeli.dto.response.list.FollowedListDTO;
import SocialMeli.dto.response.list.FollowersListDTO;
import SocialMeli.dto.response.list.PostListDTO;
import SocialMeli.dto.response.list.PromoPostListDTO;
import SocialMeli.model.*;

import java.util.List;

public interface ISocialMapper {
    UserDTO userToUserdto(User user);

    User newUserDTOtoUser(NewUserDTO user);

    Product productDTOtoProduct(ProductDTO product);

    ProductDTO productToProductDTO(Product product);

    Post newPostDTOtoPost(NewPostDTO post);

    PostDTO PostToPostDTO(Post post);

    PromoPostDTO PostToPromoPostDTO(Post post);

    PostListDTO postListToPostListDTO(int customerId, List<Post> postlist);

    PromoPostListDTO promoPostListToPromoPostListDTO(Seller seller, List<Post> postlist);

    FollowersCountDTO sellerToFollowersCountDTO(Seller seller);

    FollowersListDTO sellerToFollowersListDTO(Seller seller, List<Customer> customers);

    FollowedListDTO customerToFollowedListDTO(Customer customer, List<Seller> sellers);

    PromoCountDTO sellerToPromoCountDTO(Seller seller, int count);
}
