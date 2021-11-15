package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;
import com.SocialMeli.SocialMeli.exception.AlreadyExistsException;
import com.SocialMeli.SocialMeli.exception.BadRequestException;
import com.SocialMeli.SocialMeli.exception.NotFoundException;
import com.SocialMeli.SocialMeli.mapper.PostMapper;
import com.SocialMeli.SocialMeli.mapper.UserMapper;
import com.SocialMeli.SocialMeli.repository.IPostRepository;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public PostDTO getById(int id) {
        Post post = postRepository.getById(id);
        if (post == null) {
            throw new NotFoundException("Publicacion no encontrada");
        }
        return PostMapper.postToPostDTO(post);
    }

    @Override
    public PostDTO create(PostDTO postDTO) {
        User seller = userRepository.getUser(postDTO.getUser_id());
        if (seller == null){
            throw new NotFoundException("Usuario no encontrado");
        }
        Post post = postRepository.getById(postDTO.getId_post());
        if (post != null) {
            throw new AlreadyExistsException("Publicacion ya creada");
        }

        postRepository.create(PostMapper.postDTOToPost(postDTO));
        return postDTO;
    }

    @Override
    public PostsByUserDTO getByUser(int userId, String order) {
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        LocalDate date = LocalDate.now().minus(Period.ofDays(14));
        List<Post> posts = postRepository.getByUserId(userId, date);

        PostsByUserDTO postsByUserDTO = new PostsByUserDTO();
        postsByUserDTO.setUser_id(userId);
        List<PostListDTO> postListDTOS = posts.stream().map(PostMapper::postToPostListDTO).collect(Collectors.toList());
        if (order != null){
            String[] order_request = order.split("_");
            if (order_request.length != 2) {
                throw new BadRequestException("Formato de orden incorrecto");
            }
            String order_type = order_request[0];
            String order_dir = order_request[1];

            switch (order_type.toLowerCase()){
                case "date":
                    if (order_dir.toLowerCase().equals("desc")) {
                        postListDTOS = postListDTOS.stream().sorted(Comparator.comparing(PostListDTO::getDate).reversed()).collect(Collectors.toList());
                    } else {
                        if(order_dir.toLowerCase().equals("asc")){
                            postListDTOS = postListDTOS.stream().sorted(Comparator.comparing(PostListDTO::getDate)).collect(Collectors.toList());
                        } else {
                            throw new BadRequestException("Formato de orden incorrecto");
                        }
                    }
                    break;
                default:
                    throw new BadRequestException("Formato de orden incorrecto");
            }
        }

        postsByUserDTO.setPosts(postListDTOS);
        return postsByUserDTO;
    }

    @Override
    public PostPromoDTO createPromo(PostPromoDTO postPromoDTO) {
        User seller = userRepository.getUser(postPromoDTO.getUser_id());
        if (seller == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        Post post = postRepository.getById(postPromoDTO.getId_post());
        if (post != null) {
            throw new AlreadyExistsException("Publicacion ya creada");
        }

        postRepository.create(PostMapper.postPromoDTOToPost(postPromoDTO));
        return postPromoDTO;
    }

    @Override
    public PostPromoByUserDTO getPromosByUser(int userId) {
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        List<Post> posts = postRepository.getPromosByUser(userId);
        PostPromoByUserDTO postPromoByUserDTO = new PostPromoByUserDTO();
        postPromoByUserDTO.setUser_id(userId);
        List<PostPromoListDTO> postListDTOS = posts.stream().map(PostMapper::postToPostPromoListDTO).collect(Collectors.toList());
        postPromoByUserDTO.setPosts(postListDTOS);
        return postPromoByUserDTO;
    }

    @Override
    public SellerCountPromosDTO getSellerPromosCount(int sellerId) {
        User seller = userRepository.getUser(sellerId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }
        SellerCountPromosDTO sellerCountPromosDTO = UserMapper.userToSellerCountDTO(seller);
        sellerCountPromosDTO.setPromo_products_count(postRepository.getPromosByUser(sellerId).size());
        return sellerCountPromosDTO;
    }
}
