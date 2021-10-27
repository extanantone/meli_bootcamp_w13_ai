public class Main {

    public static void main(String[] args) {
        /** En este ejemplo no podemos Instanciar estudiante/PersonalTecnico/Personal
         *  No esta del todo bien que no se pueda instanciar Estudiante, solo es un ejemplo
         *  Para hacerlo de manera correcta tendriamos que hacer como clase abstracta alguna
         *  clase como "Universitario" qeu no es necesario instanciar, en cambio estudiante
         *  En un sistema es util poder instanciarlo.
         **/

        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("Rodrigo","Dimare", "100");

        estudianteTecnico.hace();
        System.out.println(estudianteTecnico.reparar());

    }

}
