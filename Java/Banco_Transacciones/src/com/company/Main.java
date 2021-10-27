package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    abstract class Transacciones {
        void transaccionOk(){}
        void transaccionNoOk(){}
    }
    class Deposito extends Transacciones{}
    class Transferencia extends Transacciones{}
    class RetiroDeEfectivo extends Transacciones{}
    class ConsultaDeSaldo extends Transacciones{}
    class PagoDeServicios extends Transacciones{}

    interface Cliente{}

    class Ejecutivo implements Cliente{}
    class Basic implements Cliente{}
    class Cobradores implements Cliente{}

}



//Un banco tiene diferentes tipos de transacciones que puede llevar a cabo,
// entre ellas se encuentran: Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios.
// Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().
//A partir de esto existen diferentes tipos de clientes que pueden interactuar con el banco:
//
//Ejecutivos: Realizan Depósitos y Transferencias.
//Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
//Cobradores: Realizan retiro de efectivo y consulta de saldos.
//
//Implementar el escenario según corresponda para permitir a los clientes mencionados con anterioridad,
// el acceso a los diferentes métodos según la operación que deseen realizar.
