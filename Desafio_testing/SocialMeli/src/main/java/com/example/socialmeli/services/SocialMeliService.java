package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.dto.response.*;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UserRepository;
import com.example.socialmeli.utils.MiFactory;
import com.example.socialmeli.utils.Sorter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements IService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    ModelMapper mapper = new ModelMapper();

    //  >>>> USER METHODS
    //!deprecated
    public User getUserById(Integer id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void follow(Integer userId, Integer userToFollowId)
            throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        if (userId.equals(userToFollowId)) throw new UserSelfUseException(userId);

        this.getUserById(userId);
        User userToFollow = this.getUserById(userToFollowId);

        if (userToFollow.getFollowersId().stream().anyMatch(id -> id.equals(userId))) {
            throw new UserAlreadyInUseException(userToFollowId);
        }

        userToFollow.getFollowersId().add(userId);
    }

    public void unfollow(Integer userId, Integer userIdToUnfollow)
            throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        if (userId.equals(userIdToUnfollow)) throw new UserSelfUseException(userId);

        this.getUserById(userId);
        User user = this.getUserById(userIdToUnfollow);

        if (user.getFollowersId().stream().noneMatch(u -> u.equals(userId))) {
            throw new UserAlreadyInUseException(userIdToUnfollow);
        }

        user.getFollowersId().removeIf(id -> id.equals(userId));
    }

    public FollowersResponseDTO getFollowers(Integer userId, String order) throws UserNotFoundException {
        FollowersResponseDTO followers = new FollowersResponseDTO();

        User user = this.getUserById(userId);

        followers.setFollowers(new ArrayList<>(getFollowersList(user, order)));
        followers.setUserId(userId);
        followers.setUserName(user.getUserName());

        return followers;
    }

    public FollowedResponseDTO getFollowed(Integer userId, String order) throws UserNotFoundException {
        FollowedResponseDTO followed = new FollowedResponseDTO();
        User user = this.getUserById(userId);

        followed.setFollowed(getFollowedList(userId, order));
        followed.setUserName(user.getUserName());
        followed.setUserId(userId);

        return followed;
    }

    private List<UserDTO> getFollowersList(User user, String order) {
        List<User> followersList = user.getFollowersId().stream().map(id -> {
            try {
                return this.getUserById(id);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        Sorter sorter = MiFactory.getInstance(order == null ? "name_desc" : order);

        return followersList.stream().map(u -> mapper.map(u, UserDTO.class))
                .sorted(sorter::sort).collect(Collectors.toList());
    }

    public List<UserDTO> getFollowedList(Integer userId, String order) {
        Sorter sorter = MiFactory.getInstance(order == null ? "name_desc" : order);

        return userRepository.findFollowed(userId).stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .sorted(sorter::sort).collect(Collectors.toList());

    }

    public CountFollowersResponseDTO countFollowers(Integer id) throws UserNotFoundException {
        User user = this.getUserById(id);
        CountFollowersResponseDTO quantity = new CountFollowersResponseDTO();
        quantity.setUserId(user.getUserId());
        quantity.setUserName(user.getUserName());
        quantity.setFollowersCount(user.getFollowersId().size());

        return quantity;
    }

    private boolean postExists(Integer id) {
        return postRepository.findById(id).isPresent();
    }

    //  >>>> POSTS METHODS

    public void pushPost(PostDTO newPost)
            throws PostAlreadyExistException, InvalidPromoException, UserNotFoundException {

        if (postExists(newPost.getIdPost())) {
            throw new PostAlreadyExistException(newPost.getIdPost(), newPost.getUserId());
        }

        this.getUserById(newPost.getUserId());

        if (newPost.getDiscount() > 100) {
            throw new InvalidPromoException(newPost.getIdPost());
        }

        this.postRepository.push(mapper.map(newPost, Post.class));
    }

    private List<PostDTO> getUserPosts(Integer id) {
        return this.postRepository.findByUserId(id).stream()
                .map(post -> mapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    public PostsResponseDTO getFollowedPostList(Integer id, String order) throws UserNotFoundException {
        this.getUserById(id);
        if (Objects.isNull(order) || (order != "date_asc" && order != "date_desc")) {
            throw new NullPointerException("No existe el ordenamiento para este método.");
        }
        Sorter sorter = MiFactory.getInstance(order);

        PostsResponseDTO response = new PostsResponseDTO();

        List<PostDTO> postsList = getFollowedList(id, null).stream().
                flatMap(user -> getUserPosts(user.getUserId()).stream()).
                sorted(sorter::sort).
                filter(post ->
                        post.getDate().compareTo(
                                Date.from(
                                        LocalDate.now()
                                                .minusDays(14)
                                                .atStartOfDay(
                                                        ZoneId.systemDefault()
                                                ).toInstant())) > 0).
                collect(Collectors.toList());

        response.setUserId(id);
        response.setPosts(postsList);

        return response;
    }


    public CountPromosResponseDTO getPromoCount(Integer userId) throws UserNotFoundException {
        CountPromosResponseDTO response = new CountPromosResponseDTO();

        User user = this.getUserById(userId);

        Integer cantidad = Math.toIntExact(
                postRepository.findByUserIdAndHasPromo(userId, true).size());

        response.setUserName(user.getUserName());
        response.setUserId(userId);
        response.setPromoProductsCount(cantidad);

        return response;
    }

    public PostsResponseDTO getPromoPosts(Integer userId) throws UserNotFoundException {
        User user = this.getUserById(userId);

        PostsResponseDTO response = new PostsResponseDTO();

        List<PostDTO> promoPosts = postRepository
                .findByUserIdAndHasPromo(userId, true).stream()
                .map(post -> mapper.map(post, PostDTO.class))
                .collect(Collectors.toList());

        response.setPosts(promoPosts);
        response.setUserId(user.getUserId());

        return response;
    }


}
