package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.UsuarioDTO;
import com.example.socialmeli.demo.dto.controllerToService.*;
import com.example.socialmeli.demo.dto.serviceToController.PostFollowersDTO;
import com.example.socialmeli.demo.dto.serviceToController.PostsFromMyFollowedUsersDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersListDTO;
import com.example.socialmeli.demo.model.Producto;
import com.example.socialmeli.demo.model.Publicacion;
import com.example.socialmeli.demo.repository.IPublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionService implements IPublicacionService{

    @Autowired
    IPublicacionRepository iPublicacionRepository;

    @Autowired
    IFollowerService iFollowerService;

    @Override
    public ResponseEntity createPost(PublicacionDTO publicacion) {

        Publicacion postToSave = new Publicacion();
        postToSave.setUserId(publicacion.getUserId());
        postToSave.setIdPost(publicacion.getIdPost());
        postToSave.setCategory(publicacion.getCategory());
        postToSave.setDate(publicacion.getDate());
        postToSave.setPrice(publicacion.getPrice());

        Producto p = new Producto();
        p.setProductId(publicacion.getDetail().getProductId());
        p.setType(publicacion.getDetail().getType());
        p.setProductName(publicacion.getDetail().getProductName());
        p.setNotes(publicacion.getDetail().getNotes());
        p.setColor(publicacion.getDetail().getColor());
        p.setBrand(publicacion.getDetail().getBrand());

        postToSave.setDetail(p);

       iPublicacionRepository.crearPublicacion(postToSave);

       return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostsFromMyFollowedUsersDTO> getPostsFromUserFollowersSinceTwoWeeks(RequestPostsFromFollowedsDTO request) {

        int userId = request.getUserId();
        String order = request.getOrder();

        List<PostFollowersDTO> postsFromVendorDTO = new ArrayList<>();
        List<Publicacion> postsFromVendor = new ArrayList<>();
        List<UsuarioDTO> followedUsersFromUser = new ArrayList<>();
        PostsFromMyFollowedUsersDTO response = new PostsFromMyFollowedUsersDTO();
        UserFollowersListDTO followedUsersFromUserDTO = new UserFollowersListDTO();

        RequestUserListDTO requestToPostService = new RequestUserListDTO();
        request.setUserId(userId);
        request.setOrder(null);


        UserIdDTO userIdDTo = new UserIdDTO(userId);
        followedUsersFromUserDTO = iFollowerService.getFollowedUsersFromUserId(requestToPostService);
        followedUsersFromUser = followedUsersFromUserDTO.getFollowers();

        for (UsuarioDTO uDTO: followedUsersFromUser) {

            postsFromVendor = iPublicacionRepository.obtenerPublicacionesPorVendedorIdPosteriores2Semanas(uDTO.getUser_id(),order);

            for (Publicacion p: postsFromVendor) {

                PostFollowersDTO postFollowersDTO = new PostFollowersDTO();
                postFollowersDTO.setIdPost(p.getIdPost());
                postFollowersDTO.setDate(p.getDate());
                postFollowersDTO.setCategory(p.getCategory());
                postFollowersDTO.setPrice(p.getPrice());

                ProductoDTO prod = new ProductoDTO();
                prod.setProductId(p.getDetail().getProductId());
                prod.setType(p.getDetail().getType());
                prod.setProductName(p.getDetail().getProductName());
                prod.setNotes(p.getDetail().getNotes());
                prod.setColor(p.getDetail().getColor());
                prod.setBrand(p.getDetail().getBrand());

                postFollowersDTO.setDetail(prod);

                postsFromVendorDTO.add(postFollowersDTO);
            }

        }


        response.setUserId(userId);
        response.setPosts(postsFromVendorDTO);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
