INSERT INTO empresa_internet.pais(nombre_pais) values ('Argentina');

INSERT INTO empresa_internet.provincia(nombre_provincia, id_pais_provincia) values ('Cordoba',1);
INSERT INTO empresa_internet.provincia(nombre_provincia, id_pais_provincia) values ('La Pampa',1);
INSERT INTO empresa_internet.provincia(nombre_provincia, id_pais_provincia) values ('San Luis',1);

INSERT INTO empresa_internet.ciudad(nombre_ciudad, id_provincia_ciudad) values ('Río Tercero',1);
INSERT INTO empresa_internet.ciudad(nombre_ciudad, id_provincia_ciudad) values ('Rancul',2);
INSERT INTO empresa_internet.ciudad(nombre_ciudad, id_provincia_ciudad) values ('Unión',3);

INSERT INTO empresa_internet.tipo_identificacion(descripcion_tipo_identificacion, codigo_tipo_identificacion) 
values ('Doc (Otro)',99), ('DNI', 96), ('CUIT', 80);

INSERT INTO empresa_internet.cliente
(nro_ident_cliente, nombre_cliente, apellido_cliente, fecha_nacimiento_cliente,
id_tipo_identificacion_persona, id_ciudad_cliente, condicion_persona)
VALUES
('20358940685', 'Martin', 'Paulucci', '1990-12-04', 3, 1, 'Responsable Inscripto'),
('20362207113', 'Vanesa', 'Garro', '1991-06-24', 3, 2, 'Monotributista'),
('34654362', 'Silvina', 'Garro', '1989-10-09', 2, 2, 'Consumir Final'),
('11111111', 'Carlos E.', 'Garro', '1961-03-12', 1, 3, 'Consumir Final'),
('11111111', 'Carlos A.', 'Garro', '1986-12-28', 1, 2, 'Consumir Final'),
('11111111', 'Elvira', 'Destouche', '1970-10-11', 1, 2, 'Consumir Final'),
('11111111', 'Martin Jr', 'Paulucci', '2009-06-06', 1, 2, 'Consumir Final'),
('11111111', 'Martina', 'Paulucci', '2003-12-04', 1, 2, 'Consumir Final'),
('11111111', 'Ana', 'Digo', '1960-11-27', 1, 1, 'Consumir Final'),
('11111111', 'Oscar', 'Paulucci', '1960-09-09', 1, 1, 'Consumir Final');

INSERT INTO empresa_internet.plan (velocidad_plan, precio_plan, nombre_plan) VALUES
(10, 1300.00, 'Basic'),
(20, 1800.00, 'Bronce'),
(30, 2300.00, 'Plata'),
(50, 3600.00, 'Oro'),
(100, 7000.00, 'Platinum');

INSERT INTO empresa_internet.contrata_plan (id_plan_contrata_plan, id_cliente_contrata_plan, 
precio_contrata_plan, descuento_contrata_plan) VALUES
(5, 1, 7000.0, 20.0),
(5, 2, 7000.0, 20.0),
(4, 3, 3600.0, 10.0),
(4, 4, 3600.0, 10.0),
(3, 5, 2300.0, 0.0),
(3, 6, 2300.0, 0.0),
(2, 7, 1800.0, 0.0),
(2, 8, 1800.0, 0.0),
(1, 9, 1300.0, 0.0),
(1, 10, 1300.0,0.0);

