package SocialMeli.mapper;

import SocialMeli.dto.request.NewPostDTO;
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
    public UserDTO userToUserdto(User user);
    public Product productDTOtoProduct(ProductDTO product);
    public ProductDTO productToProductDTO(Product product);
    public Post newPostDTOtoPost(NewPostDTO post);
    public PostDTO PostToPostDTO(Post post);
    public PromoPostDTO PostToPromoPostDTO(Post post);
    public PostListDTO postListToPostListDTO(int customerId , List<Post> postlist);
    public PromoPostListDTO promoPostListToPromoPostListDTO(Seller seller , List<Post> postlist);
    public FollowersCountDTO sellerToFollowersCountDTO(Seller seller);
    public FollowersListDTO sellerToFollowersListDTO(Seller seller, List<Customer> customers);
    public FollowedListDTO customerToFollowedListDTO(Customer customer, List<Seller> sellers);
    PromoCountDTO sellerToPromoCountDTO(Seller seller, int count);
}
