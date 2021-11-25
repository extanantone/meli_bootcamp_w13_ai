package com.example.socialmeli.demo.repository;

import com.example.socialmeli.demo.comparator.AscendingPostDateSorter;
import com.example.socialmeli.demo.comparator.AscendingProductNameSorter;
import com.example.socialmeli.demo.comparator.AscendingUserName;
import com.example.socialmeli.demo.comparator.DescendingPostDateSorter;
import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.model.PromoPost;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

@Repository
public class PostRepository implements IPostRepository {

    private List<Post> publicaciones = new ArrayList<>();


    @Override
    public Post createPost(Post p) {

        //PromoPost pr = new PromoPost();
        //publicaciones.add(pr);

        publicaciones.add(p);
        return p;
    }

    @Override
    public List<Post> getPostsFromFollowedUsersSinceTwoWeeks(int userId, String order) {

        List<Post> response = new ArrayList<>();

        // Restamos dos semanas a la fecha actual
        LocalDate dateFromTwoWeeks = LocalDate.now().minusWeeks(2);

        response = publicaciones.stream().filter(x -> x.getUserId() == userId)
                .filter(y -> y.getDate().isAfter(dateFromTwoWeeks) )
                .sorted(new DescendingPostDateSorter())
                .collect(Collectors.toList());

        if(order != null)
            if(order.equals("date_asc"))
               reverse(response);

        return response;

    }

    @Override
    public int countPromoPostOfUser(int userId) {

        int promoPostCount = 0;

        List<Post> listOfPromoPost = publicaciones.stream().filter(p -> p.getUserId() == userId && p.hasPromo() == true).collect(Collectors.toList());
        promoPostCount = listOfPromoPost.size();

        return promoPostCount;

    }

    @Override
    public List<Post> getPromoPostOfUser(int userId) {

        List <Post> response = new ArrayList<>();

        response = publicaciones.stream().filter(x -> x.getUserId() == userId)
                .filter(p -> p.getUserId() == userId && p.hasPromo() == true)
                .sorted(new AscendingProductNameSorter())
                .collect(Collectors.toList());



        return response;

    }


}
