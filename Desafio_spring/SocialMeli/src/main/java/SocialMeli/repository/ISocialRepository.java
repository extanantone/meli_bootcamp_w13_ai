package SocialMeli.repository;

import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Seller;
import SocialMeli.model.User;

import java.time.LocalDate;
import java.util.List;

public interface ISocialRepository {
    Customer getCustomer(int customerId);

    List<Seller> getFollowed(int customerId);

    Seller getSeller(int sellerId);

    List<Customer> getFollowers(int sellerId);

    void newPost(Post post);

    void newCustomer(Customer customer);

    void newSeller(Seller seller);

    void newUser(User user);

    Post getPost(int postId);

    List<Post> getCustomerPosts(int userId);

    List<Post> getSellerPosts(int userId);

    List<Post> getSellerPromoPosts(int userId);

    List<Post> getCustomerPostsByDate(int userId, LocalDate init, LocalDate fin);
}
