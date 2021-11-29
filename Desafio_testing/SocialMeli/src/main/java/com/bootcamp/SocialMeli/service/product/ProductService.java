package com.bootcamp.SocialMeli.service.product;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.dto.product.*;
import com.bootcamp.SocialMeli.exception.*;
import com.bootcamp.SocialMeli.model.*;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ProductService implements IProductService {
    private final ISocialMeliRepository socialMeliRepository;

    private final int TWO_WEEKS = 14;

    public ProductService(ISocialMeliRepository socialMeliRepository) {
        this.socialMeliRepository = socialMeliRepository;
    }

    @Override
    public ResponseDTO post(PostDTO postDTO) {
        User user = socialMeliRepository.findUser(postDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException(postDTO.getUserId()));

        Post post = user.getPosts().stream()
                .filter(p -> p.getIdPost() == postDTO.getIdPost()).findFirst().orElse(null);

        if (post == null) {
            user.getPosts().add(
                    new Post(postDTO.getUserId(), postDTO.getIdPost(), postDTO.getDate(), createProduct(postDTO)));
        } else {
            throw new DuplicateIDPostException(postDTO.getIdPost(), postDTO.getUserId());
        }

        return new ResponseDTO("performed_action", "Acción Realizada");
    }

    private Product createProduct(PostDTO postDTO) {
        return new Product(
                postDTO.getDetail().getProductId(),
                postDTO.getDetail().getProductName(),
                postDTO.getDetail().getType(),
                postDTO.getDetail().getBrand(),
                postDTO.getDetail().getColor(),
                postDTO.getDetail().getNotes(),
                postDTO.getCategory(),
                postDTO.getPrice());
    }

    @Override
    public ProductFollowedListDTO followedList(int userId, String order) {
        User user = socialMeliRepository.findUser(userId).orElseThrow(() -> new UserNotFoundException(userId));

        List<PostDTO> postListDTO = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        user.getFollowed().forEach(u -> u.getPosts().forEach(post -> {
            if (DAYS.between(post.getDate(), currentDate) <= TWO_WEEKS) {
                postListDTO.add(createPostDTO(post));
            }
        }));

        orderList(postListDTO, order);

        return new ProductFollowedListDTO(userId, postListDTO);
    }

    private PostDTO createPostDTO(Post post) {
        return new PostDTO(post.getIdPost(), post.getDate(),
                new DetailDTO(
                        post.getProduct().getProductId(),
                        post.getProduct().getProductName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.getProduct().getColor(),
                        post.getProduct().getNotes()),
                post.getProduct().getCategory(), post.getProduct().getPrice());
    }

    private void orderList(List<PostDTO> list, String order) {
        if (order.equalsIgnoreCase("date_desc")) {
            list.sort(Comparator.comparing(PostDTO::getDate).reversed());
        } else if (order.equalsIgnoreCase("date_asc")) {
            list.sort(Comparator.comparing(PostDTO::getDate));
        } else if (!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }
}