package SocialMeli.repository;

import SocialMeli.exception.RepeatedIdException;
import SocialMeli.exception.WrongIdException;
import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Seller;
import SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SocialRepository implements ISocialRepository{
    HashMap<Integer, Seller> sellerMap = new HashMap();
    HashMap<Integer, Customer> customerMap = new HashMap();
    HashMap<Integer, Post> postMap = new HashMap();

    public SocialRepository() {
        loadData();
    }

    @Override
    public Customer getCustomer(int customerId) {
        Customer customer = customerMap.get(customerId);
        if(customer == null){
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
        if(seller == null){
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
        if(postMap.containsKey(post.getId_post())){
            throw new RepeatedIdException();
        };
        sellerMap.get(post.getUser_id()).getPostIdSet().add(post.getId_post());
        postMap.put(post.getId_post(), post);
    }

    @Override
    public void newCustomer(Customer customer) {
        customerMap.put(customer.getUser_id(), customer);
    }

    @Override
    public void newSeller(Seller seller) {
        sellerMap.put(seller.getUser_id(), seller);
    }

    @Override
    public Post getPost(int postId) {
        Post post = postMap.get(postId);
        if(post == null){
            throw new WrongIdException("Post");
        }
        return post;
    }

    @Override
    public List<Post> getPosts(int userId) {
        return null;
    }

    private void loadData(){
        newCustomer(new Customer(1,"Customer one"));
        newCustomer(new Customer(2,"Customer two"));
        newCustomer(new Customer(3,"Customer three"));
        newSeller(new Seller(4,"Seller one"));
        newSeller(new Seller(5,"Seller two"));
        newSeller(new Seller(6,"Seller three"));
    }

}
