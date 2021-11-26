package com.example.socialmeli.service.user;

import com.example.socialmeli.mapper.FollowerMapper;
import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.dto.user.FollowerCountDTO;
import com.example.socialmeli.dto.user.FollowerListDTO;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.user.IUserRepository;
import org.modelmapper.Converter;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService
{
    @Autowired
    IUserRepository userRepository;

    @Autowired
    FollowerMapper followerMapper;

    private User getUser(int userId) throws BadRequestException
    {

        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");
        return (userMap.get(userId));
    }

    @Override
    public FollowedListDTO followed(int userId, String order) throws BadRequestException
    {
        User user = getUser(userId);
        ModelMapper modelMapper = new ModelMapper();
        List<User> followedOrder = null;
        if (order != null)
        {
            if (order.equals("name_asc"))
                followedOrder = userRepository.findFollowedOrderByNameAsc(userId);
            else
                followedOrder = userRepository.findFollowedOrderByNameDesc(userId);
        }
        else
        {
            followedOrder = user.getFollowed();
        }
        TypeMap<User, FollowedListDTO> typeMap = modelMapper.createTypeMap(User.class, FollowedListDTO.class);
        List<User> finalFollowedOrder = followedOrder;
       typeMap.addMappings(mapper -> mapper.map(src -> followerMapper.userToFollowerDTO(finalFollowedOrder),
                FollowedListDTO::setFollowed));
        return modelMapper.map(user, FollowedListDTO.class);
    }

    @Override
    public FollowerListDTO followers(int userId, String order) throws BadRequestException
    {
        User user = getUser(userId);
        List<User> followersOrder = null;
        if (order != null)
        {
            if (order.equals("name_asc"))
                followersOrder = userRepository.findFollowersOrderByNameAsc(userId);
            else
                followersOrder = userRepository.findFollowersOrderByNameDesc(userId);
        }
        else
            followersOrder = user.getFollowers();
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, FollowerListDTO> typeMap = modelMapper.createTypeMap(User.class, FollowerListDTO.class);
        List<User> finalFollowerOrder = followersOrder;
        typeMap.addMappings(mapper -> mapper.map(src -> followerMapper.userToFollowerDTO(finalFollowerOrder),
                FollowerListDTO::setFollowers));
        return modelMapper.map(user, FollowerListDTO.class);
    }

    @Override
    public FollowerCountDTO countFollowers(int userId) throws BadRequestException
    {
        User user = getUser(userId);
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, FollowerCountDTO> propertyMapper = modelMapper.createTypeMap(User.class, FollowerCountDTO.class);
        Converter<Collection, Integer> collectionToSize = c -> c.getSource().size();
        propertyMapper.addMappings(
                mapper -> mapper.using(collectionToSize).map(User::getFollowers, FollowerCountDTO::setFollowersCount)
        );
        return modelMapper.map(user, FollowerCountDTO.class);
    }

    @Override
    public FollowedListDTO follow(int userId, int userIdToFollow) throws BadRequestException
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId) || !userMap.containsKey(userIdToFollow))
            throw new BadRequestException("Usuario no encontrado");

        User user, userToFollow;
        user = userMap.get(userId);
        userToFollow = userMap.get(userIdToFollow);
        if (!user.follow(userToFollow))
            throw new BadRequestException("No puedes seguir a este usuario");

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowedListDTO.class);
    }

    @Override
    public FollowedListDTO unfollow(int userId, int userIdToUnfollow) throws BadRequestException
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId) || !userMap.containsKey(userIdToUnfollow))
            throw new BadRequestException("Usuario no encontrado");

        User user, userToUnfollow;
        user = userMap.get(userId);
        userToUnfollow = userMap.get(userIdToUnfollow);
        if (!user.unfollow(userToUnfollow))
            throw new BadRequestException("No puedes dejar de seguir a este usuario");

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowedListDTO.class);
    }
}
