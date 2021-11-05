package com.blog.mapper;

import com.blog.dto.BlogEntryDto;
import com.blog.model.BlogEntry;

public interface IBlogEntryDtoMapper {

    BlogEntryDto getBlogEntryDto(BlogEntry blog);

    BlogEntry getBlogEntry(BlogEntryDto dto);
}
