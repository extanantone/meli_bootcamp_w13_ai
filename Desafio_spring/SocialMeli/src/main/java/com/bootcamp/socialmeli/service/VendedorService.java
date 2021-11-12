package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.VendedorDTO;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IVendedorRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class VendedorService implements IVendedorService{

    IVendedorRepository vendedorRepository;

    ModelMapper mapper = new ModelMapper();

    public VendedorService(IVendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public VendedorDTO getInfoSeller(long id) {
        User user = vendedorRepository.findSellerById(id)
                .orElse(null);

        return mapper.map(user, VendedorDTO.class);
    }
}
