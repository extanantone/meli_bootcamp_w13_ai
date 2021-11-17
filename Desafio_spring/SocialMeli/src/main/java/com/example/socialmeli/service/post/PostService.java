package com.example.socialmeli.service.post;

import com.example.socialmeli.dto.post.*;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.post.IPostRepository;
import com.example.socialmeli.repository.user.IUserRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService
{
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserPostDTO create(UserPostDTO userPostDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Post post = modelMapper.map(userPostDTO, Post.class);
        if (!postRepository.addPost(post))
            throw new BadRequestException("Post no valido");

        return userPostDTO;
    }

    @Override
    public PromoPostCountDTO promoPostCount(int userId)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");


        User user = userMap.get(userId);
        List<Post> promoPosts = user.getPosts().stream().filter(Post::isHasPromo).collect(Collectors.toList());
        user.setPosts(promoPosts);
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, PromoPostCountDTO> propertyMapper = modelMapper.createTypeMap(User.class, PromoPostCountDTO.class);
        Converter<Collection, Integer> collectionToSize = c -> c.getSource().size();
        propertyMapper.addMappings(
                mapper -> mapper.using(collectionToSize).map(User::getPosts, PromoPostCountDTO::setPromoProductsCount)
        );
        return modelMapper.map(user, PromoPostCountDTO.class);
    }

    @Override
    public PromoPostListDTO promoPostList(int userId)
    {
        User user;
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        user = userMap.get(userId);
        ModelMapper modelMapper = new ModelMapper();
        List<Post> promoPosts = user.getPosts().stream().filter(Post::isHasPromo).collect(Collectors.toList());
        user.setPosts(promoPosts);
        return modelMapper.map(user, PromoPostListDTO.class);
    }

    @Override
    public UserPromoPostDTO createPromo(UserPromoPostDTO userPromoPostDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Post post = modelMapper.map(userPromoPostDTO, Post.class);
        if (!postRepository.addPost(post))
            throw new BadRequestException("Post no valido");

        return userPromoPostDTO;
    }

    @Override
    public PostFollowedDTO listRecentFollowedProducts(int userId, String order)
    {
        User user;
        List<Post> orderedPosts;
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        user = userMap.get(userId);
        ModelMapper modelMapper = new ModelMapper();
        if (order.equals("date_asc"))
            orderedPosts = postRepository.findTwoWeeksBeforeOrderByDateAsc(userId);
        else
            orderedPosts = postRepository.findTwoWeeksBeforeOrderByDateDesc(userId);
        user.setPosts(orderedPosts);
        return modelMapper.map(user, PostFollowedDTO.class);
    }
}
