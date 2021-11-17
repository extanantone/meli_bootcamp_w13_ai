package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;
import com.bootcamp.socialmeli.exception.NotFoundUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.exception.NotPostProductException;
import com.bootcamp.socialmeli.mapper.IProductMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Post post = iProductMapper.postDTOToPost(requestPostDTO);
        if (post == null)   throw new NotPostProductException();
        iProductRepository.postProduct(post);

    }

    @Override
    public ResponsePostDTO getProductsFollowed(int userId, String order) throws NotPossibleOperationException {
        User user = iUserRepository.getUser(userId);
        if (user == null)   throw new NotFoundUserException(userId);

        List<User> usersFollowed = iUserRepository.getUsersFollowed(user);
        List<Post> postList = new ArrayList<>();

        for (User u : usersFollowed){
            postList.addAll(iProductRepository.getPost(u.getId()));
        }

        if(order != null)   postList.sort((p1, p2) -> comparePost(p1,p2,order));

        List<PostDTO> postListDTO = new ArrayList<>();
        for (Post p : postList){
            postListDTO.add(iProductMapper.postDTOFromPost(p));
        }

        return new ResponsePostDTO(user.getId(), postListDTO);
    }

    private int comparePost(Post p1, Post p2, String order){
        if (order.equals("date_asc")){
            return p1.getDate().compareTo(p2.getDate());
        } else if (order.equals("date_desc")){
            return (p1.getDate().compareTo(p2.getDate())) * -1;
        }
        else {
            return 0;
        }
    }

}
