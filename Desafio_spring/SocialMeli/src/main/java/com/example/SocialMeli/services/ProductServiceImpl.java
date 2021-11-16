package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.dto.VendedorDTO;
import com.example.SocialMeli.entities.Post;
import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.repository.ProductRepository;
import com.example.SocialMeli.repository.UserRepository;
import com.example.SocialMeli.services.mapper.ProductMapper;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.ProtectionDomain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean saveProduct(PostDTO postDTO) throws Exception {
        this.userRepository.savePost(postDTO.getId(), postDTO.getUserId());
        return this.productRepository.saveProduct(ProductMapper.toEntity(postDTO));
    }

    @Override
    public List<VendedorDTO> getSellerFollowed(int userId) throws Exception {
        List<VendedorDTO> result = new ArrayList<>();
        List<User> vendedores = this.userRepository.getFolloweds(userId);
        List<PostDTO> postsDTOs = new ArrayList<>();
        vendedores.forEach(vendedor -> {
            VendedorDTO vendedorDTO = new VendedorDTO();
            vendedor.getProducts().forEach(post -> {
                //Controlar las fechas que sean dentro de las dos semanas.
                PostDTO postDTO = ProductMapper.toDto(this.productRepository.getById(post));
                if( postDTO.getDate().isAfter(LocalDate.now().minusDays(14))) {
                    postsDTOs.add(
                            ProductMapper.toDto(this.productRepository.getById(post)));
                }
            }
            );
            result.add(new VendedorDTO(vendedor.getUser_id(), postsDTOs));
        });
        return result;
    }
}
