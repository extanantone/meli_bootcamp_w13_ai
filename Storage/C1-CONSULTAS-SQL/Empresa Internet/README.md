# Ejercicio de planes de internet

##Preguntas
¿Cuál es la primary key para la tabla de clientes?
Para clientes se aplicara un id por aparte del DNI, puesto que puede haber problema con
usuarios extranjeros.
b. ¿Cuál es la primary key para la tabla de planes de internet?
Se plantea una clave primaria para planes de internet, ya que no hay algún valor que sea exclusivamente único y no hemos llegado a generar claves primarias compuestas.
c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key?
Se plantea una tabla agenda a las dos entidades de cliente y plan, puesto que puede que el cliente decida tener mas de un plan y esto no debe significar un problema para la base de datos.

#Empresa_internet
Se crea la base de dato con base en el DER generado (ver figura dentro de la carpeta raíz)
Adicional a ello, se plantean las siguientes consultas una vez se haya sincronizado el modelo en workbench:

INSERT INTO internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	1111,
    'ANDRÉS',
    'MORALES',
    '2000-04-02',
    'LOS ANGELES',
    'BOGOTA'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	22,
    'CARLOS',
    'MORALES',
    '2009-04-02',
    'LOS ANGELES',
    'MEDELLIN'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	333,
    'PEPE',
    'MORALES',
    '2000-09-02',
    'LOS ANGELES',
    'BOGOTA'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	23,
    'JUAN',
    'MORALES',
    '2003-04-02',
    'LOS ANGELES',
    'MEDELLIN'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	1324,
    'RAMIRO',
    'MORALES',
    '2005-04-02',
    'LOS ANGELES',
    'BOGOTA'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	12412,
    'ANIBAL',
    'MORALES',
    '2003-04-02',
    'LOS ANGELES',
    'MEDELLIN'
);
INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	233,
    'OSCAR',
    'MORALES',
    '2001-04-02',
    'LOS ANGELES',
    'BOGOTA'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	423,
    'SANTIAGO',
    'MORALES',
    '2000-12-02',
    'LOS ANGELES',
    'MEDELLIN'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	412,
    'FREDDY',
    'MORALES',
    '2002-04-02',
    'LOS ANGELES',
    'BOGOTA'
);

INSERT INTO empresa_internet.cliente (dni, first_name, last_name, birth_date, location_state, city) VALUES (
	314,
    'KAREN',
    'MORALES',
    '2004-04-02',
    'LOS ANGELES',
    'MEDELLIN'
);

INSERT INTO empresa_internet.plan (connection_speed, price, discount, name) VALUES (
	15.0,
    50000.0,
    0.15,
    'Ultra velocidad'
);

INSERT INTO empresa_internet.plan (connection_speed, price, discount, name) VALUES (
	750.0,
    250000.0,
    0.10,
    'SemiGiga'
);

INSERT INTO empresa_internet.plan (connection_speed, price, discount, name) VALUES (
	25.0,
    60000.0,
    0.0,
    'Familiar'
);

INSERT INTO empresa_internet.plan (connection_speed, price, discount, name) VALUES (
	500.0,
    150000.0,
    0.15,
    'Gamers'
);

INSERT INTO empresa_internet.plan (connection_speed, price, discount, name) VALUES (
	10.0,
    30000.0,
    0.20,
    'Ligera velocidad'
);

--Se insertan las relaciones de cliente -> plan
INSERT INTO empresa_internet.cliente_has_plan VALUES (
	1, 1
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	1, 2
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	2, 1
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	2, 4
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	3, 1
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	4, 1
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	5, 3
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	6, 4
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	7, 5
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	8, 1
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	9, 1
);

INSERT INTO empresa_internet.cliente_has_plan VALUES (
	10, 5
);

-- Se eliminan dos registros duplicados
 -- delete from cliente where id_cliente= 1;
 -- delete from cliente where id_cliente= 2;

-- Consultas a la base de datos
-- Se listan los registos
-- De clientes
select * from cliente;

-- De planes
select * from plan;

--Mostrar nombre, apellido y ciudad de todos los clientes
select cl.first_name, cl.last_name, cl.city from cliente as cl;

-- Mostrar el nombre, el precio y la velocidad de todos los planes
select pl.name, pl.price, pl.connection_speed from plan as pl;

-- Mostrar el nombre y numero de documento del cliente y el nombre del plan contratado
select cl.first_name as nombre_cliente, cl.dni, pl.name as plan_nombre from cliente as cl, plan as pl, cliente_has_plan as cp where cl.id_cliente= cp.cliente_id_cliente and pl.id_plan = cp.plan_id_plan;

-- Mostrar nombre, el valor y el descuento de todos los planes
select pl.name, pl.price, pl.discount from plan as pl;

-- Listar toda la informacion de los planes cuyo descuento es mayor al 10% y el valor -- final con descuento
select *, pl.price as precio_sin_descuento, (pl.price - pl.price * pl.discount) as precio_con_descuento from plan as pl where pl.discount > 0.10;

-- Listar el nombre del plan mas contratado
select pl.name from plan as pl, cliente_has_plan as cp where pl.id_plan= cp.plan_id_plan order by cp.plan_id_plan asc limit 1;

-- Listar los planes que no hayan sido contratados mas de una vez
select pl.name, count(cp.plan_id_plan) count from plan as pl, cliente_has_plan as cp where pl.id_plan = cp.plan_id_plan group by pl.name, cp.plan_id_plan having count(cp.plan_id_plan) < 2;

-- Listar el nombre, el apellido, el dni y el valor sin descuento del plan contratado para todos los clientes
select cl.first_name, cl.last_name, cl.dni, pl.price from cliente as cl, plan as pl, cliente_has_plan as cp where cl.id_cliente= cp.cliente_id_cliente;

-- Listar el nombre, el apellido, el dni y el valor con descuento del plan contratado para todos los clientes
select cl.first_name, cl.last_name, cl.dni, pl.price as precio_sin_descuento, (pl.price - pl.price * pl.discount) as precio_con_descuento from cliente as cl, plan as pl, cliente_has_plan as cp where cl.id_cliente= cp.cliente_id_cliente;
