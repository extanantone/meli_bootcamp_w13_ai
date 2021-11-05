package com.example.blog.repository;

import com.example.blog.dto.LinkDto;

public interface ILinkRepository {
    public void añadirLinks(LinkDto link);
    public LinkDto buscarLink(int id);
}
