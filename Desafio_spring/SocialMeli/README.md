# Sprint Nº1 - Proyecto Bootcamp Backend
## SocialMeli

**Temas:** Git, Java y Spring.

**Autor:** Alejandro Ferrero.

**Email:** alejandro.ferrero@mercadolibre.com

## Consideraciones
 - Se consideran vendedores a aquellos usuarios que tienen al menos un posteo.
 - Un usuario no puede serguirse (o dejarse de seguir) a sí mismo.
 - Solo se pueden seguir a vendedores (aquellos que tienen al menos una publicacion).
 - Cada publicación es de solo un producto.
 - Los vendedores pueden seguir a otros vendedores.
 - Las promociones son consideradas como publicaciones "especiales". 
Estas se guardan en la misma lista con todas las publicaciones y cuando se solicitan las publicaciones de las ultimas dos semanas también se muestran las promociones.
 - Para que un usuario pueda seguir a otro, éste debe ser un vendedor, es decir, tener al menos una publicación.
 - Los posteos no pueden contener una fecha futura.
 - El descuento a aplicar a las promociones debe estar comprendido entre el 0% y el 100%.

### Diagrama de clases del Modelo
![alt text](doc/socialmeli_class_diagram/modelClassDiagram.png)