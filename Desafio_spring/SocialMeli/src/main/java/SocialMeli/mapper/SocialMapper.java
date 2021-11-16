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
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SocialMapper implements ISocialMapper {
    @Override
    public UserDTO userToUserdto(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    @Override
    public User newUserDTOtoUser(NewUserDTO user) {
        return user.isSeller() ? new Seller(user.getUserId(), user.getUserName())
                : new Customer(user.getUserId(), user.getUserName());
    }

    @Override
    public Product productDTOtoProduct(ProductDTO product) {
        return new Product(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    @Override
    public ProductDTO productToProductDTO(Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    @Override
    public Post newPostDTOtoPost(NewPostDTO post) {
        return new Post(
                post.getUserId(),
                post.getIdPost(),
                post.getDate(),
                productDTOtoProduct(post.getDetail()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    @Override
    public PostDTO PostToPostDTO(Post post) {
        return new PostDTO(
                post.getIdPost(),
                post.getDate(),
                productToProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice()
        );
    }

    @Override
    public PromoPostDTO PostToPromoPostDTO(Post post) {
        return new PromoPostDTO(
                post.getIdPost(),
                post.getDate(),
                productToProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    @Override
    public PostListDTO postListToPostListDTO(int customerId, List<Post> postlist) {
        return new PostListDTO(
                customerId,
                postlist.stream().map(this::PostToPostDTO).collect(Collectors.toList())
        );
    }

    @Override
    public PromoPostListDTO promoPostListToPromoPostListDTO(Seller seller, List<Post> postlist) {
        return new PromoPostListDTO(
                seller.getUserId(),
                seller.getUserName(),
                postlist.stream().map(this::PostToPromoPostDTO).collect(Collectors.toList())
        );
    }

    @Override
    public FollowersCountDTO sellerToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                seller.getFollowersIdSet().size());
    }

    @Override
    public FollowersListDTO sellerToFollowersListDTO(Seller seller, List<Customer> customers) {
        return new FollowersListDTO(
                seller.getUserId(),
                seller.getUserName(),
                customers.stream().map(this::userToUserdto).collect(Collectors.toList()));
    }

    @Override
    public FollowedListDTO customerToFollowedListDTO(Customer customer, List<Seller> sellers) {
        return new FollowedListDTO(
                customer.getUserId(),
                customer.getUserName(),
                sellers.stream().map(this::userToUserdto).collect(Collectors.toList()));
    }

    @Override
    public PromoCountDTO sellerToPromoCountDTO(Seller seller, int count) {
        return new PromoCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                count);
    }
}
