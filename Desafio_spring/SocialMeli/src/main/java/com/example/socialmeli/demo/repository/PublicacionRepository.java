package com.example.socialmeli.demo.repository;

import com.example.socialmeli.demo.comparator.AscendingPostDateSorter;
import com.example.socialmeli.demo.comparator.DescendingPostDateSorter;
import com.example.socialmeli.demo.dto.controllerToService.RequestPostsFromFollowedsDTO;
import com.example.socialmeli.demo.model.Publicacion;
import com.example.socialmeli.demo.model.PublicacionPromocion;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PublicacionRepository implements IPublicacionRepository {

    private List<Publicacion> publicaciones = new ArrayList<>();


    @Override
    public Publicacion crearPublicacion(Publicacion p) {

        PublicacionPromocion pr = new PublicacionPromocion();
        publicaciones.add(pr);

        publicaciones.add(p);
        return p;
    }

    @Override
    public List<Publicacion> obtenerPublicacionesPorVendedorIdPosteriores2Semanas(int userId, String order) {

        List<Publicacion> response = new ArrayList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String todayDate = dtf.format(now);

        LocalDate date = LocalDate.parse(todayDate,dtf);
        // Restamos dos semanas a la fecha actual
        LocalDate dateFromTwoWeeks = date.minusWeeks(2);

        response = publicaciones.stream().filter(x -> x.getUserId() == userId)
                .filter(y -> y.getDate().isAfter(dateFromTwoWeeks) )
                .sorted(new DescendingPostDateSorter())
                .collect(Collectors.toList());

        if(order != null)
            if(order.equals("date_asc"))
                response = response.stream().sorted(new AscendingPostDateSorter()).collect(Collectors.toList());

        return response;

    }

    @Override
    public int countPromoPostOfUser(int userId) {

        int promoPostCount = 0;

        List<Publicacion> listOfPromoPost = publicaciones.stream().filter(p -> p.getUserId() == userId && p.hasPromo() == true).collect(Collectors.toList());
        promoPostCount = listOfPromoPost.size();

        return promoPostCount;

    }

    @Override
    public List<Publicacion> getPromoPostListOfUserId(int userId) {

        List <Publicacion> response = new ArrayList<>();

        response = publicaciones.stream().filter(x -> x.getUserId() == userId)
                .filter(p -> p.getUserId() == userId && p.hasPromo() == true)
                .collect(Collectors.toList());



        return response;

    }


}
