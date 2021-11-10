# Uso del api

### Listar todos

GET

http://localhost:8080/messengers

### Mostrar mensage por item

GET

http://localhost:8080/messengers/1/message/Hola%20Juan

Inicialmente va a enviar error por que los elementos no cuentan con las condiciones para mostrar el mensage

### Actualizar paloma

PUT

Payload

    {
       "comida":10,
       "tiempoDescanzo":10
    }
Ahora si ejecutamos este get http://localhost:8080/messengers/1/message/Hola%20Juan
deberia ser satisfactorio

# Actualizar telefono celular

PUT

http://localhost:8080/celulares/4

payload

    {
       "datos":1,
       "bateria":10
    }
Ahora si ejecutamos este get http://localhost:8080/messengers/4/message/Hola%20Juan
deberia ser satisfactorio

# Actualizar Telegrafo

PUT

http://localhost:8080/telegrafos/3

payload

    {
       "listen":true
    }

Ahora si ejecutamos este get http://localhost:8080/messengers/3/message/Hola%20Juan
deberia ser satisfactorio