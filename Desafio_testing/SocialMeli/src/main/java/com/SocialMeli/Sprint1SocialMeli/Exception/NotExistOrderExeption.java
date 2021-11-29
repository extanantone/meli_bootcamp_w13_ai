package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotExistOrderExeption extends RuntimeException{

        public NotExistOrderExeption() {
            super("No se envio parametro de orden");
        }
    }

