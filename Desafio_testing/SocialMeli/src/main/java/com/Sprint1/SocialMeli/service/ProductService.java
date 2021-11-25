package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.FollowedListDTO;
import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.dto.PostDTO;
import com.Sprint1.SocialMeli.dto.PostFollowedListDTO;
import com.Sprint1.SocialMeli.mapper.PostMapper;
import com.Sprint1.SocialMeli.model.Post;
import com.Sprint1.SocialMeli.model.User;
import com.Sprint1.SocialMeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    IUserRepository userRepository;

    public ProductService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createPost (Post post){
        User user = this.userRepository.findUser(post.getUser_id()).orElseThrow();
        user.getPost().add(post);
    }

    @Override
    public PostFollowedListDTO postListFollowed(int user_id, String order) {

        //busco el usuario user_id que tengo que buscar sus seguidores
        User user = this.userRepository.findUser(user_id).orElseThrow();

        List<PostDTO> postOrder = user.getFollowed().stream()
                .map( u -> userRepository.findUser(u.getUser_id()))
                .collect(Collectors.toList())
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(User::getPost)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList())
                .stream()
                .filter(post -> twoWeeksAgoCheck(post.getDate()))
                .sorted(Comparator.comparing(Post::getDate))
                .map(PostMapper::postToDTO)
                .collect(Collectors.toList());

        if (order == null){
            return PostMapper.postDTOtoFollowedListDTO(user, postOrder);
        }

        List<PostDTO> postOrderSorted = postOrder
                .stream()
                .sorted(Comparator.comparing(PostDTO::getDate))
                .collect(Collectors.toList());

        if(order.equals("date_asc")) {
            return PostMapper.postDTOtoFollowedListDTO(user, postOrderSorted);
        }else if(order.equals("date_desc")) {
            Collections.reverse(postOrderSorted);
            return PostMapper.postDTOtoFollowedListDTO(user, postOrderSorted);
        }
        return null;
    }

    private boolean twoWeeksAgoCheck(LocalDate date) {
        return date.equals(LocalDate.now()) ||
                (date.isBefore(LocalDate.now()) &&
                        date.isAfter(LocalDate.now().minusDays(14L)));
    }
}
