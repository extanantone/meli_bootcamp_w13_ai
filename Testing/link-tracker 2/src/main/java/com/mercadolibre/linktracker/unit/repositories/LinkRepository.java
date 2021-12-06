package com.mercadolibre.linktracker.unit.repositories;

import com.mercadolibre.linktracker.unit.dto.LinkDTO;

import java.util.Optional;

public interface LinkRepository {
  LinkDTO save(LinkDTO link);

  Optional<LinkDTO> findLinkByLinkId(Integer linkId);

  void delete(LinkDTO linkDTO);
}
