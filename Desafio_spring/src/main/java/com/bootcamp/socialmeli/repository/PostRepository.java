package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOPublishPost;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.utils.ComparatorPublishAsc;
import com.bootcamp.socialmeli.utils.ComparatorPublishDesc;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{

    public static List<Post> postList = new ArrayList<Post>();

    @Override
    public boolean addPost(Post post) {
        int count = postList.size();
        postList.add(post);

        if(postList.size() <= count)
            return false;

        return true;
    }

    @Override
    public List<Post> getPost(int idUser) {

        List<Post> listPosts = new ArrayList<Post>();

        LocalDate DateMinusTwoWeeks = LocalDate.now();
        DateMinusTwoWeeks = DateMinusTwoWeeks.minusWeeks(2);

        for (Post p : postList) {
            if(p.getUserId() == idUser && p.getDate().isAfter(DateMinusTwoWeeks))
                listPosts.add(p);
        }

        return listPosts;

    }

    @Override
    public List<DTOPublishPost> orderPosts(List<DTOPublishPost> posts, String order) {
        if(order.equals("date_asc"))
            return posts.stream().sorted(new ComparatorPublishAsc()).collect(Collectors.toList());
        return posts.stream().sorted(new ComparatorPublishDesc()).collect(Collectors.toList());

    }

    @Override
    public List<Post> getPromoPost(int userId) {

        List<Post> postListAux = new ArrayList<>();

        for (Post p : postList) {
            if(p.getHasPromo() && p.getUserId() == userId)
                postListAux.add(p);
        }

        return postListAux;
    }


}
