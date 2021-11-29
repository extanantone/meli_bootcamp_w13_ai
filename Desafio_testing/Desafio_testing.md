# Desafio Testing Readme =)

## Consideraciones Validaciones

Dentro de los casos "es positivo" y "no puede ser nulo"
para los enteros se manejó con el mismo mensaje de error con las intruccion @Positive
que verifica para el tipo primitivo que sea mayor a 0 (sabiendo que si el
ingreso es nulo será por defecto 0)

Dentro del GlobalHandlerException se añadió el método handleValidationExceptions
donde se parsean todos los errores de validación a String y así poder ser devueltos
en su conjunto a través del creado anteriormente ExceptionDTO que admite un mensaje 
String.

## Consideraciones Test

Se realizaron 23 test, 11 unitarios y 12 de integración (cubriendo las 12 user stories).
Con un Class coverage del 100%, lines 92% y method 90%.
Se testearon únicamente de forma unitaria los métodos con
la funcionalidad requerida, por ejemplo si se requeria testear la accion "follow"
solo se realizo el test donde se ejecuta dicha accion en el service
y no el controller (que de todas formas es testeado en la etapa de integración)

No se fué 100% exhaustivo en los test de integración
con la verificación de todos los parámetros. Por ejemplo no se verificó que la lista
de post devuelva los 14 atributos de cada post sino solamente el id.

## Bugfix

Se corrigió un bug de la entrega pasada donde no se realizaba
un correcto ordenamiento por fechas, en ambos casos
DATE_ASC y DATE_DESC se ordenaban de forma ascendente por un error de tipeo.
Método sortPostByDate en SocialService.

Este bug fue identificado gracias al test unitario de la etapa


## Pruebas
Se adjunto en este mismo directorio el archivo collection tipo JSON del que se pueden importar las pruebas realizadas en POSTMAN

## Por mejorar
Implementar el writer de ObjectMapper para convertir los objetos a strings. En los test de integración hechos estos fueron directamente hardcodeados en String.
