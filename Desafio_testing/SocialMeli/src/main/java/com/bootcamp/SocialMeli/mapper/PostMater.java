package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.DetailDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PostsDTO;
import com.bootcamp.SocialMeli.dto.PromopostDTO;
import com.bootcamp.SocialMeli.model.Detail;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.PromoPost;

public class PostMater {

    public static Post PostDToToPost(PostDTO postDTO){

        return new Post(postDTO.getUser_id(),postDTO.getId_post(),postDTO.getDate(),DetailDtoToDetail(postDTO.getDetail()),postDTO.getCategory(), postDTO.getPrice());
    }


    public static Detail DetailDtoToDetail(DetailDTO detailDTO){

        return new Detail(detailDTO.getProduct_id(),detailDTO.getProduct_name(),detailDTO.getType(),detailDTO.getBrand(),detailDTO.getColor(),detailDTO.getNotes() );

    }

    public static PostDTO PostToPostDTO(Post post){

        return new PostDTO(post.getIdUser(),post.getIdPost(),post.getDate(),DetailToDetailDTO(post.getDetail()),post.getCategory(), post.getPrice());
    }


    public static DetailDTO DetailToDetailDTO(Detail detail){

        return new DetailDTO(detail.getIdproduct(),detail.getProducName(),detail.getType(),detail.getBrand(),detail.getColor(),detail.getNotes() );

    }


    public static PostsDTO PostToPostsDTO(Post post){

        return new PostsDTO(post.getIdPost(),post.getDate(),DetailToDetailDTO(post.getDetail()));
    }

    public static PromoPost PromoPostDToToPromoPost(PromopostDTO promopostDTO){
        return new PromoPost(promopostDTO.getUser_id(),promopostDTO.getId_post(),promopostDTO.getDate(),DetailDtoToDetail(promopostDTO.getDetail()),promopostDTO.getCategory(),promopostDTO.getPrice()
        ,promopostDTO.isHas_promo(),promopostDTO.getDiscount());
    }

    public static PromopostDTO PromoposTopromoPostDTO (PromoPost promoPost){
        return new PromopostDTO(promoPost.getIdUser(),promoPost.getIdPost(),promoPost.getDate(),DetailToDetailDTO(promoPost.getDetail()),promoPost.getCategory()
        ,promoPost.getPrice(),promoPost.isHasPromo(),promoPost.getDiscount());
    }
}
