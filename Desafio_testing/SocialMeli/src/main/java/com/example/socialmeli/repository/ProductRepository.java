package com.example.socialmeli.repository;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.PostCreateDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{
    List<PostCreateDto> postCreateDtos = new ArrayList<>();


    @Override
    public void createPost(PostCreateDto postCreateDto) {

        postCreateDtos.add(postCreateDto);

    }

    @Override
    public Boolean findById(Integer postId) {

        return postCreateDtos.stream()
                .filter(x-> x.getIdPost().equals(postId))
                .findFirst().isEmpty();

    }

    @Override
    public List<PostCreateDto> listPosts(Integer userId) {
        LocalDate twoWeaksBefore = LocalDate.now().minusDays(15);
        return postCreateDtos.stream()
                .filter(x -> x.getUserId().equals(userId))
                .filter(x -> x.getDate().isAfter(twoWeaksBefore))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostCreateDto> promoPost(Integer userId) {

        return postCreateDtos.stream()
                .filter(x -> x.getUserId().equals(userId))
                .filter(x -> x.getHasPromo())
                .collect(Collectors.toList());
    }


}
