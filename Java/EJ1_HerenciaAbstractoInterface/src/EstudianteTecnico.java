public class EstudianteTecnico extends Estudiante implements PersonalTecnico {

    public String hace = "";

    public EstudianteTecnico(String nombre, String apellido, String legajo) {
        super(nombre, apellido, legajo);
    }

    @Override
    public String hace(){
        hace = "Estudia y ";
        return hace;
    }

    @Override
    public String reparar(){
        return hace + "Repara pc";
    }


}
