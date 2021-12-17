package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface NoteRepository extends JpaRepository<Note, Long> {

    // NOTA: TOP 3 DE NOTAS CON MAS LIKES SEGUN AÑO

    @Query("FROM Note n " +
            "WHERE YEAR(n.createdAt) = :year " +
            "group by n.id " +
            "ORDER BY SIZE(n.thanks) DESC ")
    public List<Note> findTopThreeNotesMostThankedByDate(@Param("year") int year);
}
