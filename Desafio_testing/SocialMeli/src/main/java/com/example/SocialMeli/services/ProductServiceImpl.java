package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.dto.VendedorDTO;
import com.example.SocialMeli.entities.Post;
import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.exception.OrderNameNotExist;
import com.example.SocialMeli.exception.PostNotFoundException;
import com.example.SocialMeli.exception.ProductAlreadyExistException;
import com.example.SocialMeli.repository.ProductRepository;
import com.example.SocialMeli.repository.UserRepository;
import com.example.SocialMeli.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.reverse;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean saveProduct(PostDTO postDTO) {
        if(productRepository.getById(Long.valueOf(postDTO.getId())) != null) throw new ProductAlreadyExistException(postDTO.getId());
        this.userRepository.savePost(postDTO.getId(), postDTO.getUserId());
        return this.productRepository.saveProduct(ProductMapper.toEntity(postDTO));
    }

    @Override
    public List<VendedorDTO> getSellerFollowed(int userId, String order) {
        List<VendedorDTO> result = new ArrayList<>();
        List<User> vendedores = this.userRepository.getFolloweds(userId);
        List<PostDTO> postsDTOs = new ArrayList<>();
        vendedores.forEach(vendedor -> {
            VendedorDTO vendedorDTO = new VendedorDTO();
            List<Long> ids = vendedor.getProducts();
            ids.forEach(currentPost -> {
                        //Controlar las fechas que sean dentro de las dos semanas.
                        Post post = this.productRepository.getById(currentPost);
                        if(post == null) throw new PostNotFoundException(Math.toIntExact(currentPost));
                        PostDTO postDTO = ProductMapper.toDto(post);
                        if (postDTO.getDate().isAfter(LocalDate.now().minusDays(14))) {
                            postsDTOs.add(
                                    ProductMapper.toDto(this.productRepository.getById(currentPost)));
                        }
                    }
            );
            //postsDTOs.sort((p1, p2) -> p1.getDate().isBefore(p2.getDate()));
            result.add(new VendedorDTO(vendedor.getUser_id(), this.listOrder(postsDTOs, order)));
        });
        return result;
    }

    public List<PostDTO> listOrder(List<PostDTO> postsDTO, String order) {
        if(!Objects.equals(order, "name_asc") && !Objects.equals(order, "name_desc") && !Objects.equals(order, null)) throw new OrderNameNotExist(order);
        postsDTO.sort(Comparator.comparing(PostDTO::getDate));
        if(Objects.equals(order, "name_desc")) reverse(postsDTO);
        return postsDTO;
    }
}
