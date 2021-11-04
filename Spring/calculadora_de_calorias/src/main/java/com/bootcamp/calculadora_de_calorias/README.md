### Ejemplo Request
{
    "nombre" : "Ensalada",
    "ingredientes" : [
            {
                "nombre" : "Tomate",
                "peso" : 500
            },
            {
                "nombre" : "Lechuga",
                "peso" : 330
            },
            {
                "nombre" : "Cebolla",
                "peso" : 200
            }
        ]
}

### Ejemplo Response
{
    "nombre" : "Ensalada",
    "cantTotalCalorias" : 1234,
    "ingredientes" : [
            {
                "nombre" : "Tomate",
                "calorias" : 111
            },
            {
                "nombre" : "Lechuga",
                "calorias" : 222
            },
            {
                "nombre" : "Cebolla",
                "calorias" : 333
            }
        ],
    "ingredienteConMasCalorias" : "Cebolla"
}