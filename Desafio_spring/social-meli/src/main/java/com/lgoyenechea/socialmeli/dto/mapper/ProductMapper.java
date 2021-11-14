package com.lgoyenechea.socialmeli.dto.mapper;

import com.lgoyenechea.socialmeli.dto.PostCreationDTO;
import com.lgoyenechea.socialmeli.dto.PostDTO;
import com.lgoyenechea.socialmeli.dto.ProductCreationDTO;
import com.lgoyenechea.socialmeli.dto.ProductDTO;
import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.model.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductMapper {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Post postCreationDtoToPost(PostCreationDTO dto) {
        Post post = new Post();
        post.setUserId(dto.getUserId());
        post.setDate(LocalDate.parse(dto.getDate(), DATE_TIME_FORMATTER));
        post.setDetail(productCreationDtoToProduct(dto.getDetail()));
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        return post;
    }

    public static Product productCreationDtoToProduct(ProductCreationDTO dto) {
        Product product = new Product();
        product.setName(dto.getProductName());
        product.setType(dto.getType());
        product.setBrand(dto.getBrand());
        product.setColor(dto.getColor());
        product.setNotes(dto.getNotes());
        return product;
    }

    public static PostDTO postToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setIdPost(post.getId());
        dto.setUserId(post.getUserId());
        dto.setCategory(post.getCategory());
        dto.setDate(post.getDate().format(DATE_TIME_FORMATTER));
        dto.setPrice(post.getPrice());
        dto.setDetail(productToDto(post.getDetail()));
        return dto;
    }

    public static ProductDTO productToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getId());
        dto.setProductName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setColor(product.getColor());
        dto.setNotes(product.getNotes());
        dto.setType(product.getType());
        return dto;
    }
}
