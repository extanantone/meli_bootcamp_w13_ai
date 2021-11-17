package com.example.socialmeli.services;

import com.example.socialmeli.Models.DetalleProduct;
import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;
import com.example.socialmeli.dto.*;
import com.example.socialmeli.exceptions.ErrorInOperation;
import com.example.socialmeli.exceptions.PostAlreadyCreated;
import com.example.socialmeli.exceptions.UserNoFound;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class UserServices implements IUsersServices{

    @Autowired
    IUserRepository repository ;

    @Override
    public EmptyJsonResponse followUser(Integer a, Integer b) {
        User currentUser = repository.getUserbyId(a);
        User userToFollow = repository.getUserbyId(b);
        if ( currentUser != null  && userToFollow != null) {
           Integer result = currentUser.addFolloweesList(userToFollow);
           Integer result2 = userToFollow.addFollowerList(currentUser);

           if (result !=  null  && result2 != null ){
               return new EmptyJsonResponse();
           }else{
               throw new UserNoFound();
           }
        }else  {
            throw new UserNoFound();
        }
    }

    @Override
    public EmptyJsonResponse unFollow(Integer a, Integer b) {
        User currentUser = repository.getUserbyId(a);
        User userToFollow = repository.getUserbyId(b);
        if ( currentUser != null  && userToFollow != null) {
            Integer result = currentUser.deleteFolloweesList(userToFollow);
            Integer result2 = userToFollow.deleteFollowerList(currentUser);

            if (result !=  null  && result2 != null ){
                return new EmptyJsonResponse();
            }else {
                throw new UserNoFound();
            }
        }else  {
            throw new UserNoFound();
        }

    }

    @Override
    public DTOResponseAmountUser getAmountFollowers(Integer i){
        User current = repository.getUserbyId(i);
        if ( current != null){
            DTOResponseAmountUser response = new DTOResponseAmountUser(current.getUserId(), current.getUsername(), current.getAmountFollowers());
            return response;
        }else{
            throw new UserNoFound();
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
            }
            DTOResponseListUser response = new DTOResponseListUser(current.getUserId(), current.getUsername(), listUsers);
            return response;
        }else{
            throw new UserNoFound();
        }
    }

    @Override
    public DTOResponseListUserFollowed getListFollowed(Integer i, String order) {
        User current = repository.getUserbyId(i);
        if (current != null) {
            DTOUserList x = new DTOUserList();
            ArrayList<DTOUserList> listUsers = x.userToDTO(current.getListFollowed());
            if (order.equals("name_asc")) {
                listUsers.sort(Comparator.comparing(DTOUserList::getUser_name));
            } else if (order.equals("name_desc")) {
                listUsers.sort(Comparator.comparing(DTOUserList::getUser_name).reversed());
            }
            DTOResponseListUserFollowed response = new DTOResponseListUserFollowed(current.getUserId(), current.getUsername(), listUsers);
            return response;
        }else{
            throw new UserNoFound();
        }
    }

    @Override
    public EmptyJsonResponse createProduct(DTOproductsRequest request) {
        User current = repository.getUserbyId(request.getUser_id());
        if (current == null){
            throw new UserNoFound();
        }
        Product product = new Product();
        try {
            product.setUser_id(request.getUser_id());
            product.setId_post(request.getId_post());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            product.setDate(request.getDate());
            DTOdetailRequest dtOdetailRequest = request.getDetail();
            DetalleProduct detalleProduct = new DetalleProduct(dtOdetailRequest.getProduct_id(), dtOdetailRequest.getProduct_name(), dtOdetailRequest.getType(), dtOdetailRequest.getBrand(), dtOdetailRequest.getColor(), dtOdetailRequest.getNotes());
            product.setDetail(detalleProduct);
            product.setCategory(request.getCategory());
            product.setPrice(request.getPrice());

        }catch (Exception e){
            throw new ErrorInOperation();
        }

        Integer response = repository.createPost(product);
        if (response == null){
            throw new PostAlreadyCreated();
        }
        return new EmptyJsonResponse();
    }


    public DTOResponseProduct getFeedProducts(Integer user_id, String order){
        User user =  repository.getUserbyId(user_id);
        if (user == null){
            throw new UserNoFound();
        }

        ArrayList<Integer> arrayFollowed = user.getArrayFolloweds();
        ArrayList<Product> arrayProduct = new ArrayList<>();
        ArrayList<Product> containerProducts = repository.getListProducts();

        for (Product x : containerProducts){
            if ( arrayFollowed.contains(x.getUser_id())){
                arrayProduct.add(x);
                System.out.println(x);
            }
        }

        if  (order.equals("date_asc")){
            arrayProduct.sort(Comparator.comparing(Product::getDate));
        }else{
            arrayProduct.sort(Comparator.comparing(Product::getDate).reversed());
        }


        ArrayList<DTOProducto> arrayDTOProduct = new ArrayList<>();
        for (Product product : arrayProduct){
            LocalDate dateNow = LocalDate.now();
            if ( !product.getDate().plusDays(14).isBefore(dateNow)){
                String formattedDate = product.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                arrayDTOProduct.add( new DTOProducto(product.getId_post(), formattedDate, product.getDetail(), product.getCategory(), product.getPrice()));
            }
        }




        DTOResponseProduct dtoResponseProduct = new DTOResponseProduct(user.getUserId(), arrayDTOProduct);
        return dtoResponseProduct;
    }

}
