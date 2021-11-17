package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ProductMapper implements IProductMapper{
    @Override
    public Post postDTOToPost(RequestPostDTO requestPostDTO) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Post post = new Post(
                requestPostDTO.getIdPost(),
                LocalDate.parse(requestPostDTO.getDate(),formatter),
                requestPostDTO.getPrice(),
                requestPostDTO.getCategory(),
                requestPostDTO.getUserId(),
                productDTOToProduct(requestPostDTO.getDetail()));
        return post;
        }

    @Override
    public PostDTO postDTOFromPost(Post post) {
        ProductDTO productDTO = productDTOFromProduct(post.getDetail());
        PostDTO postDTO = new PostDTO(
                post.getIdPost(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                post.getPrice(),
                post.getCategory(),
                productDTO);
        return postDTO;
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
        return product;
    }
    @Override
    public ProductDTO productDTOFromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
        return productDTO;
    }
}
