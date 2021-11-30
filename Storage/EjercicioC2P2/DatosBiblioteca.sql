INSERT INTO biblioteca.autor(nombre, nacionalidad) VALUES
('Niccolò Ammaniti','Italiana'),
('Roberto Saviano','Italiana'),
('Yanina Rosenberg','Argentina'),
('Elena Castro Galan', 'Argentina'),
('Paloma Martinez Fernandez', 'Francesa'),
('Ana Ma Iglesias Maqueda', 'Argentina')
('Adoración de Miguel Castaño','Francesa'),
('Oliver Berry','Ingles');

INSERT INTO biblioteca.libro(titulo, editorial, area) VALUES
('Yo no tengo miedo', 'Michele', 'Literatura'),
('Gomorra', 'Michele', 'Literatura'),
('La piel intrusa', '','Literatura'),
('Páginas de Espuma','Independiente','Literatura'),
('Desarrollo de Bases de Datos: casos prácticos desde el análisis a la implementación','RA-MA S.A. Editorial y Publicaciones', 'Base de Datos'),
('Diseño de bases de datos: problemas resueltos', '', 'Base de Datos'),
('El Universo: Guía de viaje', 'Independiente', 'Literatura');

INSERT INTO libro_autor(id_libro,id_autor) VALUES 
(1,1),
(2,2),
(3,3),
(4,3),
(5,4),
(5,5),
(5,6),
(6,4),
(6,5),
(6,7),
(7,8);