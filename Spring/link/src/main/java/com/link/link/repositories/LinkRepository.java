package com.link.link.repositories;

import com.link.link.dto.LinkDTO;

import java.util.Optional;

public interface LinkRepository {
    LinkDTO save(LinkDTO link);
    Optional<LinkDTO> findLinkById(int linkId);
    void delete(LinkDTO linkDTO);
}
