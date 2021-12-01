## Ejercicio 2

 a) La primary key para la tabla cliente es id_cliente. Podría ser el dni en el caso de que éste sea único, pero en esta resolución se optó por un id autoincremental.

 b) La PK para la tabla de planes de internet es un id autoincremental de tipo INT (id_plan_internet). Este id es único considerando todos los planes de todos los clientes.

 c) Un mismo cliente puede contratar varios planes de internet, pero un plan de internet en específico (identificado por su id) pertenece a un solo cliente, por lo que la relación es de 1 a n. La foreign key está en la tabla plan_internet y apunta la PK(id_cliente) de la tabla cliente.

