package com.bootcamp.socialmeli.util;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.exception.IllegalRequestParamException;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class OrderUtils {

    public FollowerListResponseDTO order(FollowerListResponseDTO dto, String order){
        if(order == null) return dto;
        String[] temp = order.split("_");
        String criteria = temp[0];
        String direction = temp[1];
        validateOrderDirection(criteria, direction);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
        if(direction.equals("desc")){
            comparator = (o1, o2) -> o1.getUserName().compareTo(o2.getUserName())*-1;
        }
        dto.getFollowers().sort(comparator);
        return dto;
    }

    public FollowedListResponseDTO order(FollowedListResponseDTO dto, String order){
        if(order == null) return dto;
        String[] temp = order.split("_");
        String criteria = temp[0];
        String direction = temp[1];
        validateOrderDirection(criteria, direction);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);
        if(direction.equals("desc")){
            comparator = (o1, o2) -> o1.getUserName().compareTo(o2.getUserName())*-1;
        }
        dto.getFollowed().sort(comparator);
        return dto;
    }

    public Ordenable order(Ordenable dto, String order){
        if(order == null) return dto;
        String[] temp = order.split("_");
        String criteria = temp[0];
        String direction = temp[1];
        validateOrderDirection(criteria, direction);
        Comparator<ListedPostDTO> comparator = Comparator.comparing(ListedPostDTO::getDate);
        if(direction.equals("desc")){
            comparator = (o1, o2) -> o1.getDate().compareTo(o2.getDate())*-1;
        }
        dto.getPosts().sort(comparator);
        return dto;
    }

    public void validateOrderDirection( String criteria, String direction){
        if(!criteria.equals("name") && !criteria.equals("date")) throw new IllegalRequestParamException("Valor ilegal para el request param order.");
        if(!direction.equals("asc") && !direction.equals("desc")) throw new IllegalRequestParamException("Valor ilegal para el request param order.");
    }
}
