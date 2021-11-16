package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.exceptions.PostAlreadyExistException;
import meli.bootcamp.socialmeli.mapper.PostMapper;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.repository.PostRepository;
import meli.bootcamp.socialmeli.repository.UserFollowRepository;
import meli.bootcamp.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFollowRepository userFollowRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public void followUser(int userID, int userIDToFollow) {
        User followerUser= userRepository.findUserById(userID);
        User userToFollow= userRepository.findUserById(userIDToFollow);
        userFollowRepository.newUserFollow(followerUser.getUserId(), userToFollow.getUserId());
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userID) {
        return new FollowersCountDTO(
                userID,
                userRepository.getUserNameById(userID),
                userFollowRepository.listUserFollowersByID(userID).size());
    }

    @Override
    public FollowersListDTO getFollowersList(int userID) {
        return new FollowersListDTO(
                userID,
                userRepository.getUserNameById(userID),
                this.getSpecificList(true, userID));
    }

    @Override
    public FollowersListDTO getFollowedList(int userID) {
        return new FollowersListDTO(
                userID,
                userRepository.getUserNameById(userID),
                this.getSpecificList(false, userID));
    }

    @Override
    public void addPost(ProductsPostDTO newPost) {
        userRepository.findUserById(newPost.getUser_id());
        if (postRepository.findPostById(newPost.getId_post()) == null)
            postRepository.addPost(postMapper.productoPostDTOtoPost(newPost));
        else
            throw new PostAlreadyExistException();
    }

    private List<UserDTO> getSpecificList(boolean searchFollowers, int userID){
        return userFollowRepository.getAllList().stream()
                .filter(userFollow ->
                        (searchFollowers)
                                ?userFollow.getFollowedUser() == userID
                                :userFollow.getUserFollower() == userID)
                .map(nUserDTO -> new UserDTO(
                        (searchFollowers)
                                ?nUserDTO.getUserFollower()
                                :nUserDTO.getFollowedUser(),
                        userRepository.getUserNameById(
                                (searchFollowers)
                                        ?nUserDTO.getUserFollower()
                                        :nUserDTO.getFollowedUser())))
                .collect(Collectors.toList());
    }

    @Override
    public ProductsUserIDListDTO listSortedPostByUserID(int user_id){
        List<Post> tempList= postRepository.findSortedByDatePostsByUserID(user_id);
        return new ProductsUserIDListDTO(
                user_id,
                tempList.stream()
                        .map(post -> postMapper.postToProductsPostByUserDTO(post))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public List<UserFollow> lista(){
        return userFollowRepository.getAllList();
    }

    @Override
    public List<Post> listaPost(){
        return postRepository.getAllList();
    }

    @Override
    public void unfollowUser(int userID, int userIDToFollow) {
        User followerUser= userRepository.findUserById(userID);
        User userToFollow= userRepository.findUserById(userIDToFollow);
        userFollowRepository.checkUserFollow(followerUser.getUserId(), userToFollow.getUserId());
        userFollowRepository.unfollowUser(followerUser.getUserId(), userToFollow.getUserId());
    }
}
