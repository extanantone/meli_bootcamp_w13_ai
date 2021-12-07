package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User user where user.lastName like %:lastName%")
    List<User> findUserByLastNameLike(@Param("lastName") String lastName);

    @Query( "select distinct user " +
            "from User user " +
            "join user.authorNotes note " +
            "where note.title like %:title%" )
    List<User> findUserByNoteTitleLike(@Param("title") String title);

    @Query( "select distinct user " +
            "from User user " +
            "join user.authorNotes note " +
            "where note.createdAt >= :date" )
    List<User> findUserByNoteCreatedAtLessOrEqualDate(@Param("date") Date date);


}
