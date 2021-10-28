package com.company;

public class Distribuidora {
    //Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
// imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array
// con los datos que quieras.
    Producto arroz = new Perecedero("Arroz", 300);
    Producto milanesa = new Perecedero("Milanesa", 200);
    Producto zanahoria = new Perecedero("Zanahoria", 100);
    Producto chocolate = new Perecedero("Chocolate", 500);
    Producto manzana = new Perecedero("Manzana", 400);
    Producto agua = new NoPerecedero("Agua", 100, "Villavicencio");
    Producto computadora = new NoPerecedero("Computadora", 500, "escritorio");
    Producto mesa = new NoPerecedero("Mesa", 399, "madera");
    Producto silla = new NoPerecedero("Silla", 1000, "plástico");
    Producto mouse = new NoPerecedero("Mouse", 450, "inalámbrico");

    Producto[] productos = {arroz, milanesa, zanahoria, chocolate, manzana, agua, computadora, mesa, silla, mouse};

    for (let i)

    public static void main(String[] args) {
        // write your code here
    }

}
