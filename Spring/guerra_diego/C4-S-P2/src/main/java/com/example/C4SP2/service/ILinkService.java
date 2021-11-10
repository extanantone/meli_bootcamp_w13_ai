package com.example.C4SP2.service;

import com.example.C4SP2.dto.LinkDto;
import com.example.C4SP2.dto.LinkMetricaDto;
import com.example.C4SP2.dto.LinkValidoDto;
import com.example.C4SP2.dto.LinkPasswordDto;

public interface ILinkService {

    LinkDto crearLink(LinkPasswordDto linkDto);
    LinkValidoDto redirectLink(LinkPasswordDto linkPasswordDto);
    LinkMetricaDto devolverMetrica(int id);
    LinkValidoDto invalidarLink(int id);
}
