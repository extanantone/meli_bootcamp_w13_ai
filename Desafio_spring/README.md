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
7. Si se busca un tipo en el detalle del prodcuto del cual no haya ningún post, se envia el mensaje al usuario expresando eso

## End point adicional porque sobró algo de tiempo
Se trata de un endpoint que lista todas las publicaciones de un mismo tipo. El tipo a buscar puede ser en mayúscula o minúscula pues el sistema no discrimina por eso, sin embargo si debe estar escrito igual con respecto a las tildes y acentos.

### Método
```java
localhost:8080/products/{type}/list-type
```

### Ejemplo
```java
localhost:8080/products/Gamer/list-type
```

### Response
```java
[
    {
        "user_id": 24,
        "id_post": 281,
        "date": "11-11-2021",
        "detail": {
            "product_id": 1,
            "product_name": "pc",
            "type": "Gamer",
            "brand": "Acer",
            "color": "Red & Black",
            "notes": "Ryzen"
        },
        "category": 100,
        "price": 1500.5,
        "has_promo": true,
        "discount": 0.1
    },
    {
        "user_id": 24,
        "id_post": 28,
        "date": "11-11-2021",
        "detail": {
            "product_id": 1,
            "product_name": "silla",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition"
        },
        "category": 100,
        "price": 1500.5,
        "has_promo": true,
        "discount": 0.1
    }
]
```

#### En caso de que el Tipo no exista
```java
{
    "mensaje": "No hay ninguna publicación con el tipo que está tratando de buscar.",
    "statusCode": 400
}
```
