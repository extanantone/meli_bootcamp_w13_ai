package com.bootcamp.SocialMeli.service.user;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.dto.user.*;
import com.bootcamp.SocialMeli.exception.*;
import com.bootcamp.SocialMeli.model.*;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final ISocialMeliRepository socialMeliRepository;

    public UserService(ISocialMeliRepository socialMeliRepository) {
        this.socialMeliRepository = socialMeliRepository;
    }

    @Override
    public ResponseDTO follow(int userId, int userIdToFollow) {
        User userFollower = socialMeliRepository.findUser(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        User userFollowed = socialMeliRepository.findUser(userIdToFollow)
                .orElseThrow(() -> new UserNotFoundException(userIdToFollow));

        if (userFollower != userFollowed && !userFollower.getFollowed().contains(userFollowed)) {
            userFollower.getFollowed().add(userFollowed);
            userFollowed.getFollowers().add(userFollower);
        } else {
            throw new DeniedActionException();
        }

        return new ResponseDTO("performed_action", "Acción Realizada");
    }

    @Override
    public ResponseDTO unfollow(int userId, int userIdToUnfollow) {
        User userFollower = socialMeliRepository.findUser(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        User userFollowed = socialMeliRepository.findUser(userIdToUnfollow)
                .orElseThrow(() -> new UserNotFoundException(userIdToUnfollow));

        if (userFollower != userFollowed && userFollower.getFollowed().contains(userFollowed)) {
            userFollower.getFollowed().remove(userFollowed);
            userFollowed.getFollowers().remove(userFollower);
        } else {
            throw new DeniedActionException();
        }

        return new ResponseDTO("performed_action", "Acción Realizada");
    }

    @Override
    public UserFollowersCountDTO followersCount(int userId) {
        User user = socialMeliRepository.findUser(userId).orElseThrow(() -> new UserNotFoundException(userId));

        return new UserFollowersCountDTO(userId, user.getUserName(), user.getFollowers().size());
    }

    @Override
    public UserFollowersListDTO followersList(int userId, String order) {
        User user = socialMeliRepository.findUser(userId).orElseThrow(() -> new UserNotFoundException(userId));

        List<UserDTO> followersListDTO = user.getFollowers().stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName())).collect(Collectors.toList());

        if (order != null) {
            orderList(followersListDTO, order);
        }

        return new UserFollowersListDTO(userId, user.getUserName(), followersListDTO);
    }

    @Override
    public UserFollowedListDTO followedList(int userId, String order) {
        User user = socialMeliRepository.findUser(userId).orElseThrow(() -> new UserNotFoundException(userId));

        List<UserDTO> followedListDTO = user.getFollowed().stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName())).collect(Collectors.toList());

        if (order != null) {
            orderList(followedListDTO, order);
        }

        return new UserFollowedListDTO(userId, user.getUserName(), followedListDTO);
    }

    private void orderList(List<UserDTO> list, String order) {
        if (order.equalsIgnoreCase("name_asc")) {
            list.sort(Comparator.comparing(UserDTO::getUserName));
        } else if (order.equalsIgnoreCase("name_desc")) {
            list.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        } else if (!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }
}