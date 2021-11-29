package com.example.socialmeli.services;

import com.example.socialmeli.Models.User;
import com.example.socialmeli.dto.DTOResponses.DTOResponseAmountUser;
import com.example.socialmeli.dto.DTOResponses.DTOResponseListUser;
import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;
import com.example.socialmeli.dto.DTOResponses.DTOUserList;
import com.example.socialmeli.exceptions.ActionPrevioslyComplete;
import com.example.socialmeli.exceptions.ActionRedundant;
import com.example.socialmeli.exceptions.OrderNoFound;
import com.example.socialmeli.exceptions.UserNoFound;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;


@Service
public class UserServices implements IUsersServices{

    @Autowired
    IUserRepository repository ;

    @Override
    public DTOEmptyJsonResponse followUser(Integer a, Integer b) {
        if (a == b){
            throw new ActionRedundant();
        }
        User currentUser = repository.getUserbyId(a);
        User userToFollow = repository.getUserbyId(b);
        if ( currentUser != null  && userToFollow != null) {
           Integer result = currentUser.addFolloweesList(userToFollow);
           Integer result2 = userToFollow.addFollowerList(currentUser);

           if (result !=  null  && result2 != null ){
               return new DTOEmptyJsonResponse();
           }else{

               throw new ActionPrevioslyComplete();
           }
        }else  {
            throw new UserNoFound(currentUser == null ? a : b);
        }
    }

    @Override
    public DTOEmptyJsonResponse unFollow(Integer a, Integer b) {
        if (a == b){
            throw new ActionRedundant();
        }
        User currentUser = repository.getUserbyId(a);
        User userToFollow = repository.getUserbyId(b);
        if ( currentUser != null  && userToFollow != null) {
            Integer result = currentUser.deleteFolloweesList(userToFollow);
            Integer result2 = userToFollow.deleteFollowerList(currentUser);

            if (result !=  null  && result2 != null ){
                return new DTOEmptyJsonResponse();
            }else {
                throw new ActionPrevioslyComplete();
            }
        }else  {
            throw new UserNoFound(currentUser == null ? a : b);
        }

    }

    @Override
    public DTOResponseAmountUser getAmountFollowers(Integer i){
        User current = repository.getUserbyId(i);
        if ( current != null){
            DTOResponseAmountUser response = new DTOResponseAmountUser(current.getUserId(), current.getUsername(), current.getAmountFollowers(), null);
            return response;
        }else{
            throw new UserNoFound(i);
        }
    }

    @Override
    public DTOResponseListUser getListFollowers(Integer i, String order) {
        User current = repository.getUserbyId(i);
        if (current != null){
            DTOUserList x = new DTOUserList();
            ArrayList<DTOUserList> listUsers = x.userToDTO(current.getListFollowers());

            if  (order.equals("name_asc")){
                listUsers.sort(Comparator.comparing(DTOUserList::getUser_name));
            }else if (order.equals("name_desc")){
                listUsers.sort(Comparator.comparing(DTOUserList::getUser_name).reversed());
            }else {
                throw new OrderNoFound();
            }
            DTOResponseListUser response = new DTOResponseListUser(current.getUserId(), current.getUsername(), listUsers, null);
            return response;
        }else{
            throw new UserNoFound(i);
        }
    }

    @Override
    public DTOResponseListUser getListFollowed(Integer i, String order) {
        User current = repository.getUserbyId(i);
        if (current != null) {
            DTOUserList x = new DTOUserList();
            ArrayList<DTOUserList> listUsers = x.userToDTO(current.getListFollowed());
            if (order.equals("name_asc")) {
                listUsers.sort(Comparator.comparing(DTOUserList::getUser_name));
            } else if (order.equals("name_desc")) {
                listUsers.sort(Comparator.comparing(DTOUserList::getUser_name).reversed());
            }else {
                throw new OrderNoFound();
            }
            DTOResponseListUser response = new DTOResponseListUser(current.getUserId(), current.getUsername(), null ,listUsers);
            return response;
        }else{
            throw new UserNoFound(i);
        }
    }

}
