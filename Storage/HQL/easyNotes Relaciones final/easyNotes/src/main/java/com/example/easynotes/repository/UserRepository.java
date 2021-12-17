package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    /* NOTA: palabras que aceptan los Named Methods
    * NOTA: Para numeros -          greaterThan, greaterThanEquals, lessThan, lessThanEquals, between
    * NOTA: Para strings -          equals, like, notLike, endingWith, startingWith, containing, ignoringCase
    * NOTA: Para booleanos -        true, false
    * NOTA: Para intervalos -       in, notIn
    * NOTA: Para fechas -           before, after
    * NOTA: Operadores logicos -    or, and
    * NOTA: Otras sentencias sql -  distinct, orderBy, sort
    *  */


    // NOTA: METODO QUE BUSCAR USUARIOS POR COINCIDENCIA CON APELLIDO
    // NOTA: EL METODO SOLO REALIZA LO MISMO QUE @QUERY
    @Query("from User u where u.lastName like %:lastName%")
    List<?> findUserByLastNameLike(@Param("lastName") String lastName);

    // NOTA: METODO QUE BUSCAR USUARIOS CON APELLIDO QUE TERMINE SEGUN PARAMETRO
    List<?> findUserByLastNameEndingWith(@Param("lastName") String term);

    // NOTA: METDDO QUE REALIZA UN JOIN DE USUARIOS Y NOTAS DONDE EL TITULO COINCIDA CON EL PARAMETRO
    // NOTA: EL METODO SOLO REALIZA LO MISMO QUE @QUERY
    @Query("select distinct user " +
            "from User user " +
            "join user.authorNotes note " +
            "where note.title like %:title%" )
    List<User> findUserByNoteTitleLike(@Param("title") String title);

    // NOTA: METDDO QUE REALIZA UN JOIN DE USUARIOS Y NOTAS DONDE LA NOTA HAYA SIDO CREADA LUEGO O EN LA MISMA FECHA PASADA POR PARAMETRO
    // NOTA: EL METODO SOLO REALIZA LO MISMO QUE @QUERY
    @Query( "select distinct user " +
            "from User user " +
            "join user.authorNotes note " +
            "where note.createdAt >= :date" )
    List<User> findUserByNoteCreatedAtLessOrEqualDate(@Param("date") Date date);

    // NOTA: METODO QUE USA UN MAPA PARA
    @Query("Select new map(u.firstName as name, SIZE(u.authorNotes) as notes )" +
            " from User u " +
            "where u.lastName like %:lastName%")
    List<Map<String, Object>> countByFirstName(@Param("lastName") String lastName);


}
