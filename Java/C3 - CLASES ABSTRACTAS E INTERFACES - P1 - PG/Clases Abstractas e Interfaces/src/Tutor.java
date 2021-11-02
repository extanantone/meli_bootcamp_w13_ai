public class Tutor extends Estudiante implements Enseñar{

    @Override
    public void enseñar() {
        System.out.println("Tutor enseñando");
    }
}
