package com.bootcamp.Linktraker.demo.service;

import com.bootcamp.Linktraker.demo.dto.LinkDTO;

public interface ILinkService {

    LinkDTO postLink(LinkDTO linkDTO);
    String rederic (long id);

}
