package com.example.easynotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * https://www.baeldung.com/jpa-many-to-many
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ThankId implements Serializable {

    @Column(name = "note_id")
    Long noteId;

    @Column(name = "user_id")
    Long userId;
}