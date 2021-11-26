package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.exception.postExceptions.ExistingPostException;
import com.socialMeli.SocialMeli.exception.postExceptions.NotFoundIdPostException;
import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.postDTO.PromoPostInDTO;
import com.socialMeli.SocialMeli.postDTO.PromoPostListDTO;
import com.socialMeli.SocialMeli.postDTO.PromoProductsCountDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImp implements PostRepository{
    private Map<Integer,Post> postList=new HashMap<>();

    @Override
    public Post create(Post post) {
        if(post.getId_post()==null){
            throw new NotFoundIdPostException();
        }
        if(postList.get(post.getId_post())!=null){
            throw new ExistingPostException();
        }
        postList.put(post.getId_post(),post);
        return post;
    }

    @Override
    public Post create(PromoPostInDTO promoPostDTO) {
        if(promoPostDTO.getId_post()==null){
            throw new NotFoundIdPostException();
        }
        if(postList.get(promoPostDTO.getId_post())!=null){
            throw new ExistingPostException();
        }
        Post post=new Post(promoPostDTO);
        postList.put(post.getId_post(),post);
        return post;
    }

    @Override
    public PostFollowedDTO productListFollowed(User user) {
        List<Post> productListFollowed=new ArrayList<>();
        LocalDate fechaActual= LocalDate.now();
        for (Integer followed_id: user.getFollowing()) {
            List<Post> list1 =postList.values().stream().collect(Collectors.toList());
            productListFollowed.addAll(list1.stream().filter(post -> post.getUser_id() == followed_id && post.getDate().isAfter(fechaActual.minusDays(14))).collect(Collectors.toList()));//
        }
        Collections.sort(productListFollowed, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        PostFollowedDTO postFollowedDTO=new PostFollowedDTO(user.getId(),productListFollowed);
        return postFollowedDTO;
    }

    @Override
    public PromoProductsCountDTO promoProductsCount(User user) {
        List<Post> list1=postList.values().stream().filter(posts-> posts.getUser_id()==user.getId() && posts.getHas_promo()==true).collect(Collectors.toList());
        PromoProductsCountDTO promo_count=new PromoProductsCountDTO(user.getId(), user.getUsername(), list1.size());
        return promo_count;
    }

    @Override
    public PromoPostListDTO promoProductsList(User user) {
        List<Post> list1=postList.values().stream().filter(posts-> posts.getUser_id()==user.getId() && posts.getHas_promo()==true).collect(Collectors.toList());
        PromoPostListDTO promoPostListDTO=new PromoPostListDTO(user.getId(),user.getUsername(),list1);
        return promoPostListDTO;
    }

    public Map<Integer, Post> getPostList() {
        return postList;
    }

    public void setPostList(Map<Integer, Post> postList) {
        this.postList = postList;
    }
}
