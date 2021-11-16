package com.Sprint1.SocialMeli.Repository;

import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    HashMap<Integer, Post> basePosts = new HashMap<>();

    public PostRepositoryImpl() {
        cargarPostsDesdeJson();
    }

    private void cargarPostsDesdeJson(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:Posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Post post : posts) {
            basePosts.put(post.getIdPost(), post);
        }

    }

    //TODO: BOrrar
    public HashMap<Integer, Post> pruebaPost(){
        return basePosts;
    }

    @Override
    public Boolean crearPublicacion(Post publicacion) {

        try{
            basePosts.put(publicacion.getIdPost(), publicacion);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Post> obtenerPostsPorVendedor(int vendedorId) {
        List<Post> listaPosts = new ArrayList<Post>();

        basePosts.forEach((postId, post) -> {
            if(post.getUserId() == vendedorId){
                listaPosts.add(post);
            }
        });

        return listaPosts;
    }
}
