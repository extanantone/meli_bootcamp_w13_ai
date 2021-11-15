package SocialMeli.repository;

import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Seller;
import SocialMeli.model.User;

import java.time.LocalDate;
import java.util.List;

public interface ISocialRepository {
    public Customer getCustomer(int customerId);
    public List<Seller> getFollowed(int customerId);
    public Seller getSeller(int sellerId);
    public List<Customer> getFollowers(int sellerId);
    public void newPost(Post post);
    public void newCustomer(Customer customer);
    public void newSeller(Seller seller);
    public Post getPost(int postId);
    public List<Post> getCustomerPosts(int userId);
    public List<Post> getCustomerPostsByDate(int userId , LocalDate init, LocalDate fin);
}
