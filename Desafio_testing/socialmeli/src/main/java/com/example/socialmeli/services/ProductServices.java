package com.example.socialmeli.services;

import com.example.socialmeli.Models.DetalleProduct;
import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;
import com.example.socialmeli.dto.DTORequest.DTOdetailRequest;
import com.example.socialmeli.dto.DTORequest.DTOproductsRequest;
import com.example.socialmeli.dto.DTOResponses.DTOProductoResponse;
import com.example.socialmeli.dto.DTOResponses.DTOResponseAmountUser;
import com.example.socialmeli.dto.DTOResponses.DTOResponseProduct;
import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;
import com.example.socialmeli.exceptions.ErrorInOperation;
import com.example.socialmeli.exceptions.OrderNoFound;
import com.example.socialmeli.exceptions.PostAlreadyCreated;
import com.example.socialmeli.exceptions.UserNoFound;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices implements IProductServices {
    @Autowired
    IUserRepository repository;

    private void checkUser(Integer i){
        if ( i != null){
            User current = repository.getUserbyId(i);
            if (current == null){
                throw new UserNoFound(i);
            }
        }else{
            throw new UserNoFound( );
        }
    }

    private boolean checkNulls(Product product, DTOdetailRequest dtOdetailRequest){
        if ( product.getId_post() == null || product.getDate() == null || dtOdetailRequest.getProduct_id() == null || product.getPrice() <= 0 || dtOdetailRequest.getProduct_name() == null ) {
            throw new ErrorInOperation();
        }
        return true;
    }

    private Product mappingModel(Product product, DTOproductsRequest request ){
        product.setUser_id(request.getUser_id());
        product.setId_post(request.getId_post());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        product.setDate(request.getDate());
        DTOdetailRequest dtOdetailRequest = request.getDetail();
        DetalleProduct detalleProduct = new DetalleProduct(dtOdetailRequest.getProduct_id(), dtOdetailRequest.getProduct_name(), dtOdetailRequest.getType(), dtOdetailRequest.getBrand(), dtOdetailRequest.getColor(), dtOdetailRequest.getNotes());
        product.setDetail(detalleProduct);
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        checkNulls(product, dtOdetailRequest);
        return product;
    }

    private void orderList(ArrayList<Product> arrayPromo, String order ){
        if  (order.equals("date_asc")){
            arrayPromo.sort(Comparator.comparing(Product::getDate));
        }else if (order.equals("date_desc")){
            arrayPromo.sort(Comparator.comparing(Product::getDate).reversed());
        }else{
            throw new OrderNoFound();
        }

    }


    @Override
    public DTOEmptyJsonResponse createProduct(DTOproductsRequest request) {
        checkUser(request.getUser_id());
        Product product = new Product();
        try {
            mappingModel(product, request);
        }catch (Exception e){
            throw new ErrorInOperation();
        }

        Integer response = repository.createPost(product);
        if (response == null){
            throw new PostAlreadyCreated();
        }
        return new DTOEmptyJsonResponse();
    }

    @Override
    public DTOEmptyJsonResponse createProductPromo(DTOproductsRequest request) {
        checkUser(request.getUser_id());
        Product product = new Product();
        try {
            mappingModel(product, request);
            product.setHas_promo(request.getHas_promo());
            product.setDiscount(request.getDiscount());

            if ( product.getHas_promo() == false ) {
                throw new ErrorInOperation();
            }

        }catch (Exception e){
            throw new ErrorInOperation();
        }

        Integer response = repository.createPostPromo(product);
        if (response == null){
            throw new PostAlreadyCreated();
        }
        return new DTOEmptyJsonResponse();
    }

    @Override
    public DTOResponseProduct getFeedProducts(Integer user_id, String order) {
        checkUser(user_id);
        User user =  repository.getUserbyId(user_id);

        ArrayList<Integer> arrayFollowed = user.getArrayFolloweds();
        ArrayList<Product> arrayProduct = new ArrayList<>();
        ArrayList<Product> containerProducts = repository.getListProducts();

        for (Product x : containerProducts){
            if ( arrayFollowed.contains(x.getUser_id())){
                arrayProduct.add(x);
            }
        }
        orderList(arrayProduct, order);

        ArrayList<DTOProductoResponse> arrayDTOProduct = new ArrayList<>();
        for (Product product : arrayProduct){
            LocalDate dateNow = LocalDate.now();
            if ( !product.getDate().plusDays(14).isBefore(dateNow)){
                String formattedDate = product.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                arrayDTOProduct.add( new DTOProductoResponse(product.getId_post(), formattedDate, product.getDetail(), product.getCategory(), product.getPrice()));
            }
        }

        DTOResponseProduct dtoResponseProduct = new DTOResponseProduct(user.getUserId(), arrayDTOProduct, null);
        return dtoResponseProduct;
    }

    @Override
    public DTOResponseAmountUser getAmountProductsPromo(Integer user_id) {
        checkUser(user_id);
        User user =  repository.getUserbyId(user_id);

        int count = repository.getListProductsPromo().stream().filter(c -> c.getUser_id() == user_id).collect(Collectors.toList()).size();
        DTOResponseAmountUser response = new DTOResponseAmountUser(user.getUserId(), user.getUsername(),null, count );
        return response;
    }

    @Override
    public DTOResponseProduct getPromos(Integer user_id, String order) {
        checkUser(user_id);
        User user =  repository.getUserbyId(user_id);

        ArrayList<Product> arrayPromo = new ArrayList<>();
        List<Product> listPromo = repository.getListProductsPromo().stream().filter(c -> c.getUser_id() == user_id).collect(Collectors.toList());
        System.out.println((listPromo));

        for (Product x : listPromo){
            arrayPromo.add(x);
        }

        orderList(arrayPromo, order);

        ArrayList<DTOProductoResponse> arrayDTOProductPromo= new ArrayList<>();
        for (Product product : arrayPromo){
            LocalDate dateNow = LocalDate.now();
            String formattedDate = product.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            arrayDTOProductPromo.add( new DTOProductoResponse(product.getId_post(), formattedDate, product.getDetail(), product.getCategory(), product.getPrice(), product.getHas_promo(), product.getDiscount()));
        }

        DTOResponseProduct dtoResponseProductPromo = new DTOResponseProduct(user.getUserId(), arrayDTOProductPromo, user.getUsername());
        return dtoResponseProductPromo;
    }
}
