# Desafio Testing
Sprint 2 del desafio - Bootcamp JAVA

## Descripcion
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica  anexada.

### Escenario
SocialMeli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.
Como documentación de respaldo, un analista funcional adjunta el siguiente documento de requerimientos técnicos y funcionales

### Bonus
Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con diferentes tests de integración además de los tests unitarios para tener un coverage mayor o igual al 80%.
El especialista conoce los tiempos acotados con los que se cuenta para realizar el desarrollo solicitado, por lo que sugiere llevar a cabo esta implementación solo en caso de que alcancen los tiempos y se pueda cumplir con la fecha de entrega estimada.

### Criterios
 * Se utilizo el mismo proyecto desarrollado en el sprint anterior, con algunas modificaciones:
 * - Se cambiaron los tipos de datos primitivos de los DTOs de request por wrappers con el fin de poder probar las vaidaciones NotNull
 * - Se agregaron Exceptions handler para mostrar las excepciones de validacion con un JSON
 * - Se agrego un DTO para poder retornar el detalle de validaciones que fallaron
 * - Se creo 1 post de promo por defecto en los repositorios para poder probar desde los test de integracion