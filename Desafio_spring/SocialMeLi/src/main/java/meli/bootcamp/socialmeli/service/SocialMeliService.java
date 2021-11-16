package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.exceptions.PostAlreadyExistException;
import meli.bootcamp.socialmeli.mapper.PostMapper;
import meli.bootcamp.socialmeli.mapper.PromoProductMapper;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.repository.PostRepository;
import meli.bootcamp.socialmeli.repository.PromoPostRepository;
import meli.bootcamp.socialmeli.repository.UserFollowRepository;
import meli.bootcamp.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
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
    private PromoPostRepository promoPostRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PromoProductMapper promoPostMapper;

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
                this.getSpecificUserNameList(true, userID));
    }

    @Override
    public FollowersListDTO getFollowedList(int userID) {
        return new FollowersListDTO(
                userID,
                userRepository.getUserNameById(userID),
                this.getSpecificUserNameList(false, userID));
    }

    @Override
    public void addPost(ProductsPostDTO newPost) {
        userRepository.findUserById(newPost.getUser_id());
        if (postRepository.findPostById(newPost.getId_post()) == null)
            postRepository.addPost(postMapper.productoPostDTOtoPost(newPost));
        else
            throw new PostAlreadyExistException();
    }

    private List<UserDTO> getSpecificUserNameList(boolean searchFollowers, int userID){
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

    private List<ProductsPostByUserDTO> getSpecificDateList(String order, int userID){
        return postRepository.getAllList().stream()
                .filter(post ->
                        (userFollowRepository.getAllList().stream()
                            .filter(userFollow -> userFollow.getUserFollower() == userID)
                            .map(UserFollow::getFollowedUser)
                            .collect(Collectors.toList())).contains(post.getUserId())
                )
                .sorted((order.equals("name_desc"))
                        ?Comparator.comparing(Post::getDate).reversed()
                        :Comparator.comparing(Post::getDate)
                )
                .map(post -> postMapper.postToProductsPostByUserDTO(post))
                .collect(Collectors.toList());
    }

    @Override
    public ProductsUserIDListDTO listSortedPostByUserID(int user_id){
        List<Post> tempList= postRepository.getAllList().stream()
                .filter(post ->
                        (userFollowRepository.getAllList().stream()
                                .filter(userFollow -> userFollow.getUserFollower() == user_id)
                                .map(UserFollow::getFollowedUser)
                                .collect(Collectors.toList())).contains(post.getUserId())
                )
                .collect(Collectors.toList());
        return new ProductsUserIDListDTO(
                user_id,
                tempList.stream()
                        .map(post -> postMapper.postToProductsPostByUserDTO(post))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ProductsUserIDListDTO listSortedPostByUserID(int user_id, String order){
        System.out.println(order);
        return new ProductsUserIDListDTO(
                user_id,
                this.getSpecificDateList(order, user_id)
        );
    }

    @Override
    public List<UserFollow> lista(){
        return userFollowRepository.getAllList();
    }

    @Override
    public List<Post> listaPost(){ return postRepository.getAllList(); }

    @Override
    public List<PromoPost> listaPromoPost(){ return promoPostRepository.getAllList(); }

    @Override
    public void unfollowUser(int userID, int userIDToFollow) {
        User followerUser= userRepository.findUserById(userID);
        User userToFollow= userRepository.findUserById(userIDToFollow);
        userFollowRepository.checkUserFollow(followerUser.getUserId(), userToFollow.getUserId());
        userFollowRepository.unfollowUser(followerUser.getUserId(), userToFollow.getUserId());
    }

    @Override
    public FollowersListDTO getOrderedFollowersList(int userID, boolean searchFollowers, String order, boolean sortedResponse) {

        return new FollowersListDTO(
                userID,
                userRepository.getUserNameById(userID),
                (sortedResponse)
                ?this.getSpecificUserNameList(searchFollowers, userID).stream()
                        .sorted((order.equals("name_desc"))
                            ?Comparator.comparingInt(UserDTO::getUserID).reversed()
                            :Comparator.comparingInt(UserDTO::getUserID))
                    .collect(Collectors.toList())
                :this.getSpecificUserNameList(searchFollowers, userID)
        );
    }

    @Override
    public void newPromoPost(ProductsPromoPostDTO productsPromoPostDTO) {
        userRepository.findUserById(productsPromoPostDTO.getUser_id());
        if (promoPostRepository.findPromoPostById(productsPromoPostDTO.getId_post()) == null)
            promoPostRepository.addPromoPost(promoPostMapper.productoPromoPostDTOtoPromoPost(productsPromoPostDTO));
        else
            throw new PostAlreadyExistException();
    }

    @Override
    public PromoPostCountDTO countPromoPost(int userID) {
        return new PromoPostCountDTO(
                userID,
                userRepository.getUserNameById(userID),
                (int) promoPostRepository.getAllList().stream()
                    .filter(post -> post.getUserId() == userID).count()
        );
    }
}
