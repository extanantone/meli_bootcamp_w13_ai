package com.bootcamp.socialmeliSprint1.service;

import com.bootcamp.socialmeliSprint1.dto.comparator.PostDateComparator;
import com.bootcamp.socialmeliSprint1.dto.comparator.SortOrder;
import com.bootcamp.socialmeliSprint1.dto.request.PostInDTO;
import com.bootcamp.socialmeliSprint1.dto.request.PostInPromoDTO;
import com.bootcamp.socialmeliSprint1.dto.request.ProductInDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.*;
import com.bootcamp.socialmeliSprint1.entitiy.Post;
import com.bootcamp.socialmeliSprint1.entitiy.Product;
import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.exception.sortException.BadSorterParamRequest;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUserException;
import com.bootcamp.socialmeliSprint1.exception.postException.PostIdAlreadyExists;
import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class ProductServiceImpl implements IProductService{

    ISocialMeliRepository socialMeliRepository;
    ModelMapper mm;

    public ProductServiceImpl(ISocialMeliRepository socialMeliRepository) {
        this.socialMeliRepository = socialMeliRepository;
        this.mm = new ModelMapper();
    }

    @Override
    public void createPost(PostInDTO postIn) {

        Seller seller = socialMeliRepository.getSeller(postIn.getUserId()).orElseThrow(
                ()-> new NotFoundUserException(postIn.getUserId())
        );

        if(seller.getPost(postIn.getIdPost())!=null){
            throw new PostIdAlreadyExists(seller.getUserID(),postIn.getIdPost());
        }

        ProductInDTO productIn = postIn.getDetail();

        Product product = new Product(productIn.getProductId(),productIn.getProductName(),
                productIn.getType(),productIn.getBrand(), productIn.getColor(), productIn.getNotes());

        //aquí debe validarse el formato de la fecha o arrojará una DateTimePaseException (ej: 01-122-2021)
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(postIn.getDate(),dt);

        Post post = new Post(postIn.getIdPost(),date,product,postIn.getCategory(),postIn.getPrice());

        socialMeliRepository.createNewPost(seller.getUserID(), post);
    }

    @Override
    public void createPostPromo(PostInPromoDTO postIn) {

        PostInDTO post =mm.map(postIn,PostInDTO.class);

        createPost(post);

        Seller s = socialMeliRepository.getSeller(postIn.getUserId()).get();

        s.getPost(postIn.getIdPost()).setHasPromo(postIn.isHasPromo());

        s.getPost(postIn.getIdPost()).setDiscount(postIn.getDiscount());
    }

    @Override
    public SellersPostsDTO getSellersPosts(Integer purchaserId) {

        Purchaser purchaser = socialMeliRepository.getPurchaser(purchaserId).orElseThrow(
                () -> new NotFoundUserException(purchaserId)
        );

        var allPost = socialMeliRepository.getSellersPosts(purchaserId);

        List<PostOutDTO> postsResponse = new ArrayList<>();

        allPost.stream().forEach(post -> {

            ProductDTO detail = mm.map(post.getDetail(),ProductDTO.class);
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            PostOutDTO postOutDTO = new PostOutDTO(post.getPostId(), post.getDate().format(dt),
                    detail, post.getCategory(),post.getPrice());

            postsResponse.add(postOutDTO);

        });

        return new SellersPostsDTO(purchaserId,postsResponse);
    }

    @Override
    public SellersPostsDTO getSellersPostsSort(Integer purchaserId, String order) {

        SellersPostsDTO res = getSellersPosts(purchaserId);

        var list = res.getPosts();

        sort(list,order);

        return res;
    }


    private void sort(List<PostOutDTO> list, String order){

        StringTokenizer st = new StringTokenizer(order,"_");

        if(st.hasMoreTokens()){
            if(!st.nextToken().equals("date")){
                throw new BadSorterParamRequest(order);
            }

            var sort = st.nextToken();

            if(sort.equals("asc")){
                list.sort(new PostDateComparator(SortOrder.ASC));
            }else{
                if(sort.equals("desc")) {
                    list.sort(new PostDateComparator(SortOrder.DESC));
                }else{
                    throw new BadSorterParamRequest(order);
                }
            }
        }else{
            throw new BadSorterParamRequest(order);
        }
    }

    @Override
    public SellerProductsInPromoListDTO getProductsInPromo(Integer sellerId) {

        Seller seller = socialMeliRepository.getSeller(sellerId).orElseThrow(
                ()-> new NotFoundUserException(sellerId)
        );

        var post = seller.getPosts().values();

        List<PostPromoOutDTO> posts = new ArrayList<>();

        post.stream().forEach(postTemp -> {
            if(postTemp.isHasPromo()){
                //posts.add(mm.map(postTemp,PostPromoOutDTO.class));

                DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                LocalDate date = postTemp.getDate();

                var tempDate = date.format(dt);

                ProductDTO detail = new ProductDTO(postTemp.getDetail().getProductId(),
                        postTemp.getDetail().getProductName(),
                        postTemp.getDetail().getType(), postTemp.getDetail().getBrand(),
                        postTemp.getDetail().getColor(),postTemp.getDetail().getNotes());

                posts.add(new PostPromoOutDTO(postTemp.getPostId(),tempDate,
                        detail,postTemp.getCategory(), postTemp.getPrice(),
                        postTemp.isHasPromo(), postTemp.getDiscount()));

            }
        });

        return new SellerProductsInPromoListDTO(sellerId,seller.getUserName(),posts);
    }

    @Override
    public ProductsPromoInfoDTO getNumberOfProductsInPromo(Integer sellerId) {

        var size = getProductsInPromo(sellerId).getPosts().size();


        String userName = socialMeliRepository.getSeller(sellerId).get().getUserName();

        return new ProductsPromoInfoDTO(sellerId,userName,size);
    }
}
