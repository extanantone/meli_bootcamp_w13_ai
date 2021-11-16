package SocialMeli.repository;

import SocialMeli.exception.RepeatedIdException;
import SocialMeli.exception.WrongIdException;
import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Seller;
import SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SocialRepository implements ISocialRepository {
    HashMap<Integer, Seller> sellerMap = new HashMap<>();
    HashMap<Integer, Customer> customerMap = new HashMap<>();
    HashMap<Integer, Post> postMap = new HashMap<>();

    public SocialRepository() {
        loadData();
    }

    @Override
    public Customer getCustomer(int customerId) {
        Customer customer = customerMap.get(customerId);
        if (customer == null) {
            throw new WrongIdException("Customer");
        }
        return customer;
    }

    @Override
    public List<Seller> getFollowed(int customerId) {
        return getCustomer(customerId).getFollowedsIdSet().stream()
                .map(this::getSeller)
                .collect(Collectors.toList());
    }

    @Override
    public Seller getSeller(int sellerId) {
        Seller seller = sellerMap.get(sellerId);
        if (seller == null) {
            throw new WrongIdException("Seller");
        }
        return seller;
    }

    @Override
    public List<Customer> getFollowers(int sellerId) {
        return getSeller(sellerId).getFollowersIdSet().stream()
                .map(this::getCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public void newPost(Post post) {
        if (postMap.containsKey(post.getIdPost())) {
            throw new RepeatedIdException();
        }
        Seller seller = sellerMap.get(post.getUserId());
        if (seller == null) {
            throw new WrongIdException("Seller");
        }
        seller.getPostIdSet().add(post.getIdPost());
        postMap.put(post.getIdPost(), post);
    }

    @Override
    public void newCustomer(Customer customer) {
        customerMap.put(customer.getUserId(), customer);
    }

    @Override
    public void newSeller(Seller seller) {
        sellerMap.put(seller.getUserId(), seller);
    }

    @Override
    public void newUser(User user) {
        if (user.getClass() == Customer.class) {
            if (customerMap.containsKey(user.getUserId())) {
                throw new RepeatedIdException();
            }
            customerMap.put(user.getUserId(), new Customer(user));
        } else {
            if (sellerMap.containsKey(user.getUserId())) {
                throw new RepeatedIdException();
            }
            sellerMap.put(user.getUserId(), new Seller(user));
        }
    }

    @Override
    public Post getPost(int postId) {
        Post post = postMap.get(postId);
        if (post == null) {
            throw new WrongIdException("Post");
        }
        return post;
    }

    @Override
    public List<Post> getCustomerPosts(int userId) {
        Customer customer = getCustomer(userId);
        List<Post> postList = new ArrayList<>();
        for (int id : customer.getFollowedsIdSet()) {
            postList.addAll(getSeller(id).getPostIdSet().stream()
                    .map(this::getPost).collect(Collectors.toList()));
        }
        return postList;
    }

    @Override
    public List<Post> getSellerPosts(int userId) {
        Seller seller = getSeller(userId);
        return seller.getPostIdSet().stream()
                .map(this::getPost).collect(Collectors.toList());
    }


    @Override
    public List<Post> getSellerPromoPosts(int userId) {
        return getSellerPosts(userId).stream().filter(Post::isHasPromo).collect(Collectors.toList());
    }

    @Override
    public List<Post> getCustomerPostsByDate(int userId, LocalDate init, LocalDate fin) {
        return getCustomerPosts(userId).stream().filter(post -> !post.getDate().isBefore(init)
                && !post.getDate().isAfter(fin)).collect(Collectors.toList());
    }

    private void loadData() {
        newCustomer(new Customer(1, "Customer b"));
        newCustomer(new Customer(2, "Customer c"));
        newCustomer(new Customer(3, "Customer a"));
        newSeller(new Seller(4, "Seller b"));
        newSeller(new Seller(5, "Seller c"));
        newSeller(new Seller(6, "Seller a"));
    }

}
