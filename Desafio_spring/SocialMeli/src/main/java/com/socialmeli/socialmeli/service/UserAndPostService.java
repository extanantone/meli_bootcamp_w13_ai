package com.socialmeli.socialmeli.service;

import com.socialmeli.socialmeli.dto.ResponseSuccessfullyDTO;
import com.socialmeli.socialmeli.dto.post.*;
import com.socialmeli.socialmeli.dto.user.UserFollowerCountDTO;
import com.socialmeli.socialmeli.dto.user.UserFollowersListDTO;
import com.socialmeli.socialmeli.exceptions.postExceptions.ExistingPostException;
import com.socialmeli.socialmeli.exceptions.userExceptions.*;
import com.socialmeli.socialmeli.mapper.PostMapper;
import com.socialmeli.socialmeli.mapper.UserMapper;
import com.socialmeli.socialmeli.model.Post;
import com.socialmeli.socialmeli.model.User;
import com.socialmeli.socialmeli.repository.PostRepository;
import com.socialmeli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class UserAndPostService implements UserAndPostServiceI {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    ResponseSuccessfullyDTO responseSuccessfullyDTO;

    @Override
    public Map<String,Object> addFollower(int user_id, int user_id_to_follow) {
        if (user_id>=0 && user_id_to_follow>=0){
            if (user_id != user_id_to_follow){
                String answer = userRepository.addFollow(user_id,user_id_to_follow);
                switch(answer){
                    case "true":
                        return responseSuccessfullyDTO.buildJson("User "+userRepository.getUserName(user_id)+" now follow "+userRepository.getUserName(user_id_to_follow));
                    case "existingRelationship":
                        throw new ExistingRelationshipException(user_id,user_id_to_follow);

                    case "notExistentUserToFollow":
                        throw new NotFoundUserException(user_id_to_follow);

                    case "notExistentUser":
                        throw new NotFoundUserException(user_id);
                    default:
                        return responseSuccessfullyDTO.buildJson("default");
                }
            } else {
                throw new FollowYourselfException(user_id);
            }
        } else {
            throw new NegativeIdException(user_id<0?user_id:user_id_to_follow);
        }


    }

    @Override
    public UserFollowerCountDTO countFollowersUser(int user_id) {
        if (user_id>=0){
            if (userRepository.userExists(user_id)){
                return userMapper.userToUserFollowerDTO(userRepository.getUser(user_id));
            } else{
                throw new NotFoundUserException(user_id);
            }
        } else{
            throw new NegativeIdException(user_id);
        }

    }

    @Override
    public UserFollowersListDTO listUserFollowex(int user_id, boolean isFollowersList, String order) {
        if (user_id>=0) {
            if (userRepository.userExists(user_id)) {
                User user = userRepository.getUser(user_id);
                UserFollowersListDTO userFollowersList = new UserFollowersListDTO(user.getUser_id(),user.getUser_name(),isFollowersList);

                List<Integer> followexList =isFollowersList? user.getFollowers():user.getFollowed();
                for (Integer idUser: followexList) {
                    User followersUser = userRepository.getUser(idUser);
                    userFollowersList.addFollowers(userMapper.userToUserDTO(followersUser),isFollowersList);
                }

                if (order != null && order.contains("name_desc")) {
                    Collections.sort(isFollowersList?userFollowersList.getFollowers():userFollowersList.getFollowed(), Collections.reverseOrder());
                } else {
                    Collections.sort(isFollowersList?userFollowersList.getFollowers():userFollowersList.getFollowed());
                }
                return userFollowersList;
            } else{
                throw new NotFoundUserException(user_id);
            }
        } else{
            throw new NegativeIdException(user_id);
        }

    }

    public Map<String,Object> newPost(PostDTO postDTO) {
        String result = postRepository.newPost(postMapper.postDTOToPost(postDTO));
        switch (result) {
            case "true":
                return responseSuccessfullyDTO.buildJson("Post created");
            case "postExist":
                throw new ExistingPostException(postDTO.getId_post());
            case "userExist":
                throw new NotFoundUserException(postDTO.getUser_id());
            default:
                return responseSuccessfullyDTO.buildJson("error");
        }
    }

    public FollowedSellerPostDTO followedSellersPost(int user_id,String order){
        if(userRepository.userExists(user_id)) {

            FollowedSellerPostDTO followedSellerPostDTO = new FollowedSellerPostDTO(user_id);

            List<Integer> followedList = userRepository.getUser(user_id).getFollowed();

            List<PostWithoutDiscountDTO> listPostDTO = new ArrayList<>();
            followedList.forEach(elem -> {
                List<Integer> publicationList = userRepository.getUser(elem).getPublication();

                publicationList.forEach(item -> {
                    Post pr = postRepository.getPost(item);

                    long daysBetween = DAYS.between(pr.getDate(), LocalDate.now());
                    if (daysBetween < 14) {
                        listPostDTO.add(postMapper.postDTOToPostWithoutDiscount(pr));
                    }
                });
            });

            if (order != null && order.contains("date_desc")) {
                Collections.sort(listPostDTO, Collections.reverseOrder());
                //Collections.sort(userFollowersList.getFollowers(), Collections.reverseOrder());
            } else {
                Collections.sort(listPostDTO);
               // Collections.sort(userFollowersList.getFollowers());
            }
            followedSellerPostDTO.setPosts(listPostDTO);

            return followedSellerPostDTO;
        } else{
            throw new NotFoundUserException(user_id);
        }
    }


    public Map<String,Object> unfollow(int user_id, int user_id_to_unfollow) {
        if (user_id>=0 && user_id_to_unfollow>=0){
            if (user_id != user_id_to_unfollow){
                String answer = userRepository.unfollow(user_id,user_id_to_unfollow);//userRepository.addFollow(user_id,user_id_to_follow);
                switch(answer){
                    case "true":
                        return responseSuccessfullyDTO.buildJson("User "+userRepository.getUserName(user_id)+" now unfollow "+userRepository.getUserName(user_id_to_unfollow));
                    case "notExistingRelationship":
                        throw new NotExistingRelationshipException(user_id,user_id_to_unfollow);
                    case "notExistentUserToFollow":
                        throw new NotFoundUserException(user_id_to_unfollow);
                    case "notExistentUser":
                        throw new NotFoundUserException(user_id);
                    default:
                        return responseSuccessfullyDTO.buildJson("default");
                }
            } else {
                throw new UnfollowYourselfException(user_id);
            }
        } else {
            throw new NegativeIdException(user_id<0?user_id:user_id_to_unfollow);
        }


    }

    @Override
    public PostPromoCountDTO countPromoPost(int user_id) {
        if (user_id>=0) {
            if (userRepository.userExists(user_id)) {
                User seller = userRepository.getUser(user_id);
                int count =(int) seller.getPublication().stream().filter(e->postRepository.getPost(e).isHas_promo()).count();
                return new PostPromoCountDTO(seller.getUser_id(),seller.getUser_name(),count);
            } else{
                throw new NotFoundUserException(user_id);
            }
        } else{
            throw new NegativeIdException(user_id);
        }
    }

    @Override
    public ListPromoPostDTO ListPromoPost(int user_id) {
        if (user_id>=0) {
            if (userRepository.userExists(user_id)) {
                User user = userRepository.getUser(user_id);
                List<Integer> publicationList = user.getPublication();
                List<PostDTO> postDTOList = publicationList.stream().filter(x->postMapper.postDTOToPost(postRepository.getPost(x)).isHas_promo()).map(e->postMapper.postDTOToPost(postRepository.getPost(e))).collect(Collectors.toList());
                return new ListPromoPostDTO(user.getUser_id(),user.getUser_name(),postDTOList);
            } else{
                throw new NotFoundUserException(user_id);
            }
        } else{
            throw new NegativeIdException(user_id);
        }

    }

}
