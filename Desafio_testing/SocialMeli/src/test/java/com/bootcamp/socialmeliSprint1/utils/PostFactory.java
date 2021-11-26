package com.bootcamp.socialmeliSprint1.utils;


import com.bootcamp.socialmeliSprint1.dto.response.post.PostOutDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.ProductDTO;
import com.bootcamp.socialmeliSprint1.entitiy.Post;
import com.bootcamp.socialmeliSprint1.entitiy.Product;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostFactory {

    ModelMapper mm = new ModelMapper();

    public List<Post> getListOfTwoValidPosts(){

        List<Post> posts = new ArrayList<>();

        Product product = new Product(1,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product2 = new Product(2,"Aproducto", "type1",
                "brand1","blue","nothing");

        Post post = new Post(1,LocalDate.now().minusDays(4),product,1,100);
        Post post2 = new Post(2,LocalDate.now().minusDays(5),product,1,100);

        posts.add(post);
        posts.add(post2);

        return posts;
    }

    public List<Post> getListOfTwoValidPostsReverse(){

        List<Post> posts = new ArrayList<>();

        Product product = new Product(1,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product2 = new Product(2,"Aproducto", "type1",
                "brand1","blue","nothing");

        Post post = new Post(1,LocalDate.now().minusDays(4),product,1,100);
        Post post2 = new Post(2,LocalDate.now().minusDays(5),product,1,100);

        posts.add(post2);
        posts.add(post);

        return posts;
    }

    public List<PostOutDTO> getCastListPostToPostOutDTO(List<Post> allPost){

        List<PostOutDTO> postsResponse = new ArrayList<>();

        allPost.stream().forEach(post -> {

            ProductDTO detail = mm.map(post.getDetail(),ProductDTO.class);
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            PostOutDTO postOutDTO = new PostOutDTO(post.getPostId(), post.getDate().format(dt),
                    detail, post.getCategory(),post.getPrice());

            postsResponse.add(postOutDTO);

        });
        return postsResponse;

    }

    public List<Post> getListOfTwoValidPostsAndTwoPostsOfTreeWeeksAgo(){

        List<Post> posts = new ArrayList<>();

        Product product = new Product(1,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product2 = new Product(2,"Aproducto", "type1",
                "brand1","blue","nothing");

        Product product3 = new Product(3,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product4 = new Product(4,"Aproducto", "type1",
                "brand1","blue","nothing");


        Post post = new Post(1,LocalDate.now().minusDays(4),product,1,100);
        Post post2 = new Post(2,LocalDate.now().minusDays(5),product,1,100);


        Post post3 = new Post(3,LocalDate.now().minusWeeks(3),product,1,100);
        Post post4 = new Post(4,LocalDate.now().minusWeeks(4),product,1,100);

        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        return posts;
    }

    public List<Post> getListOfTwoValidPostsAndTwoPostsOfTreeWeeksAgoReverse(){

        List<Post> posts = new ArrayList<>();

        Product product = new Product(1,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product2 = new Product(2,"Aproducto", "type1",
                "brand1","blue","nothing");

        Product product3 = new Product(3,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product4 = new Product(4,"Aproducto", "type1",
                "brand1","blue","nothing");


        Post post = new Post(1,LocalDate.now().minusDays(4),product,1,100);
        Post post2 = new Post(2,LocalDate.now().minusDays(5),product,1,100);


        Post post3 = new Post(3,LocalDate.now().minusWeeks(3),product,1,100);
        Post post4 = new Post(4,LocalDate.now().minusWeeks(4),product,1,100);

        /**
         * change pos
         */
        posts.add(post2);

        posts.add(post);



        posts.add(post3);
        posts.add(post4);

        return posts;
    }


}
