# SOCIAL MELI

Para esta prueba decidí que solo los usuarios de tipo comprador podrán seguir a los usuarios de tipo vendedor.
En ese orden de ideas, los usuarios vendedores son aquellos que tienen seguidores y pueden hacer publicaciones.
Los usuarios compradores sólo pueden seguir vendedores, dejarlos de seguir y ver publicaciones de los vendedores.

Para iniciar y cargar los datos creé una especie de endpoint inicial que se puede llamar así:
```java
localhost:8080/cargar
```

Esto con el fin de cargar la información de algunos compradores y vendedores para facilitar las pruebas.

El resto de endpoints si se hacen tal cual como están en la documentación entregada.
