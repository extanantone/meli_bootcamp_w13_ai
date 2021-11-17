package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
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


}
