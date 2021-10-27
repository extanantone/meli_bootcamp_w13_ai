package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

interface Enseña { }
abstract class Estudiante {};

class Tutor extends Estudiante implements Enseña {};
class EstudianteTecnico extends Estudiante {};

abstract class Personal {};

class PersonalDeMantenimiento extends Personal {};
class Profesores extends Personal implements Enseña{};




//Asuma que queremos modelar personas de una universidad para implementar un
//sistema de administración de cursos. Hay diferentes personas involucradas:
//miembros del personal, estudiantes, profesores, personal de mantenimiento, tutores,
//personal de soporte técnico y estudiantes técnicos. Los tutores y los estudiantes
//técnicos son interesantes: los tutores son estudiantes que han sido elegidos para
//enseñar algo y los estudiantes técnicos son estudiantes que han sido seleccionados
//para colaborar en el soporte técnico. Realice una jerarquía de tipos (clases e
//interfaces) que represente esta situación. Reproduce un escenario donde se muestre
//qué tipos son clases concretas, clases abstractas e interfaces.