package jpateststudent.model;

import javax.persistence.*;

@Entity
@Table(name = "calificaciones")
public class Calificaciones {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
}