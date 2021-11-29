## Resumen Guía : "Bootcamp Backend Java Sprint Nº 1 - Spring"

### Organización del proyecto

1. [Generalidades del proyecto](#item1)
2. [Generalidades Testing](#item2)

<a name = "item1"></a>
### 1. Generalidades proyecto

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

    Todas las clases de excepciones personalizadas implementarán la interface **ExcepcionesPersonalizadas** que permitirá definir un codigo de error de negocio y un mensaje al momento de diparar la excepción, asi los errores de unicidad, datos no encontrados y demás se controlaran con una excepción única llamada **NegocioExcepcion** a la que se le carga un mensaje y un código de error personalizado. 

    ``` java
    public interface ExcepcionesPersonalizadas {
      public Integer getCodigo();
      public String getMensaje();
    }
    ```

  - **Enumerados**
    
      - **EnumOrdenes**
      
    Con el fin de controlar las opciones de datos desde los parametros de orden "order=name_asc" de las consultas de información, se creo un enumerado, si los datos no estan en este rango de valores se dipará una NegocioExcepcion

      ``` java
      public enum EnumOrdenes {
          name_asc,name_desc,date_desc,date_asc
      }
      ```
      - **EnumErrs**
    
      Esta clase se creó para tener enumerados de control de errores y códigos. De esta manera reutilizo mensajes y códigos de error que se envian al cliente ante los diferentes eventos.

      ``` java
        /**"ya sigues al id: {}."*/
        ALREADY_FOLLOWED(105,"ya sigues al id: {}."),
        /**"No se reconoce el valor {} del campo order"*/
        PARAMETER_NOT_FOUND(106,"No se reconoce el valor {} del campo order"),
    ```

  - **SpringConfig**

    Siguiendo la guía de los docentes se añade la librería **ObjectMapper** para facilitar el mapeo de clases de modelo a clases DTO. En esta clase se configura la libreria para crear el bean a utilizar en el código.
    
<a name = "item2"></a>
  ### 2. Generalidades testing

Para la entrega de requisitos de testing hay algunas particularidades:

1. Se logró el 80% de coverage utilizando pruebas de integración; sin embargo, por error, se puso orden en la ejecución de los testing de
integración para disminuir la carga y el tiempo de configuración de cada testing para aislarlos, esto se evitará en el futuro.
2. Se realizó el control de formato de números con la estructura "10.000.000,00", sin embargo este campo se llamó precioString, debido a que posteriormente se eliminó de los requisitos del proyecto.
Este campo puede ser observado en la clase PublicacionesDTO, en donde existen 2 campos de precio "precio" y "precioString", el control del máximo se hizo con dos métodos adicionales en la clase Utils.valValorString y Utils.cleanNumeric y un constructor personalizado para el caso de desear usar el precio String.


     




    
