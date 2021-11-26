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


//        public Post(int postId, LocalDate date, Product detail, int category, double price) {


       /* private int productId;
        private String productName, type, brand, color, notes;*/

        Product product = new Product(1,"Aproducto", "type1"
                ,"brand1","blue","nothing");

        Product product2 = new Product(1,"Aproducto", "type1",
                "brand1","blue","nothing");

        Post post = new Post(1,LocalDate.now().minusDays(4),product,1,100);
        Post post2 = new Post(2,LocalDate.now().minusDays(4),product,1,100);

        posts.add(post);
        posts.add(post2);
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


}
