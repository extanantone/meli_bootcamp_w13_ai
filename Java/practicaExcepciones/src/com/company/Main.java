package com.company;

public class Main {

    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        practicaExcepciones.ejecutarOperacion();

    }
    public class PracticaExcepciones {
        private int a, b;

        public PracticaExcepciones() {
            this.a = 0;
            this.b = 300;
        }

        public int ejecutarOperacion() {
            try{
                return b/a;
            }
            catch(Exception e) {
                return 1;
            }
        }
    }

}
