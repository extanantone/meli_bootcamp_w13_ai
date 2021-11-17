package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exceptions.IdAlreadyCreatedException;
import com.bootcamp.SocialMeli.exceptions.SameUserException;
import com.bootcamp.SocialMeli.model.Detail;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.InvalidMidiDataException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new SameUserException("Un usuario no se puede seguir a si mismo.");
        }
        User user = repository.getUser(userId).orElse(null);
        User userToFollow = repository.getUser(userIdToFollow).orElse(null);
        if (user.getFollowed().containsKey(userIdToFollow)) {
            throw new IdAlreadyCreatedException("El usuario " + userId + " ya sigue al usuario " + userIdToFollow);
        }
        user.addFollowed(userToFollow);
        userToFollow.addFollower(user);
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
        if (userId.equals(userIdToUnfollow)) {
            throw new SameUserException("Un usuario no se sigue a si mismo.");
        }
        User user = repository.getUser(userId).orElse(null);
        User userToUnfollow = repository.getUser(userIdToUnfollow).orElse(null);
        user.deleteFollowed(userToUnfollow);
        userToUnfollow.deleteFollower(user);
    }

    @Override
    public void newPublication(PostDTO dto) {
        if (repository.getPosts().containsKey(dto.getIdPost())) {
            throw new IdAlreadyCreatedException("Ya existe un post con el id: " + dto.getIdPost());
        }
        repository.addPost(
                new Post(dto.getUserId(),
                        dto.getIdPost(),
                        LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        new Detail(dto.getDetail().getProductId(),
                                dto.getDetail().getProductName(),
                                dto.getDetail().getType(),
                                dto.getDetail().getBrand(),
                                dto.getDetail().getColor(),
                                dto.getDetail().getNotes()),
                        dto.getCategory(),
                        dto.getPrice()));
    }

    @Override
    public FollowerCountDTO countFollowers(Integer userId) {
        User user = repository.getUser(userId).orElse(null);
        Integer count = user.getFollowers().size();
        FollowerCountDTO dto = new FollowerCountDTO(user.getUserId(), user.getUserName(), count);
        return dto;
    }

    @Override
    public FollowersDTO getFollowers(Integer userId, String order) {
        User user = repository.getUser(userId).orElse(null);
        List<UserDTO> followersList = new ArrayList<>();
        for (Map.Entry<Integer, User> follower : user.getFollowers().entrySet()
        ) {
            followersList.add(new UserDTO(follower.getValue().getUserId(), follower.getValue().getUserName()));
        }
        if (!Objects.isNull(order)) {
            if (order.equals("name_asc")) {
                followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)).
                        collect(Collectors.toList());
            }
            if (order.equals("name_desc")) {
                followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)
                                .reversed()).
                        collect(Collectors.toList());
            }
        }
        FollowersDTO dto = new FollowersDTO(user.getUserId(), user.getUserName(), followersList);
        return dto;
    }

    @Override
    public FollowedDTO getFollowed(Integer userId, String order) {
        User user = repository.getUser(userId).orElse(null);
        List<UserDTO> followedList = new ArrayList<>();
        for (Map.Entry<Integer, User> followed : user.getFollowed().entrySet()
        ) {
            followedList.add(new UserDTO(followed.getValue().getUserId(), followed.getValue().getUserName()));
        }
        if (!Objects.isNull(order)) {
            if (order.equals("name_asc")) {
                followedList = followedList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)).
                        collect(Collectors.toList());
            }
            if (order.equals("name_desc")) {
                followedList = followedList.stream().sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)
                                .reversed()).
                        collect(Collectors.toList());
            }
        }
        FollowedDTO dto = new FollowedDTO(user.getUserId(), user.getUserName(), followedList);
        return dto;
    }

    @Override
    public PostsListDTO getPostsList(Integer userId, String order) {
        User user = repository.getUser(userId).orElse(null);
        Map<Integer, User> vendedores = user.getFollowed();
        List<Post> postList = new ArrayList<>();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Map.Entry<Integer, Post> post : repository.getPosts().entrySet()
        ) {
            if (vendedores.containsKey(post.getValue().getUserId())) {
                postList.add(post.getValue());
            }
        }
        // filtra ultimas 2 semanas
        postList = postList.stream()
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusDays(14)) && post.getDate().isBefore(LocalDate.now().plusDays(1)))
                .collect(Collectors.toList());
        // ordena
        if (!Objects.isNull(order)) {
            if (order.equals("date_asc")) {
                postList = postList.stream().sorted(Comparator.comparing(Post::getDate)).
                        collect(Collectors.toList());
            }
            if (order.equals("date_desc")) {
                postList = postList.stream().sorted(Comparator.comparing(Post::getDate)
                                .reversed()).
                        collect(Collectors.toList());
            }
        }
        for (Post p : postList) {
            postDTOList.add(
                    new PostDTO(p.getUserId(),
                            p.getIdPost(),
                            p.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                            new DetailDTO(p.getDetail().getProductId(),
                                    p.getDetail().getProductName(),
                                    p.getDetail().getType(),
                                    p.getDetail().getBrand(),
                                    p.getDetail().getColor(),
                                    p.getDetail().getNotes()),
                            p.getCategory(),
                            p.getPrice()));
        }
        PostsListDTO dto = new PostsListDTO(userId, postDTOList);
        return dto;
    }

}
