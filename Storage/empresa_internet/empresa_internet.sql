use empresa_internet;
-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
INSERT INTO cliente (id_cliente, nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES (1, "Lionel", "Messi", "1986-06-10", "Santa Fe", "Rosario", 20055066);
INSERT INTO cliente (id_cliente, nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES (2, "Ángel", "Di Maria", "1983-08-12", "Santa Fe", "Rosario", 15056266);
INSERT INTO cliente (id_cliente, nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES (3, "Leandro", "Paredes", "1990-04-20", "Santa Fe", "Rafaela", 24123066);
INSERT INTO cliente (id_cliente, nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES (4, "Emiliano", "Martinez", "1987-01-11", "Buenos Aires", "CABA", 20000101);
INSERT INTO cliente (id_cliente, nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES (5, "Nahuel", "Molina", "1995-05-30", "Córdoba", "Rio Cuarto", 32054367);
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES ("Alejandro", "Gómez", "1989-06-03", "Buenos Aires", "Mar del Plata", 22345555);
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES ("Nicolás", "Otamendi", "1985-02-10", "Salta", "Salta", 19009809);
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES ("Cristian", "Romero", "1992-11-13", "Córdoba", "Córdoba", 38980999);
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES ("Rodrigo", "De Paul", "1990-06-25", "Entre Ríos", "Paraná", 34000172);
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, dni) VALUES ("Giovanni", "Lo Celso", "1991-04-19", "Santa Fe", "Rosario", 33120120);

INSERT INTO plan_internet (id_plan_internet, velocidad, precio, descuento, id_cliente) VALUES (100, 300.5, 2500, 0.10, 1);
INSERT INTO plan_internet (id_plan_internet, velocidad, precio, descuento, id_cliente) VALUES (101, 100, 1800, 0.25, 1);
INSERT INTO plan_internet (id_plan_internet, velocidad, precio, descuento, id_cliente) VALUES (102, 500, 3500, 0.15, 2);
INSERT INTO plan_internet (id_plan_internet, velocidad, precio, descuento, id_cliente) VALUES (103, 350.1, 2000, 0.20, 3);
INSERT INTO plan_internet (id_plan_internet, velocidad, precio, descuento, id_cliente) VALUES (104, 50.5, 1500, 0.05, 4);

-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. 
-- clientes cuyo apellido tiene una M
select nombre, apellido from cliente where apellido LIKE "%m%" or "%M%";
-- clientes con residencia en la provincia de Santa Fe
select nombre, apellido from cliente where provincia = "Santa Fe";
-- listar clientes por fecha de nacimiento ascendente
select nombre, apellido, fecha_nacimiento from cliente order by fecha_nacimiento ASC;
-- mostrar el plan mas costoso
select * from plan_internet where precio = (select max(precio) from plan_internet);
-- ordenar clientes alfabeticamente ascendente
select nombre, apellido from cliente order by nombre,apellido ASC;
-- mostrar la cantidad de clientes
select count(*) as 'cantidad de clientes' from cliente;
-- imprimir el promedio de velocidad en megas de todos los planes contratados
select avg(velocidad) as 'promedio velocidad en megas' from plan_internet;
-- clientes nacidos en el año 1990
select nombre, apellido from cliente where year(fecha_nacimiento) = 1990;
-- clientes cuyo dni es par
select nombre, apellido from cliente where dni%2 = 0;
-- plan con el menor descuento
select * from plan_internet where descuento = (select min(descuento) from plan_internet);
