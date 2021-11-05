package com.example.linktracker.mapper;

import com.example.linktracker.dto.LinkRegisterDTO;
import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {
    public Link dtoToLink(LinkRegisterDTO dto) {
        return new Link(dto.getUrl(), dto.getPassword());
    }
}
