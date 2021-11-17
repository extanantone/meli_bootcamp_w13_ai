package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.exception.postExceptions.ExistingPostException;
import com.socialMeli.SocialMeli.exception.postExceptions.NotFoundIdPostException;
import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.postDTO.PromoPostDTO;
import com.socialMeli.SocialMeli.postDTO.PromoProductsCountDTO;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Post create(PromoPostDTO promoPostDTO) {
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
        for (Integer followed_id: user.getFollowing()) {
            List<Post> list1 =postList.values().stream().collect(Collectors.toList());
            productListFollowed.addAll(list1.stream().filter(post -> post.getUser_id() == followed_id).collect(Collectors.toList()));// = Stream.concat(list1.stream(),productListFollowed.stream()).collect(Collectors.toList());
        }
        Collections.sort(productListFollowed, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        //filtrar por dos semanas

        PostFollowedDTO postFollowedDTO=new PostFollowedDTO(user.getId(),productListFollowed);
        return postFollowedDTO;
    }

    @Override
    public PromoProductsCountDTO promoProductsCount(User user) {
        List<Post> list1=postList.values().stream().filter(posts-> posts.getUser_id()==user.getId() && posts.getHas_promo()==true).collect(Collectors.toList());
        PromoProductsCountDTO promo_count=new PromoProductsCountDTO(user.getId(), user.getUsername(), list1.size());
        return promo_count;
    }
}
