package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;
import com.bootcamp.socialmeli.exception.NotFoundOrderParamException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.exception.NotPostProductException;
import com.bootcamp.socialmeli.mapper.IProductMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IProductMapper iProductMapper;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void postProduct(RequestPostDTO requestPostDTO) throws NotPossibleOperationException{
        //Post post = iProductMapper.postDTOToPost(requestPostDTO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            Product product = new Product(
                    requestPostDTO.getDetail().getProductId(),
                    requestPostDTO.getDetail().getProductName(),
                    requestPostDTO.getDetail().getType(),
                    requestPostDTO.getDetail().getBrand(),
                    requestPostDTO.getDetail().getColor(),
                    requestPostDTO.getDetail().getNotes());
            Post post = new Post(
                    requestPostDTO.getIdPost(),
                    LocalDate.parse(requestPostDTO.getDate(), formatter),
                    requestPostDTO.getPrice(),
                    requestPostDTO.getCategory(),
                    requestPostDTO.getUserId(),
                    product
            );
            iProductRepository.postProduct(post);
        } catch (Exception e){
            throw new NotPostProductException();
        }
        //if (post == null)   throw new NotPostProductException();
    }

    @Override
    public ResponsePostDTO getProductsFollowed(int userId, String order) throws NotPossibleOperationException {
        User user = iUserRepository.getUser(userId);
        //if (user == null)   throw new NotFoundUserException(userId);

        List<User> usersFollowed = iUserRepository.getUsersFollowed(user);
        List<Post> postList = new ArrayList<>();

        for (User u : usersFollowed){
            postList.addAll(iProductRepository.getPost(u.getId()));
        }

        //if(order != null)   postList.sort((p1, p2) -> comparePost(p1,p2,order));
        if(order != null)   orderPostList(postList, order.toLowerCase());

        List<PostDTO> postListDTO = new ArrayList<>();
        for (Post p : postList){
            //postListDTO.add(iProductMapper.postDTOFromPost(p));
            ProductDTO pDTO = new ProductDTO(
                    p.getDetail().getProductId(),
                    p.getDetail().getProductName(),
                    p.getDetail().getType(),
                    p.getDetail().getBrand(),
                    p.getDetail().getColor(),
                    p.getDetail().getNotes());
            postListDTO.add(new PostDTO(
                    p.getIdPost(),
                    p.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    p.getPrice(),
                    p.getCategory(),
                    pDTO));
        }

        return new ResponsePostDTO(user.getId(), postListDTO);
    }

    private void orderPostList(List<Post> postList, String order) throws NotFoundOrderParamException {
        if (order.equals("date_asc")){
            postList.sort((p1, p2) -> p1.getDate().compareTo(p2.getDate()));
        } else if (order.equals("date_desc")){
            postList.sort((p1, p2) -> p1.getDate().compareTo(p2.getDate()) * -1);
        } else {
            throw new NotFoundOrderParamException(order);
        }
    }

}
