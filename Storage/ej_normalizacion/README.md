## Consideraciones

 - Se han generado 3 entidades: facturas, articulos y clientes. Se separaron los datos especificos de cada una. Hay una 4º tabla que relaciona factura con articulo ya que es una relacion nxm: un articulo puede aparecer en varias facturas, y una factura puede contener varios articulos. A su vez, en esta nueva tabla se especifica la cantidad de ese articulo en especifico a comprar.
 - En una factura puede figurar un unico cliente, pero tal cliente puede aparecer en varias facturas.
 - Se agrego el atributo precio en articulos para indicar el precio unitario de tal articulo.
 - En la tabla facturas está el atributo importe_total, el cual puede parecer redundante ya que se calcula a partir de los atributos cantidad y precio.

