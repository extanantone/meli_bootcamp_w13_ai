package ejercicio1AdminCursos;

public class Tutor extends Estudiante{

    private String materiaTuroria;

    public Tutor(String identificacion, String nombre, String codigo, String programa, String fechaIngreso, int semestreActual, String materiaTuroria) {
        super(identificacion, nombre, codigo, programa, fechaIngreso, semestreActual);
        this.materiaTuroria = materiaTuroria;
    }

    public String getMateriaTuroria() {
        return materiaTuroria;
    }

    public void setMateriaTuroria(String materiaTuroria) {
        this.materiaTuroria = materiaTuroria;
    }

    @Override
    public String toString() {
        return super.toString() + " , Tutor de : " + this.materiaTuroria;
    }
}
