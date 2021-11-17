package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.exception.BadRequestException;
import com.meli.SocialMeli.helper.Helper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Promo;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.reposity.IRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService{

    IRepository repository;

    public SocialMeliService(IRepository userRepository){
        this.repository = userRepository;
    }

    @Override
    public MensajeDTO addFollow(int userId, int userIdFollow) {
        if(repository.findUser(userId)==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(repository.findUser(userIdFollow)==null)
            throw new BadRequestException("Usuario "+userIdFollow+" no encontrado");
        if(repository.containFollower(userIdFollow, userId))
            throw new BadRequestException("Usuario "+userId+" ya se encuentra siguiendo al usuario "+userIdFollow);
        repository.addFollower(userId, userIdFollow);
        return new MensajeDTO("Usuario "+userId+" ahora está siguiendo al usuario "+userIdFollow, 1);
    }

    @Override
    public CountDTO countFollowers(int userId) {
        User usr = repository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        return new CountDTO(userId, usr.getUserName(), usr.getFollowed().size(), null);
    }

    @Override
    public FollowersDTO listFollowers(int userId, String order) {
        User usr = repository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(usr.getFollowed()==null || usr.getFollowed().size()==0)
            throw new BadRequestException("Usuario "+userId+" no posee seguidores");
        List<User>followed = usr.getFollowed();
        if(order!=null){
            switch (order){
                case "name_asc":    followed = followed.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
                    break;
                case "name_desc":   followed = followed.stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList());
                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta name_asc o name_desc");
            }
            usr.setFollowers(followed);
        }
        return Helper.listFollowersToFollowers(usr);


    }

    @Override
    public FollowedDTO listFollowed(int userId, String order) {
        User usr = repository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(usr.getFollowers()==null || usr.getFollowers().size()==0)
            throw new BadRequestException("Usuario "+userId+" no posee seguidos");
        List<User>followers = usr.getFollowers();
        if(order!=null){
            switch (order){
                case "name_asc":    followers = followers.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toUnmodifiableList());
                                    break;
                case "name_desc":   followers = followers.stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toUnmodifiableList());
                                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta name_asc o name_desc");
            }
            usr.setFollowers(followers);
        }

        return Helper.listFollowedToFollowed(usr);
    }

    @Override
    public MensajeDTO addPost(PostDTOResponse postDto) {
        if(postDto.getUserId()<=0)
            throw new BadRequestException("Usuario "+postDto.getUserId()+" invalido");
        if(postDto.getIdPost()<=0)
            throw new BadRequestException("id_post debe ser un número mayor que cero.");
        if(postDto.getDate()==null)
            throw new BadRequestException("Debe ingresar el atributo date para poder cargar el Post");
        if(postDto.getDate().compareTo(LocalDate.now())>0)
            throw new BadRequestException("No puede realizar Post con fecha posterior al día de hoy");
        if(postDto.getDetail()==null)
            throw new BadRequestException("Debe ingresar Detail para poder cargar el Post");
        if(postDto.getDetail().getProductId()==0 || postDto.getDetail().getProductName().trim().isEmpty() || postDto.getDetail().getType().trim().isEmpty())
            throw new BadRequestException("Debe ingresar datos en el Detail para poder cargar el Post (product_id, product_name, type son campos obligatorios)");
        if(repository.containPost(postDto.getIdPost())){
            throw new BadRequestException("id_post existente.");
        }
        if(repository.containProduct(postDto.getUserId(), postDto.getDetail().getProductId())){
            throw new BadRequestException("product_id existente.");
        }
        if(postDto.getPrice()<=0)
            throw new BadRequestException("price debe ser mayor que cero.");
        if(postDto.getCategory()<=0)
            throw new BadRequestException("category debe ser mayor que cero.");
        Post post = Helper.postDTOToPost(postDto);
        repository.addPost(post);
        return new MensajeDTO("Post almacenado.",1);
    }

    @Override
    public ListPostsDTO listPostFollowed(int userId, String order) {
        User usr = repository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        List<Post> lista= new LinkedList<>();
        for(User follower: usr.getFollowers()){
            lista.addAll(repository.listPostUsr(follower.getUserId()));
        }
        lista= lista.stream().filter(p->p.getDate().plusDays(14).compareTo(LocalDate.now())>=0).collect(Collectors.toList());
        if(order!=null){
            switch (order){
                case "date_asc":    lista=lista.stream().sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());
                                    break;
                case "date_desc":   lista=lista.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
                                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta date_asc o date_desc.");
            }
        }
        return Helper.listPostToListPostDTO(lista, usr.getUserId());
    }

    @Override
    public MensajeDTO unfollow(int userId, int userIdFollow) {
        if(repository.findUser(userId)==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(repository.findUser(userIdFollow)==null)
            throw new BadRequestException("Usuario "+userIdFollow+" no encontrado");
        if(!repository.containFollower(userIdFollow, userId))
            throw new BadRequestException("Usuario "+userId+" no se encuentra siguiendo al usuario "+userIdFollow);
        repository.unfollow(userId, userIdFollow);
        return new MensajeDTO("Usuario "+userId+" dejó de seguir al usuario "+userIdFollow, 1);
    }

    @Override
    public MensajeDTO addPromo(PromoDTO promoDto) {
        if(promoDto.getUserId()<=0)
            throw new BadRequestException("Usuario "+promoDto.getUserId()+" invalido");
        if(promoDto.getIdPost()<=0)
            throw new BadRequestException("id_post debe ser un número mayor que cero.");
        if(repository.containPost(promoDto.getIdPost())){
            throw new BadRequestException("id_post promo existente.");
        }
        if(promoDto.getDate()==null)
            throw new BadRequestException("Debe ingresar el atributo date para poder cargar el Post");
        if(promoDto.getDate().compareTo(LocalDate.now())>0)
            throw new BadRequestException("No puede realizar Post con fecha posterior al día de hoy");
        if(promoDto.getDetail()==null)
            throw new BadRequestException("Debe ingresar Detail para poder cargar el Post");
        if(promoDto.getDetail().getProductId()==0 || promoDto.getDetail().getProductName().trim().isEmpty() || promoDto.getDetail().getType().trim().isEmpty())
            throw new BadRequestException("Debe ingresar datos en el Detail para poder cargar el Post (product_id, product_name, type son campos obligatorios)");

        if(repository.containProductPromo(promoDto.getUserId(), promoDto.getDetail().getProductId())){
            throw new BadRequestException("product_id existente para usuario "+promoDto.getUserId()+".");
        }
        if(promoDto.getPrice()<=0)
            throw new BadRequestException("price debe ser mayor que cero.");
        if(promoDto.getCategory()<=0)
            throw new BadRequestException("category debe ser mayor que cero.");
        if(promoDto.getDiscount()<=0 || promoDto.getDiscount()>100)
            throw new BadRequestException("Discount debe ser mayor que cero y menor que 100 para considerarse en promoción.");
        Promo promo = Helper.promoDTOToPromo(promoDto);
        repository.addPromo(promo);
        return new MensajeDTO("Promo "+promoDto.getIdPost()+" almacenada.",1);
    }

    @Override
    public ListPromoDTO listPromo(int userId, String order) {
        User usr = repository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        List<Promo> lista= repository.listPromoUsr(userId);
        if(order!=null){
            switch (order){
                case "date_asc":    lista=lista.stream().sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());
                    break;
                case "date_desc":   lista=lista.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta date_asc o date_desc.");
            }
        }
        return Helper.listPromoToListPromoDTO(lista, usr);
    }

    @Override
    public CountDTO countPromos(int userId) {
        User usr = repository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        return new CountDTO(userId, usr.getUserName(), null, repository.listPromoUsr(userId).size());
    }
}
