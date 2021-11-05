classDiagram
	class Type{
		<<enumeration>>
		reserva
        comida
        boleto
        transport
	}
    class ItemLocalizador{
        <<interface>>
        
        getType() Type
        getPrecio() double
    }

    class ReservaHotel{
    }
    
    class Comida{
    }

    class Boleto {
    }
    
    class Transporte {
    }

    ItemLocalizador <|-- ReservaHotel
    ItemLocalizador <|-- Comida
    ItemLocalizador <|-- Boleto
    ItemLocalizador <|-- Transporte

    class Promocion{
    }

    class Completa{
    }
    
    class HotelX2{
    }

    class LocalizadorX2{
    }
    
    Promocion <|-- Completa
    Promocion <|-- HotelX2
    Promocion <|-- LocalizadorX2

    class Paquete{

    }
    
    Paquete *-- ItemLocalizador
