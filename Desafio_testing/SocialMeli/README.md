# Consideraciones sobre el desafío
1) Tras cada test de integración dentro de `SocialMeliApplicationTests` los datos de los repositorios de la aplicación no se resetean.
Por lo tanto, los datos usados por cada test están adaptados para simular la independencia entre ellos. 
   Alternativamente se podría haber implementado un método que se encargue de reiniciarlos (y sea llamado con la anotación BeforeEach).
   
2) Se agregó la validación de fecha futura de publicación en PostDTO, la cual no se verificó a través de un test unitario pero restringe este dato a fechas pasadas o presentes.

3) Las expresiones regulares (regex) presentes en las diversas validaciones de variables de instancia de tipo String verifican que el contenido comience en mayúscula (con o sin diéresis o tildes, o Ñ), continúe con o sin mayúscula (agregando la posibilidad de números) y forme una frase (palabras separadas por espacios).
En algunos casos se consideró también el uso de comas o puntos al final de palabras.
   No se contempló el uso de guiones medios, guiones bajos, entre otros signos de puntuación y expresión.
   
4) Si bien el proyecto se encuentra adaptado del provisto por la rama "profes", se eliminaron las clases y métodos no utilizados para lograr llegar a la cobertura de la parte bonus.
Además se cambió ligeramente el formato de los métodos y se agregó una excepción para el caso de order nulo en la lista de productos recientes (US 0006).
   
5) Se agregaron tests unitarios sobre ambos repositorios (UserRepository y PostRepository) para verificar su correcto funcionamiento antes de pasar a los del servicio.

6) Antes de cada test unitario de servicio se resetean los mocks de los repositorios para poder verificar apropiadamente la cantidad de veces que una función es invocada en algunos de ellos.