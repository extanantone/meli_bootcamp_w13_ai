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
    public PostDTORequest getById(int id) {
        Post post = postRepository.getById(id);
        if (post == null) {
            throw new NotFoundException("Publicacion no encontrada");
        }
        return PostMapper.postToPostDTO(post);
    }

    @Override
    public MessageDTOResponse create(PostDTORequest postDTORequest) {
        User seller = userRepository.getUser(postDTORequest.getUser_id());
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }

        Post post = postRepository.getById(postDTORequest.getId_post());
        if (post != null) {
            throw new AlreadyExistsException("Publicacion ya creada");
        }

        postRepository.create(PostMapper.postDTORequestToPost(postDTORequest));
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage("Publicacion creada correctamente");
        return messageDTOResponse;
    }

    @Override
    public PostsByUserDTOResponse getByUser(int userId, String order) {
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        LocalDate date = LocalDate.now().minus(Period.ofDays(14));
        List<Post> posts = postRepository.getByUserId(userId, date);

        PostsByUserDTOResponse postsByUserDTOResponse = new PostsByUserDTOResponse();
        postsByUserDTOResponse.setUser_id(userId);
        List<PostListItemDTOResponse> postListItemDTOResponses = posts.stream().map(PostMapper::postToPostListDTO).collect(Collectors.toList());
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
                        postListItemDTOResponses = postListItemDTOResponses.stream().sorted(Comparator.comparing(PostListItemDTOResponse::getDate).reversed()).collect(Collectors.toList());
                    } else {
                        if(order_dir.toLowerCase().equals("asc")){
                            postListItemDTOResponses = postListItemDTOResponses.stream().sorted(Comparator.comparing(PostListItemDTOResponse::getDate)).collect(Collectors.toList());
                        } else {
                            throw new BadRequestException("Formato de orden incorrecto");
                        }
                    }
                    break;
                default:
                    throw new BadRequestException("Formato de orden incorrecto");
            }
        }

        postsByUserDTOResponse.setPosts(postListItemDTOResponses);
        return postsByUserDTOResponse;
    }

    @Override
    public MessageDTOResponse createPromo(PostPromoDTORequest postPromoDTORequest) {
        User seller = userRepository.getUser(postPromoDTORequest.getUser_id());
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }

        Post post = postRepository.getById(postPromoDTORequest.getId_post());
        if (post != null) {
            throw new AlreadyExistsException("Publicacion ya creada");
        }

        postRepository.create(PostMapper.postPromoDTOToPost(postPromoDTORequest));
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage("Publicacion creada correctamente");
        return messageDTOResponse;
    }

    @Override
    public PostPromoByUserDTOResponse getPromosByUser(int userId) {
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        List<Post> posts = postRepository.getPromosByUser(userId);
        PostPromoByUserDTOResponse postPromoByUserDTOResponse = new PostPromoByUserDTOResponse();
        postPromoByUserDTOResponse.setUser_id(userId);
        List<PostPromoListItemDTOResponse> postListDTOS = posts.stream().map(PostMapper::postToPostPromoListDTO).collect(Collectors.toList());
        postPromoByUserDTOResponse.setPosts(postListDTOS);
        return postPromoByUserDTOResponse;
    }

    @Override
    public SellerCountPromosDTOResponse getSellerPromosCount(int sellerId) {
        User seller = userRepository.getUser(sellerId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }
        SellerCountPromosDTOResponse sellerCountPromosDTOResponse = UserMapper.userToSellerCountDTO(seller);
        sellerCountPromosDTOResponse.setPromo_products_count(postRepository.getPromosByUser(sellerId).size());
        return sellerCountPromosDTOResponse;
    }
}
