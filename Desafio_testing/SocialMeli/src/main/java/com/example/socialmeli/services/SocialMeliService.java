package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.dto.response.*;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.utils.MiFactory;
import com.example.socialmeli.utils.Sorter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements IService {

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    PostRepository postRepository;

    ModelMapper mapper = new ModelMapper();

    /*public SocialMeliService(UsuarioRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }*/

    //  >>>> USER METHODS
    //!depracted
    public User getUserById(Integer id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void follow(Integer userId, Integer userToFollowId) throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        if(userId.equals(userToFollowId)){
            throw new UserSelfUseException(userId);
        }

        User user = this.getUserById(userId);
        User userToFollow = this.getUserById(userToFollowId);

        if( userToFollow.getFollowersId().stream().anyMatch( id -> id.equals(userId) ) ){
            throw new UserAlreadyInUseException(userToFollowId);
        }

        userToFollow.getFollowersId().add(userId);
    }

    public void unfollow(Integer userId , Integer userIdToUnfollow) throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        if(userId.equals(userIdToUnfollow)){
            throw new UserSelfUseException(userId);
        }

        User user = this.getUserById(userIdToUnfollow);

        if( user.getFollowersId().stream().anyMatch( u -> u.equals(userId) ) ){
            throw new UserAlreadyInUseException(userIdToUnfollow);
        }

        this.getUserById(userIdToUnfollow).getFollowersId().removeIf( id -> id.equals(userId));
    }

    public FollowersResponseDTO getFollowers(Integer userId, String order) throws UserNotFoundException {
        FollowersResponseDTO followers = new FollowersResponseDTO();

        User user = this.getUserById(userId);

        followers.setFollowers(
                getFollowersList(userId,order).stream()
                        .collect(Collectors.toList()));

        followers.setUserId(userId);
        followers.setUserName(user.getUserName());

        return followers;
    }

    public FollowedResponseDTO getFollowed(Integer userId, String order) throws UserNotFoundException {
        FollowedResponseDTO followed = new FollowedResponseDTO();
        User user = this.getUserById(userId);

        followed.setFollowed(getFollowedList(userId,order));
        followed.setUserName(user.getUserName());
        followed.setUserId(userId);

        return followed;
    }

    private List<UserDTO> getFollowersList(Integer userId, String order) throws UserNotFoundException {
        User user = this.getUserById(userId);

        List<User> followersList = new ArrayList<>();

        for( Integer idFollower : user.getFollowersId() ){

            followersList.add( this.getUserById(idFollower) );

        }

        Sorter sorter = MiFactory.getInstance(order == null ? "name_desc" : order);

        return followersList.stream()
                .map( u -> mapper.map(u, UserDTO.class))
                .sorted( (u,b) -> sorter.sort(u,b) )
                .collect(Collectors.toList());
    }

    public List<UserDTO> getFollowedList(Integer userId, String order) throws UserNotFoundException {

        if( !userExists(userId) ){
            throw new UserNotFoundException(userId);
        }

        Sorter sorter = MiFactory.getInstance(order == null ? "name_desc" : order);

        return userRepository.findFollowers(userId).stream()
                .map( u -> mapper.map(u, UserDTO.class))
                .sorted( (u,b) -> sorter.sort(u,b))
                .collect(Collectors.toList());

    }

    public CountFollowersResponseDTO countFollowers(Integer id) throws UserNotFoundException {
        User user = this.getUserById(id);
        CountFollowersResponseDTO quantity = new CountFollowersResponseDTO();
        quantity.setUserId(user.getUserId());
        quantity.setUserName(user.getUserName());
        quantity.setFollowersCount((int) user.getFollowersId().stream().count());

        return quantity;
    }

    private boolean userExists(Integer id){
        return userRepository.findById(id).isPresent();
    }

    private boolean postExists(Integer id){
        return postRepository.findById(id).isPresent();
    }

    //  >>>> POSTS METHODS

    public PostDTO getPostById(Integer postId) throws PostNotFoundException {

        return mapper.map(
                this.postRepository.findById(postId),
                PostDTO.class
        );
    }

    public void pushPost(PostDTO newPost) throws PostAlreadyExistException, InvalidPromoException, UserNotFoundException {

        if( postExists(newPost.getIdPost()) ){
            throw new PostAlreadyExistException(newPost.getIdPost(), newPost.getUserId());
        }

        if( !userExists(newPost.getUserId()) ){
            throw new UserNotFoundException(newPost.getUserId());
        }

        if(newPost.getDiscount() > 1){
            throw new InvalidPromoException(newPost.getIdPost());
        }

        this.postRepository.push(
                mapper.map( newPost, Post.class) );
    }

    private List<PostDTO> getUserPosts(Integer id){
        return this.postRepository.findByUserId(id).stream()
                .map( post -> mapper.map( post, PostDTO.class ) )
                .collect(Collectors.toList());
    }

    public PostsResponseDTO getFollowedPostList(Integer id, String order) throws UserNotFoundException {
            Sorter sorter = MiFactory.getInstance(order == null ? "date_desc" : order );

            PostsResponseDTO response = new PostsResponseDTO();

            List<PostDTO> postsList = getFollowedList(id,null).stream().
                    flatMap(user -> getUserPosts(user.getUserId()).stream()).
                    sorted( (u,b) -> sorter.sort(u,b) ).
                    filter(post ->
                            post.getDate().compareTo(
                                    Date.from(
                                            LocalDate.now()
                                                    .minusDays(14)
                                                    .atStartOfDay(
                                                            ZoneId.systemDefault()
                                                    ).toInstant())) >0).
                    collect(Collectors.toList());

            response.setUserId(id);
            response.setPosts(postsList);

            return response;
    }


    public PostsResponseDTO getUserPostRequest(Integer id) throws UserNotFoundException {
        User user = this.getUserById(id);

        PostsResponseDTO response = new PostsResponseDTO();

        response.setUserId(user.getUserId());
        response.setPosts( getUserPosts(user.getUserId()));

        return response;
    }

    public CountPromosResponseDTO getPromoCount(Integer userId) throws UserNotFoundException {
        CountPromosResponseDTO response = new CountPromosResponseDTO();

        User user = this.getUserById(userId);

        Integer cantidad = Math.
                toIntExact(
                        postRepository.findByUserIdAndHasPromo( userId, true)
                                .stream().count()
                );

        response.setUserName(user.getUserName());
        response.setUserId(userId);
        response.setPromoproductsCount(cantidad);

        return response;
    }

    public PostsResponseDTO getPromoPosts(Integer userId) throws UserNotFoundException {
        User user = this.getUserById(userId);

        PostsResponseDTO response = new PostsResponseDTO();

        List<PostDTO> promoPosts =  postRepository
                .findByUserIdAndHasPromo(userId, true).stream()
                .map( post -> mapper.map(post, PostDTO.class) )
                .collect(Collectors.toList());

        response.setPosts(promoPosts);
        response.setUserId(user.getUserId());

        return response;
    }


}
