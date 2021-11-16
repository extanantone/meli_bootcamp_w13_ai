## Resumen Guía : "Bootcamp Backend Java Sprint Nº 1 - Spring"

### Organización del proyecto

#### Paquetes
<ul>
<li><b>configuración</b>: Requerido para usar la libreria de ModelMapper</li>
<li><b>controladores</b>: 2 principales, usuarios y productos</li>
<li><b>enumerados</b>: Para definir un enumerado de opciones para los parametros de orden</li>
<li><b>servicios</b>: Se usaron 2 Servicios, usuarios y Publicaciones</li>
<li><b>excepciones</b></li>
<li><b>modelos</b></li>
<li><b>repositorios</b></li>
<li><b>dto</b></li>
</ul>


### Clases más relevantes

  Explicaré las clases más relevantes del proyecto:

  - #### Repositorio:
    En el repositorio se definieron 4 collecciones que dieron el orden al proyecto:
    ``` java
      private Map<Integer, Usuario> users;
      private Map<Integer, Publicacion> posts;
      private Map<Integer, List<Publicacion>> userPosts;
      private Map<Integer, List<Usuario>> usuarioySeguidores;
      private Map<Integer, List<Usuario>> usuarioySeguidos;
    ```

    **users y posts**: Garantizan que exista solo un 1 usuario y un post con id único. El repositorio tiene métodos que garantizan que al guardar un dato nuevo, la key de la colección sea el id único del elemento a crear y que las excepciones de unicidad se controlen con una excepción personalizada llamada  **NegocioExcepcion**.

    **userPost**: Guarda las publicaciones de un usuario asociadas a su unico id.
    **usuarioySeguidores**: Guarda una lista que relaciona un id de usuario con sus seguidores.
    **usuarioySeguidos**: Guarda una lista que relaciona un id de usuario con las personas que lo siguen.

    De esta manera se garantiza una busqueda rapida de la información unicamente creando referencias a las posiciones de memoria de los objetos guardados en **users** y **posts**.

  - **ExcepcionesPersonalizadas**

    Todas las clases de expceciones personalizadas implementaran la interface **ExcepcionesPersonalizadas** que permitirá definir un codigo de error de negocio y un mensaje al momento de diparar la excepción, asi los errores de unicidad, datos no encontrados y demás se controlaran con una excepción única llamada **NegocioExcepcion** a la que se le carga un mensaje y un código de error personalizado. 

    ``` java
    public interface ExcepcionesPersonalizadas {
      public Integer getCodigo();
      public String getMensaje();
    }
    ```

  - **Enumerados**

    Con el fin de controlar las opciones de datos desde los parametros de orden "order=name_asc" de las consultas de información, se creo un enumerado, si los datos no estan en este rango de valores se dipará una NegocioExcepcion

    ``` java
    public enum EnumOrdenes {
        name_asc,name_desc,date_desc,date_asc
    }
    ```
- **SpringConfig**

  Siguiendo la guia de los docentes se añade la libreria **ObjectMapper** para facilitar el mapeo de clases de modelo a clases DTO. En esta clase se configura la libreria para crear el bean a utilizar en el código.

  
     




    
