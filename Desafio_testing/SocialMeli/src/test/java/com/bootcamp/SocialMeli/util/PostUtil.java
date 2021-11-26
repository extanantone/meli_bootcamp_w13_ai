package com.bootcamp.SocialMeli.util;

import com.bootcamp.SocialMeli.dto.PostsDTO;
import com.bootcamp.SocialMeli.mapper.PostMater;
import com.bootcamp.SocialMeli.model.Detail;
import com.bootcamp.SocialMeli.model.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostUtil {

   public final static Detail detail1 = new Detail(1,"Zapato","calzado","Racer","Rojo","Edicion limitada");
   public  final static Post post1= new Post(3,1,LocalDate.of(2021,11,11),detail1,10,25000);

    public final static Detail detail2 = new Detail(1,"Zapato","calzado","Racer","Rojo","Edicion limitada");
    public final static Post post2= new Post(3,2,LocalDate.of(2021,11,23),detail1,10,25000);

    public final static  Detail detail3 = new Detail(1,"Zapato","calzado","Racer","Rojo","Edicion limitada");
    public final static Post post3= new Post(3,3,LocalDate.of(2021,11,5),detail1,10,25000);

    private final static List<Post> posts = new ArrayList<>();

    public static List<Post> posts(){

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }

    public static List<PostsDTO> postsDTOSOrderAsc(){

        List<PostsDTO> postsDTOS = new ArrayList<>();

        postsDTOS.add(PostMater.PostToPostsDTO(post3));
        postsDTOS.add(PostMater.PostToPostsDTO(post1));
        postsDTOS.add(PostMater.PostToPostsDTO(post2));


        return postsDTOS;
    }

    public static List<PostsDTO> postsDTOSOrderDesc(){

        List<PostsDTO> postsDTOS = new ArrayList<>();

        postsDTOS.add(PostMater.PostToPostsDTO(post2));
        postsDTOS.add(PostMater.PostToPostsDTO(post1));
        postsDTOS.add(PostMater.PostToPostsDTO(post3));


        return postsDTOS;
    }


}
