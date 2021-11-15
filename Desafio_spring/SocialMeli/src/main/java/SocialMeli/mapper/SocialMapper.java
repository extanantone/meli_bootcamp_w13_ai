package SocialMeli.mapper;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.response.*;
import SocialMeli.model.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SocialMapper implements ISocialMapper {
    @Override
    public UserDTO userToUserdto(User user) {
        return new UserDTO(user.getUser_id(), user.getUser_name());
    }

    @Override
    public Product productDTOtoProduct(ProductDTO product) {
        return new Product(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    @Override
    public ProductDTO productToProductDTO(Product product) {
        return new ProductDTO(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    @Override
    public Post newPostDTOtoPost(NewPostDTO post) {
        return new Post(
                post.getUser_id(),
                post.getId_post(),
                post.getDate(),
                productDTOtoProduct(post.getDetail()),
                post.getCategory(),
                post.getPrice()
        );
    }

    @Override
    public PostDTO PostToPostDTO(Post post) {
        return new PostDTO(
                post.getId_post(),
                post.getDate(),
                productToProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice()
        );
    }

    @Override
    public PostListDTO postListToPostListDTO(int customerId ,List<Post> postlist) {
        return new PostListDTO(
                customerId,
                postlist.stream().map(this::PostToPostDTO).collect(Collectors.toList())
        );
    }

    @Override
    public FollowersCountDTO sellerToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(
                seller.getUser_id(),
                seller.getUser_name(),
                seller.getFollowersIdSet().size());
    }

    @Override
    public FollowersListDTO sellerToFollowersListDTO(Seller seller, List<Customer> customers) {
        return new FollowersListDTO(
                seller.getUser_id(),
                seller.getUser_name(),
                customers.stream().map(this::userToUserdto).collect(Collectors.toList()));
    }

    @Override
    public FollowedListDTO customerToFollowedListDTO(Customer customer, List<Seller> sellers) {
        return new FollowedListDTO(
                customer.getUser_id(),
                customer.getUser_name(),
                sellers.stream().map(this::userToUserdto).collect(Collectors.toList()));
    }
}
