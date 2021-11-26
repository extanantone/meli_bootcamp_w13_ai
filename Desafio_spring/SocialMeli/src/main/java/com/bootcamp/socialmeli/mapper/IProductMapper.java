package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;

public interface IProductMapper {
    Post postDTOToPost(RequestPostDTO requestPostDTO);
    PostDTO postDTOFromPost(Post post);
    Product productDTOToProduct(ProductDTO productDTO);
    ProductDTO productDTOFromProduct(Product product);

}
