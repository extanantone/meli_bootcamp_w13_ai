package com.example.socialmeli.service.product.post;

import com.example.socialmeli.dto.post.*;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.product.post.IPostRepository;
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
        if (!postRepository.createPost(post))
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
    public PromoPostListDTO promoPostList(int userId, String order)
    {
        User user;
        Map<Integer, User> userMap = userRepository.usersMap();
        List<Post> promoPost;
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        user = userMap.get(userId);
        ModelMapper modelMapper = new ModelMapper();
        if (order != null)
        {
            if (order.equals("name_asc"))
                promoPost = postRepository.findPromoPostOrderByProductNameAsc(userId);
            else
                promoPost = postRepository.findPromoPostsOrderByProductNameDesc(userId);
        }
        else
        {
            promoPost = postRepository.findPromoPosts(userId);
        }
        TypeMap<User, PromoPostListDTO> propertyMapper = modelMapper.createTypeMap(User.class, PromoPostListDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> promoPost, PromoPostListDTO::setPosts));
        return modelMapper.map(user, PromoPostListDTO.class);
    }

    @Override
    public UserPromoPostDTO createPromo(UserPromoPostDTO userPromoPostDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Post post = modelMapper.map(userPromoPostDTO, Post.class);
        if (!postRepository.createPost(post))
            throw new BadRequestException("Post no valido");

        return userPromoPostDTO;
    }

    @Override
    public PostFollowedDTO listRecentFollowedPosts(int userId, String order)
    {
        User user;
        List<Post> orderedPosts;
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        user = userMap.get(userId);
        ModelMapper modelMapper = new ModelMapper();
        if (order == null || order.equals("date_desc"))
            orderedPosts = postRepository.findFollowedTwoWeeksBeforeOrderByDateDesc(userId);
        else
            orderedPosts = postRepository.findFollowedTwoWeeksBeforeOrderByDateAsc(userId);
        TypeMap<User, PostFollowedDTO> propertyMapper = modelMapper.createTypeMap(User.class, PostFollowedDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> orderedPosts, PostFollowedDTO::setPosts));
        return modelMapper.map(user, PostFollowedDTO.class);
    }
}
