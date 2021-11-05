package com.c4.p1.service;

import com.c4.p1.dto.EntradaBlogInfoDto;
import com.c4.p1.dto.EntradaBlogDto;
import com.c4.p1.exceptions.AlreadyExistsException;
import com.c4.p1.exceptions.NotFoundException;

import java.util.List;

public interface IBlogService {
    List<EntradaBlogDto> recuperarListadoEntradas();
    EntradaBlogInfoDto recuperarInfoEntrada(Integer id) throws NotFoundException;
    Integer insertarEntrada(EntradaBlogDto entradaBlogDto) throws AlreadyExistsException;
}
