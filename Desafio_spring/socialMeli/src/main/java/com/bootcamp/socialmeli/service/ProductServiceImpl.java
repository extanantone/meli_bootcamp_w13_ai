package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.comparator.PostDateComparator;
import com.bootcamp.socialmeli.dto.comparator.SortOrder;
import com.bootcamp.socialmeli.dto.request.PostInDTO;
import com.bootcamp.socialmeli.dto.request.PostInPromoDTO;
import com.bootcamp.socialmeli.dto.request.ProductInDTO;
import com.bootcamp.socialmeli.dto.response.post.PostOutDTO;
import com.bootcamp.socialmeli.dto.response.post.ProductDTO;
import com.bootcamp.socialmeli.dto.response.post.SellersPostsDTO;
import com.bootcamp.socialmeli.entitiy.Post;
import com.bootcamp.socialmeli.entitiy.Product;
import com.bootcamp.socialmeli.entitiy.Purchaser;
import com.bootcamp.socialmeli.entitiy.Seller;
import com.bootcamp.socialmeli.exception.sortException.BadSorterParamRequest;
import com.bootcamp.socialmeli.exception.userException.NotFoundUsuarioException;
import com.bootcamp.socialmeli.exception.postException.PostIdAlreadyExists;
import com.bootcamp.socialmeli.repository.ISocialMeliRepository;
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
                ()-> new NotFoundUsuarioException(postIn.getUserId())
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
                () -> new NotFoundUsuarioException(purchaserId)
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

}
