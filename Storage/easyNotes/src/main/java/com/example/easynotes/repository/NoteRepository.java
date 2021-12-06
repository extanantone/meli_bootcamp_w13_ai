package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*import com.example.easynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
*/
public interface NoteRepository  extends
        JpaRepository<Note, Long> {

}
