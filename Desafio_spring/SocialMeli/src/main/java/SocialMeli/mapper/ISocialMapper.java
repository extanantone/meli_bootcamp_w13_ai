package SocialMeli.mapper;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.response.*;
import SocialMeli.model.*;

import java.util.List;

public interface ISocialMapper {
    public UserDTO userToUserdto(User user);
    public Product productDTOtoProduct(ProductDTO product);
    public ProductDTO productToProductDTO(Product product);
    public Post newPostDTOtoPost(NewPostDTO post);
    public PostDTO PostToPostDTO(Post post);
    public FollowersCountDTO sellerToFollowersCountDTO(Seller seller);
    public FollowersListDTO sellerToFollowersListDTO(Seller seller, List<Customer> customers);
    public FollowedListDTO customerToFollowedListDTO(Customer customer, List<Seller> sellers);
}
