SELECT * FROM empresa_internet.Cliente c where (SELECT count(*) from empresa_internet.oferta o where o.cliente=c.idCliente)=0;

SELECT * FROM empresa_internet.Cliente c where (SELECT count(*) from empresa_internet.oferta o where o.cliente=c.idCliente)>0;


SELECT AVG(discount) from empresa_internet.Oferta;

SELECT c.NOMBRE 
from empresa_internet.Cliente c INNER JOIN empresa_internet.Oferta o on o.cliente = c.idCliente 
where o.discount = (select max(discount) from empresa_internet.Oferta);

