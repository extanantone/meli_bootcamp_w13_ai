package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository {

    private Map<Long, Product> products;

    public ProductRepository() {
        this.products = loadProductsFromJSON();
    }

    private Map<Long, Product> loadProductsFromJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:products.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};
        List<Product> productList = null;
        try {
            productList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList.stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }

    @Override
    public Product getProduct(long id) {
        return products.get(id);
    }

    @Override
    public Product createProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public void deleteProduct(long id) {
        products.remove(id);
    }
}
