package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.post.PostInDTO;
import com.bootcamp.socialmeli.dto.request.post.ProductInDTO;
import com.bootcamp.socialmeli.dto.response.post.PostOutDTO;
import com.bootcamp.socialmeli.dto.response.post.ProductDTO;
import com.bootcamp.socialmeli.dto.response.post.SellersPostsDTO;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Product;
import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Seller;
import com.bootcamp.socialmeli.exception.userException.NotFoundUsuarioException;
import com.bootcamp.socialmeli.exception.postException.PostIdAlreadyExists;
import com.bootcamp.socialmeli.repository.ISocialMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    ISocialMeliRepository socialMeliRepository;
    ModelMapper mm;

    public ProductServiceImpl(ISocialMeliRepository socialMeliRepository) {
        this.socialMeliRepository = socialMeliRepository;
        this.mm = new ModelMapper();
    }

    @Override
    public void createPost(PostInDTO postIn) {

        Seller seller = socialMeliRepository.getSeller(postIn.getUserId()).orElseThrow(
                ()-> new NotFoundUsuarioException(postIn.getUserId())
        );

        if(seller.getPost(postIn.getIdPost())!=null){
            throw new PostIdAlreadyExists(seller.getUserID(),postIn.getIdPost());
        }

        ProductInDTO productIn = postIn.getDetail();

        Product product = new Product(productIn.getProductId(),productIn.getProductName(),
                productIn.getType(),productIn.getBrand(), productIn.getColor(), productIn.getNotes());

        //aquí debe validarse el formato de la fecha o arrojará una DateTimePaseException (ej: 01-122-2021)
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(postIn.getDate(),dt);

        Post post = new Post(postIn.getIdPost(),date,product,postIn.getCategory(),postIn.getPrice());

        socialMeliRepository.createNewPost(seller.getUserID(), post);
    }

    @Override
    public SellersPostsDTO getSellersPosts(Integer purchaserId) {

        Purchaser purchaser = socialMeliRepository.getPurchaser(purchaserId).orElseThrow(
                () -> new NotFoundUsuarioException(purchaserId)
        );

        var allPost = socialMeliRepository.getSellersPosts(purchaserId);

        List<PostOutDTO> postsResponse = new ArrayList<>();

        allPost.stream().forEach(post -> {

            ProductDTO detail = mm.map(post.getDetail(),ProductDTO.class);

            PostOutDTO postOutDTO = new PostOutDTO(post.getPostId(), post.getDate().toString(),
                    detail, post.getCategory(),post.getPrice());

            postsResponse.add(postOutDTO);

        });

        return new SellersPostsDTO(purchaserId,postsResponse);
    }
}
