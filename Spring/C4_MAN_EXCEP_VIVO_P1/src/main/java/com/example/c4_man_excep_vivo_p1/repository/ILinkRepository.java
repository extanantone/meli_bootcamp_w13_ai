package com.example.c4_man_excep_vivo_p1.repository;

import com.example.c4_man_excep_vivo_p1.dto.LinkDTO;
import com.example.c4_man_excep_vivo_p1.model.Link;

import java.util.Map;

public interface ILinkRepository
{
    public Map<Integer, Link> saveData(Integer linkId, Link link);

    public Map<Integer, Link> getMap();
}
