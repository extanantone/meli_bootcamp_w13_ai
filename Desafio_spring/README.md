# SOCIAL MELI

Para esta prueba decidí que solo los usuarios de tipo comprador podrán seguir a los usuarios de tipo vendedor.
En ese orden de ideas, los usuarios vendedores son aquellos que tienen seguidores y pueden hacer publicaciones.
Los usuarios compradores sólo pueden seguir vendedores, dejarlos de seguir y ver publicaciones de los vendedores.

Para iniciar y cargar los datos creé una especie de endpoint inicial que se puede llamar con un GET así:
```java
localhost:8080/cargar
```

Esto con el fin de cargar la información de algunos compradores y vendedores para facilitar las pruebas.

El resto de endpoints si se hacen tal cual como están en la documentación entregada.



## Validaciones adicionales que se tuvieron en cuenta:
1. Que el id del vendedor exista
2. Que el id del comprador exista
3. Que el id del post no se repita
4. Que valide si un comprador ya antes seguía a un vendedor
5. Que valide si un comprador no seguía antes a un vendedor (para dar unfollow)
6. Que si por definición el endpoint no devuelve nada, en mi caso se devuelva un dto con un mensaje exitoso
