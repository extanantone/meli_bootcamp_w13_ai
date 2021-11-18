package com.example.SocialMeli.mapper;

import com.example.SocialMeli.dto.ProductDto;
import com.example.SocialMeli.dto.PublicationDto;
import com.example.SocialMeli.model.Product;
import com.example.SocialMeli.model.Publication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mapper {

    public PublicationDto publicationToPublicacionDto(Publication publication, ProductDto productDto){
        PublicationDto publicationDto = new PublicationDto();
        publicationDto.setIdPost(publication.getIdPost());
        publicationDto.setDate(publication.getDate().toString());
        publicationDto.setDetail(productDto);
        publicationDto.setCategory(publication.getCategory());
        publicationDto.setPrice(publication.getPrice());

        if (publication.isHasPromo()){
            publicationDto.setHasPromo(true);
            publicationDto.setDiscount(publication.getDiscount());
        }

        return publicationDto;
    }

    public Publication publicationDtoToPublicacion(PublicationDto publicationDto, Product product){
        Publication publication = new Publication();
        publication.setIdPost(publicationDto.getIdPost());
        publication.setDate(LocalDate.parse(publicationDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        publication.setDetail(product);
        publication.setCategory(publicationDto.getCategory());
        publication.setPrice(publicationDto.getPrice());

        if (publicationDto.isHasPromo()){
            publication.setHasPromo(true);
            publication.setDiscount(publicationDto.getDiscount());
        }

        return publication;
    }

    public ProductDto productToProductDto(Product product){

        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());

        return productDto;
    }

    public Product productDtoToProduct(ProductDto productDto){

        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setNotes(productDto.getNotes());

        return product;
    }
}
