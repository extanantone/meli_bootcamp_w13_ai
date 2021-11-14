package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.post.PostInDTO;
import com.bootcamp.socialmeli.dto.request.post.ProductInDTO;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Product;
import com.bootcamp.socialmeli.exception.UserException.NotFoundUsuarioException;
import com.bootcamp.socialmeli.exception.postException.PostIdAlreadyExists;
import com.bootcamp.socialmeli.repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProductServiceImpl implements IProductService{

    ISocialMeliRepository socialMeliRepository;

    public ProductServiceImpl(ISocialMeliRepository socialMeliRepository) {
        this.socialMeliRepository = socialMeliRepository;
    }

    @Override
    public void createPost(PostInDTO postIn) {

        var seller = socialMeliRepository.getSeller(postIn.getUserId());

        if(seller == null){
            throw new NotFoundUsuarioException(seller.getUserID());
        }

        if(seller.getPost(postIn.getIdPost())!=null){
            throw new PostIdAlreadyExists(seller.getUserID(),postIn.getIdPost());
        }

        ProductInDTO productIn = postIn.getDetail();

        Product product = new Product(productIn.getProductId(),productIn.getProductName(),
                productIn.getType(),productIn.getBrand(), productIn.getColor(), productIn.getNotes());


        //aquí debe validarse el formato de la fecha o arrojará una DateTimePaseException (ej: 01-122-2021)
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(postIn.getDate(),dt);

        if(date.isBefore(LocalDate.now())){

        }

        Post post = new Post(postIn.getIdPost(),date,product,postIn.getCategory(),postIn.getPrice());

        socialMeliRepository.getSeller(seller.getUserID()).setPost(post);
    }


}
