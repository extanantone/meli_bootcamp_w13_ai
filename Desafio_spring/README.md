# Social Meli

Inicialmente se encaro el proyecto manejando las entidad vendedor y usuario como separadas , pero pensando a futuro(cuando un usuario quisiera pasar a ser un vendedor), se tomo la decision de que todos los fueran usuarios teniendo la posibilidad de seguirse y ser seguidos, principalmente debido a que en los requerimientos y en la definicion de los endpoints no se veia una clara diferencia entre lo que era un usuario normal a un vendedor, solamente por el tema de dar de alta el producto, en mi concepto no afectaba en si a los requerimientos y facilicitaba el diseño e implementacion de solamente una entidad usuario, de esta manera se crearon 3 modelos usuario, producto y detalle de producto.

En casi todas las solicitudes que se recibieran solamente variables a traves de los endpoints se enviaron a los metodos directamente a la capa servicios, de resto si se recibia un body se trabajo con un dto de la siguiente manera:

Request -> DTO -> Repository o Modelo  -> DTO -> Response

Se trato en lo posible de controlar los edge cases como un usuario que se siga a si mismo, o un usuario que no exista en el sistema, actualmente los usuarios del sistema se inician cuando compila el projecto, se manejan excepciones propias del sistema con un manejador global de excepciones, el sistema cuenta los siguientes usuarios:

  user1 => 1, "Pedro";
  user2 => 2, "Pablo";
  user3 => 3, "Camila";
  user4 => 4, "Diana";
  
  Se dividio los DTO en varios packages de la siguiente forma:
  DTOError => manejo de errores y excepciones
  DTORequest => DTO´s que llegan de los request
  DTOResponses => DTO para enviar respuestas
  Con los DTO divididos, pude reutilizar DTO que ya utilizaba en otras clases que facilmente servian, ademas use el @JsonInclude(JsonInclude.Include.NON_NULL)
  para poder evitar los datos nulos, me causo dificultad usar una capa de mapper asi que directamente hice eso en la capa de servicios.
  
  
* La capa de servicios la dividi por los servicios o acciones relacionadas con el usuario y las relacionadas con producto con su respectiva interface.
* La capa de Repository tiene tambien interface.

