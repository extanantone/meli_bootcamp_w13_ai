# SocialMELI Testing - Rubén Buelvas


## Tests unitarios.

Los tests unitarios se realizaron sobre los servicios. Se encuentran en los archivos _UserServiceUnitTest.java_ y _PostServiceTest.java_ dentro de la ruta de testing. Para generar datos se utiliza la clase _TestUtilsGenerator_ dentro del paquete _util_ en la ruta de testing.

La aplicación pasa todos los tests, excepto el T-0003: Verificar que el tipo de ordenamiento alfabético exista (US-0008) y el T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009).

## Tests de integración.

Los tests de integración se encuentran en el archivo _SocialMeliIntegrationTest.java_ en el paquete _integration_ dentro de la ruta de testing. 

Estos tests cubren la sección de usuarios, específicamente los escenarios que pueden surgir al seguir y dejar de seguir a un usuario.
