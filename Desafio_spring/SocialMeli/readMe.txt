Documentación Proyecto Sprint 1 - Andres Ferrando:

Se desarrollaron las US-01-02-03-04-05-06-07-08-09

Consideraciones Generales:

	- Los Compradores y Vendedores se trataron como entidades diferentes.

	- El repositorio crea al iniciar el proyecto 2 Compradores y 2 Vendedores.
		- 1 y 2 Son Compradores
		- 3 y 4 Son Vendedores

	-Se trabajo con capas:
		-Controller
		-DTO
		-Exception
		-Model
		-Repository
		-Service

Consideraciones Particulares:

	US-01:
		- Solo compradores pueden seguir a vendedores.
		- Hay validación de que exista tanto comprador como vendedor.
		- Hay Validación de que comprador no haya estado siguiendo previamente al vendedor.
	
	US-02:
		- Validación de que el vendedor exista.

	US-03
		- Validación de que el vendedor exista.

	US-04:
		- Validación de que el comprador exista.

	US-05:
		- Validación de que el "user_id" exista como vendedor.
		- Validación de "id_post". No puede haber 2 publicaciones con el mismo id_post.
		- La fecha la toma como un dato String, luego en el service la convierto a LocalDate.

	US-06:
		- Validación de que exista el user_id del comprador.
		- Validación del parametro order recibido.
		- Me hubiera gustado hacerlo diferente y más optimo.

	US-07:
		- Validación de que exista tanto comprador como vendedor.
		- Validación de que vendedor este siguiendo a comprador.

	US-08:
		- Se integro a US-03 y US-04. Por defecto si no se pasa un order se considera que la lista va a estar ordenada ascendentemente.

	US-09:
		- Se integro a US-06. Por defecto si no se pasa un order se considera que la lista va a estar ordenada descendentemente.

