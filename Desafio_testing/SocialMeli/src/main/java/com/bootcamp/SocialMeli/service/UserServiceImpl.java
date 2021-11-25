package com.bootcamp.SocialMeli.service;
import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.entity.*;
import com.bootcamp.SocialMeli.exception.ExceptionSameUser;

import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<Buyer> getBuyerList() {
        return userRepository.getBuyersList();
    }
    @Override
    public List<Seller> getSellerList() {
        return userRepository.getSellersList();
    }
    @Override
    public Buyer findBuyerById(int userId) {
        return userRepository.findBuyerById(userId);
    }
    @Override
    public Seller findSellerById(int userId) {
        return userRepository.findSellerById(userId);
    }

    //US 0001 Poder realizar la acción de "Follow" (seguir) a un determinado vendedor
    @Override
    public boolean follow(int user_id, int user_id_to_follow) {
        Buyer buyer = findBuyerById(user_id);
        Seller seller = findSellerById(user_id_to_follow);
        if(user_id == user_id_to_follow){
                throw new ExceptionSameUser(Integer.toString(user_id));
        }
        userRepository.follow(buyer,seller);
        return true;
    }


    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @Override
    public FollowersCountDTO count(int user_id) {
        Seller seller = findSellerById(user_id);
        return new FollowersCountDTO(seller.getUserId(),seller.getUserName(), seller.getFollowers().size());
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @Override
    public FollowerListDTO followers(int user_id, String order) {
        Seller seller = findSellerById(user_id);
        List<UserDTO> buyers = new ArrayList<>();
        for(Buyer b: seller.getFollowers()){
            buyers.add(new UserDTO(b.getUserId(),b.getUserName()));
        }
        buyers = sortByNameUserDTO(order, buyers);
        return new FollowerListDTO(seller.getUserId(), seller.getUserName(), (ArrayList<UserDTO>) buyers);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @Override
    public FollowedListDTO followed(int user_id, String order) {
        Buyer buyer = findBuyerById(user_id);
        List<UserDTO> sellers = new ArrayList<>();
        for(Seller s: buyer.getFollowed()){
            sellers.add(new UserDTO(s.getUserId(),s.getUserName()));
        }
        sellers = sortByNameUserDTO(order, sellers);
        return new FollowedListDTO(buyer.getUserId(), buyer.getUserName(), (ArrayList<UserDTO>) sellers);
    }

    //US 0008: Ordenamiento alfabético ascendente y descendente
    private List<UserDTO> sortByNameUserDTO(String order, List<UserDTO> list) {
        if(order == null || order.equals("name_asc")){
            list = list.stream().sorted(Comparator.comparing(UserDTO::getUser_name)).collect(Collectors.toList());
        }else  if(order.equals("name_desc")){
            list = list.stream().sorted(Collections.reverseOrder(Comparator.comparing(UserDTO::getUser_name))).collect(Collectors.toList());
        }
        return list;
    }

    // US 0005: Dar de alta una nueva publicación
    @Override
    public boolean newPost(PostDTO post) {

        Seller seller = findSellerById(post.getUser_id());
        Product product = new Product(post.getDetail().getProduct_id(),post.getDetail().getProduct_name(),
                                post.getDetail().getType(),post.getDetail().getBrand(),post.getDetail().getColor(),post.getDetail().getNotes());
        LocalDate date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Post newPost = new Post(seller,post.getId_post(),product, date, post.getCategory(),post.getPrice(),false,0);
        userRepository.newPost(seller,newPost);
        return true;
    }

    /*
    US 0006: Obtener un listado de las publicaciones realizadas por los
    vendedores que un usuario sigue en las últimas dos semanas
     */
    @Override
    public PostFollowedListDTO followedSellersPost(int user_id, String order) {
        Buyer buyer = this.userRepository.findBuyerById(user_id);
        List<Seller> sellers = buyer.getFollowed();
        List<Post> recentPost = userRepository.getPostsList().stream().filter(post -> post.getDate()
                                            .isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList());
        PostFollowedListDTO posts = new PostFollowedListDTO(buyer.getUserId());
        for (Seller s : sellers){
            for (Post p: recentPost) {
                if(p.getUser().getUserId() == s.getUserId()){
                    posts.addPost(new PostListDTO(p.getIdPost(),p.getDate(),
                            new ProductDTO(p.getDetail().getProductId(),p.getDetail().getProductName(),
                                    p.getDetail().getType(),p.getDetail().getBrand(),p.getDetail().getColor(),
                                    p.getDetail().getNotes()),p.getCategory(),p.getPrice()));
                }}}

        // US 0009: Ordenamiento por fecha ascendente y descendente
        if(order == null || order.equals("name_asc")){
            posts.getPosts().sort(Comparator.comparing(PostListDTO::getDate));
        }else if(order.equals("name_desc")){
            posts.getPosts().sort(Comparator.comparing(PostListDTO::getDate).reversed());
        }
        return posts;
    }

    //US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.
    @Override
    public boolean unFollow(int user_id, int user_id_to_unfollow) {
        Buyer buyer = findBuyerById(user_id);
        Seller seller = findSellerById(user_id_to_unfollow);
        userRepository.unFollow(buyer,seller);
        return true;
    }
}


