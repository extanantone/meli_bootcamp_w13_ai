package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.CompradorDTO;
import com.bootcamp.socialmeli.dto.UserCountDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.dto.VendedorDTO;
import com.bootcamp.socialmeli.exception.FollowFound;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IVendedorRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VendedorService implements IVendedorService {

    IVendedorRepository vendedorRepository;

    ModelMapper mapper = new ModelMapper();


    public VendedorService(IVendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }


    //US0001
    @Override
    public void addFollower(long idFollowed, long idFollwer) {

        vendedorRepository.addFollow(idFollowed, idFollwer);
    }

    //US0002
    @Override
    public UserCountDTO getFollowersCount(long idUser) {
        User followedUser = vendedorRepository.getUser(idUser);
        return new UserCountDTO(followedUser.getUserId(), followedUser.getUserName(), followedUser.getFollowersCount());
    }

    //US0003
    @Override
    public VendedorDTO getFollowersList(long idUser, String order) {
        User followedUser = vendedorRepository.getUser(idUser);
        List<UserDTO> followers = vendedorRepository.getFollowers(idUser).stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
        if (!Objects.isNull(order)) {
            followers = orderUserByName(followers, order);
        }
        return new VendedorDTO(followedUser.getUserId(), followedUser.getUserName(), followers);
    }

    //US0004
    @Override
    public CompradorDTO getFollowedsList(long idUser) {
        User followedUser = vendedorRepository.getUser(idUser);
        List<UserDTO> followers = vendedorRepository.getFolloweds(idUser).stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
        return new CompradorDTO(followedUser.getUserId(), followedUser.getUserName(), followers);
    }

    @Override
    public void unFollow(Long idFollower, Long idFollowed) {

        this.vendedorRepository.unFollow(idFollower, idFollowed);
    }

    private List<UserDTO> orderUserByName(List<UserDTO> users, String order) {
        Comparator<UserDTO> orderType;
        if (order.equals("name_asc")) {
            orderType = Comparator.comparing(UserDTO::getUserName);
        } else if (order.equals("name_desc")) {
            orderType = Comparator.comparing(UserDTO::getUserName,
                    Collections.reverseOrder());
        } else return null;
        return this.sortedUser(users, orderType);
    }

    private List<UserDTO> sortedUser(List<UserDTO> users,
                                     Comparator<UserDTO> orderType) {
        return users.stream().sorted(orderType).collect(Collectors.toList());
    }


}
