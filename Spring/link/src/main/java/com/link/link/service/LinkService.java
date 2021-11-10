package com.link.link.service;

import com.link.link.dto.LinkDTO;

public interface LinkService {
    LinkDTO create(LinkDTO link);
    LinkDTO redirect(Integer linkId);
    LinkDTO redirect(Integer linkId,String password);
    Integer metrics(Integer linkId);
    void invalidate(Integer linkId);

}
