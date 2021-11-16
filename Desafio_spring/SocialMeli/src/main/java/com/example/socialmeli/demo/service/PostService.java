package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.dto.controllerToService.*;
import com.example.socialmeli.demo.dto.serviceToController.*;
import com.example.socialmeli.demo.exception.UserNotFoundException;
import com.example.socialmeli.demo.mapper.PostMapper;
import com.example.socialmeli.demo.mapper.PromoMapper;
import com.example.socialmeli.demo.model.Product;
import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.model.PromoPost;
import com.example.socialmeli.demo.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPublicacionService{

    @Autowired
    IPostRepository iPublicacionRepository;

    @Autowired
    IFollowerService iFollowerService;

    @Autowired
    IUserService iUserService;

    @Override
    public ResponseEntity createPost(DTOPost publicacion) {

        Post postToSave = new Post();
        postToSave = PostMapper.DtoPostToPost(publicacion);
       /* postToSave.setUserId(publicacion.getUserId());
        postToSave.setIdPost(publicacion.getIdPost());
        postToSave.setCategory(publicacion.getCategory());
        postToSave.setDate(publicacion.getDate());
        postToSave.setPrice(publicacion.getPrice()); */

        Product p = new Product();
        /*p.setProductId(publicacion.getDetail().getProductId());
        p.setType(publicacion.getDetail().getType());
        p.setProductName(publicacion.getDetail().getProductName());
        p.setNotes(publicacion.getDetail().getNotes());
        p.setColor(publicacion.getDetail().getColor());
        p.setBrand(publicacion.getDetail().getBrand());

        postToSave.setDetail(p); */

       iPublicacionRepository.crearPublicacion(postToSave);

       return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity createPromoPost(DTOPromoPost publicacion) {

        PromoPost postToSave = new PromoPost();
        postToSave = PromoMapper.DtoPostToPost(publicacion);
       /* postToSave.setUserId(publicacion.getUserId());
        postToSave.setIdPost(publicacion.getIdPost());
        postToSave.setCategory(publicacion.getCategory());
        postToSave.setDate(publicacion.getDate());
        postToSave.setPrice(publicacion.getPrice());
        postToSave.setDiscount(publicacion.getDiscount());
        postToSave.setPromo(publicacion.isHasPromo());

        Product p = new Product();
        p.setProductId(publicacion.getDetail().getProductId());
        p.setType(publicacion.getDetail().getType());
        p.setProductName(publicacion.getDetail().getProductName());
        p.setNotes(publicacion.getDetail().getNotes());
        p.setColor(publicacion.getDetail().getColor());
        p.setBrand(publicacion.getDetail().getBrand());

        postToSave.setDetail(p); */

        iPublicacionRepository.crearPublicacion(postToSave);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<DTOPostsFromMyFollowedUsers> getPostsFromUserFollowersSinceTwoWeeks(DTORequestPostsFromFolloweds request) {

        int userId = request.getUserId();
        String order = request.getOrder();
        List<DTOPostFollowers> postsFromVendorDTO = new ArrayList<>();
        List<Post> postsFromVendor = new ArrayList<>();
        List<DTOUsuario> followedUsersFromUser = new ArrayList<>();
        DTOPostsFromMyFollowedUsers response = new DTOPostsFromMyFollowedUsers();
        DTOUserFollowedList followedUsersFromUserDTO = new DTOUserFollowedList();

        //Verificamos que el usuario exista
        DTOUsuario searchedUser = iUserService.getUserByUserId(userId);

        if(searchedUser == null){
            throw new UserNotFoundException();
        }

        DTORequestUserList requestToPostService = new DTORequestUserList();
        requestToPostService.setUserId(request.getUserId());
        requestToPostService.setOrder(null);

        DTOUserId userIdDTo = new DTOUserId(userId);
        followedUsersFromUserDTO = iFollowerService.getFollowedUsersOfUserId(requestToPostService);
        followedUsersFromUser = followedUsersFromUserDTO.getFollowed();

        for (DTOUsuario uDTO: followedUsersFromUser) {

            postsFromVendor = iPublicacionRepository.obtenerPublicacionesPorVendedorIdPosteriores2Semanas(uDTO.getUserId(),order);

            for (Post p: postsFromVendor) {

                DTOPostFollowers postFollowersDTO = new DTOPostFollowers();
                postFollowersDTO = PostMapper.PostToDtoPostFollowers(p);
/*                postFollowersDTO.setIdPost(p.getIdPost());
                postFollowersDTO.setDate(p.getDate());
                postFollowersDTO.setCategory(p.getCategory());
                postFollowersDTO.setPrice(p.getPrice());

                DTOProduct prod = new DTOProduct();
                prod.setProductId(p.getDetail().getProductId());
                prod.setType(p.getDetail().getType());
                prod.setProductName(p.getDetail().getProductName());
                prod.setNotes(p.getDetail().getNotes());
                prod.setColor(p.getDetail().getColor());
                prod.setBrand(p.getDetail().getBrand());

                postFollowersDTO.setDetail(prod); */

                postsFromVendorDTO.add(postFollowersDTO);
            }

        }


        response.setUserId(userId);
        response.setPosts(postsFromVendorDTO);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTOUserPromoPostList> getPromoPostListOfUserId(DTOUserId request) {

        int vendorId = request.getUserId();
        List<Post> responseFromRepository = new ArrayList<>();
        List<DTOPromoPost> promoPostList = new ArrayList<>();
        DTOUsuario searchedUser = new DTOUsuario();
        DTOUserPromoPostList response = new DTOUserPromoPostList();

        searchedUser = iUserService.getUserByUserId(vendorId);

        if(searchedUser == null){
           throw new UserNotFoundException();
        }

        response.setUserId(vendorId);
        response.setUserName(searchedUser.getUserName());

        responseFromRepository = iPublicacionRepository.getPromoPostListOfUserId(vendorId);

        for (Post p: responseFromRepository) {

            DTOPromoPost post = new DTOPromoPost();
            post = PromoMapper.PostToDtoPromoPost(p);
           /* post.setIdPost(p.getIdPost());
            post.setUserId(p.getUserId());
            post.setCategory(p.getCategory());
            post.setHasPromo(p.hasPromo());
            post.setDiscount(p.hasDiscount());
            post.setDate(p.getDate());
            post.setPrice(p.getPrice());


            DTOProduct prod = new DTOProduct();
            prod.setProductId(p.getDetail().getProductId());
            prod.setType(p.getDetail().getType());
            prod.setProductName(p.getDetail().getProductName());
            prod.setNotes(p.getDetail().getNotes());
            prod.setColor(p.getDetail().getColor());
            prod.setBrand(p.getDetail().getBrand());

            post.setDetail(prod); */

            response.addPostToList(post);

        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTOUserPromoPostCount> countPromoPostOfUser(DTOUserId userId) {

        int vendorId = userId.getUserId();
        int promoProductsCount = 0;
        DTOUsuario searchedUser = new DTOUsuario();
        DTOUserPromoPostCount response = new DTOUserPromoPostCount();

        searchedUser = iUserService.getUserByUserId(vendorId);

        if(searchedUser == null){
            throw new UserNotFoundException();
        }

        response.setUserId(vendorId);
        response.setUserName(searchedUser.getUserName());

        promoProductsCount = iPublicacionRepository.countPromoPostOfUser(vendorId);
        response.setPromoProductsCount(promoProductsCount);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
