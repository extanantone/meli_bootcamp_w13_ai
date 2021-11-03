package bootcamp.ejercicioedad.Controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edad {
    Integer dia;
    Integer mes;
    Integer year;
    Integer edad;

    public Edad(Integer dia, Integer mes, Integer year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }
}
