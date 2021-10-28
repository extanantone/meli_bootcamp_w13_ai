package com.MELI.models;

import java.time.LocalDate;

public class Reserva {
        private LocalDate fechaReserva;
        protected double precio;
        private int cantidadDePersonas;

        public Reserva(LocalDate fechaReserva, double precio, int cantidadDePersonas) {
                this.fechaReserva = fechaReserva;
                this.precio = precio;
                this.cantidadDePersonas = cantidadDePersonas;
        }

        public Reserva(LocalDate fechaReserva, int cantidadDePersonas) {
                this.fechaReserva = fechaReserva;
                this.cantidadDePersonas = cantidadDePersonas;
        }

        public LocalDate getFechaReserva() {
                return fechaReserva;
        }

        public void setFechaReserva(LocalDate fechaReserva) {
                this.fechaReserva = fechaReserva;
        }

        public double getPrecio() {
                return precio;
        }

        public void setPrecio(double precio) {
                this.precio = precio;
        }

        public int getCantidadDePersonas() {
                return cantidadDePersonas;
        }

        public void setCantidadDePersonas(int cantidadDePersonas) {
                this.cantidadDePersonas = cantidadDePersonas;
        }
}
