package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    protected int id = 0;
    protected Map<Integer, Post> posts = new HashMap<>();

    public PostRepository(){
        Post post = new Post();
        post.setId(91);
        post.setSellerId(3);
        post.setDate(LocalDate.now());
        post.setPrice(1000);
        post.setCategory(1);
        post.setHas_promo(true);
        post.setDiscount(5);
        Product product = new Product();
        product.setId(90);
        product.setName("Producto");
        product.setColor("Negro");
        product.setNotes("");
        product.setBrand("Marca");
        product.setType("Tipo");
        post.setDetail(product);

        posts.put(91, post);
    }

    @Override
    public Post getById(int id) {
        return this.posts.get(id);
    }

    @Override
    public boolean create(Post post) {
        this.posts.put(post.getId(), post);
        return true;
    }

    @Override
    public List<Post> getByUserId(int userId, LocalDate date) {
        List<Post> posts = this.posts.values().stream().filter(post -> post.getSellerId() == userId && post.getDate().isAfter(date)).collect(Collectors.toList());
        return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPromosByUser(int userId) {
        List<Post> posts = this.posts.values().stream().filter(post -> post.getSellerId() == userId && post.isHas_promo()).collect(Collectors.toList());
        return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
    }
}
