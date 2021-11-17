package com.bootcamp.socialmeli.util;

import com.bootcamp.socialmeli.dto.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class OrderUtils {

    public FollowerListResponseDTO order(FollowerListResponseDTO dto, String order){
        if(order == null) return dto;
        String direction = order.split("_")[1];
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
        if(direction.equals("desc")){
            comparator = (o1, o2) -> o1.getUserName().compareTo(o2.getUserName())*-1;
        }
        dto.getFollowers().sort(comparator);
        return dto;
    }

    public FollowedListResponseDTO order(FollowedListResponseDTO dto, String order){
        if(order == null) return dto;
        String direction = order.split("_")[1];
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
        if(direction.equals("desc")){
            comparator = (o1, o2) -> o1.getUserName().compareTo(o2.getUserName())*-1;
        }
        dto.getFollowed().sort(comparator);
        return dto;
    }

    public Ordenable order(Ordenable dto, String order){
        if(order == null) return dto;
        String direction = order.split("_")[1];
        Comparator<ListedPostDTO> comparator = Comparator.comparing(ListedPostDTO::getDate);
        if(direction.equals("desc")){
            comparator = (o1, o2) -> o1.getDate().compareTo(o2.getDate())*-1;
        }
        dto.getPosts().sort(comparator);
        return dto;
    }
}
