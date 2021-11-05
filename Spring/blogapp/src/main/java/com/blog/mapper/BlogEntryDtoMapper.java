package com.blog.mapper;

import com.blog.dto.BlogEntryDto;
import com.blog.model.BlogEntry;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BlogEntryDtoMapper implements IBlogEntryDtoMapper{

    private ModelMapper mapper = new ModelMapper();

    public BlogEntryDto getBlogEntryDto(BlogEntry blog){
        return mapper.map(blog,BlogEntryDto.class);
    }

    public BlogEntry getBlogEntry(BlogEntryDto dto){
        return mapper.map(dto,BlogEntry.class);
    }
}
