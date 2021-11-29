package com.example.socialmeli.unit;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class SocialMeliUnitUtils {

    public Optional<User> getDefaultUser(Integer idUser) {
        User generatedUser = new User();
        generatedUser.setFollowersId(new ArrayList<>());
        generatedUser.setUserId(idUser);
        switch(idUser) {
            case 1:
                generatedUser.setUserName("Leon Comprador");
                break;
            case 2:
                generatedUser.setUserName("Juan Comprador");
                break;
            case 3:
                generatedUser.setUserName("Manuel Vendedor");
                break;
            case 4:
                generatedUser.setUserName("Pedro Vendedor");
                break;
        }
        return Optional.of(generatedUser);
    }

    public Post genDefaultRecentPost(Integer userId, Integer idPost, String productName) {
        Post outPost = new Post();
        outPost.setUserId(userId);
        outPost.setIdPost(idPost);
        outPost.setDate(new Date());
        outPost.setDetail(this.genDefaultProduct(productName));
        outPost.setCategory(1);
        outPost.setPrice(42.0);
        outPost.setHasPromo(false);
        outPost.setDiscount(0.0);
        return outPost;
    }

    private Product genDefaultProduct(String productName) {
        Product outDetail = new Product();
        outDetail.setProductId(1);
        outDetail.setProductName(productName);
        outDetail.setBrand("Razer");
        outDetail.setColor("Red and Black");
        outDetail.setType("Gamer");
        outDetail.setNotes("Deluxe Edition");
        return outDetail;
    }

    public Post genDefaultRecentPromo(Integer userId, Integer idPost, String productName, Double discount) {
        Post outPost = this.genDefaultRecentPost(userId, idPost, productName);
        outPost.setHasPromo(true);
        outPost.setDiscount(discount);
        return outPost;
    }

    boolean areUsersEqual(User firstUser, User secondUser) {
        boolean equals = firstUser.getUserId().equals(secondUser.getUserId());
        equals = equals && firstUser.getUserName().equals(secondUser.getUserName());
        equals = equals && firstUser.getFollowersId().equals(secondUser.getFollowersId());
        return equals;
    }

    public boolean arePostsEqual(Post firstPost, Post secondPost) {
        boolean equals = firstPost.getUserId().equals(secondPost.getUserId());
        equals = equals && firstPost.getIdPost().equals(secondPost.getIdPost());
        equals = equals && firstPost.getDate().equals(secondPost.getDate());
        equals = equals && this.areProductsEqual(firstPost.getDetail(), secondPost.getDetail());
        equals = equals && firstPost.getCategory().equals(secondPost.getCategory());
        equals = equals && firstPost.getPrice().equals(secondPost.getPrice());
        equals = equals && firstPost.isHasPromo() == secondPost.isHasPromo();
        equals = equals && firstPost.getDiscount().equals(secondPost.getDiscount());
        return equals;
    }

    public boolean areProductsEqual(Product firstProduct, Product secondProduct) {
        boolean equals = firstProduct.getProductId().equals(secondProduct.getProductId());
        equals = equals && firstProduct.getProductName().equals(secondProduct.getProductName());
        equals = equals && firstProduct.getType().equals(secondProduct.getType());
        equals = equals && firstProduct.getBrand().equals(secondProduct.getBrand());
        equals = equals && firstProduct.getColor().equals(secondProduct.getColor());
        equals = equals && firstProduct.getNotes().equals(secondProduct.getNotes());
        return equals;
    }

    public Post genDefaultAncientPost(Integer userId, Integer idPost, String productName)
            throws ParseException {
        Post outPost = this.genDefaultRecentPost(userId, idPost, productName);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        outPost.setDate(format.parse("01-01-1998"));
        return outPost;
    }

    public Post genNotSoRecentPost(Integer userId, Integer idPost, String productName,
                                   Integer daysToSubtract) {
        Post outPost = this.genDefaultRecentPost(userId, idPost, productName);
        LocalDate firstDate = LocalDate.now().minusDays(daysToSubtract);
        outPost.setDate(Date.from(firstDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        return outPost;
    }
}
