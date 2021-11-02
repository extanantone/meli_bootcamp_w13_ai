package com.astractasEinterfeces.Ejercicio2;

public class Main {

  public static void main(String[] args) {

      IImprimible curriculums = new Curriculums("Danuit","Petro",34,"Ingeniero",
              "Ingenieria","Dan.p.j@hotmail.com","3215445");

      IImprimible pdf = new LibroPdf(1,"Gabriel","Cien años de soledad","Literatura");

      IImprimible informe = new Informes("Tesxto de informe ", 1,"Juan","Carlos");

      curriculums.imprimri();
      pdf.imprimri();
      informe.imprimri();



    }
}
