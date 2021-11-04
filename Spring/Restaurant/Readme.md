# Excercice restaurant

    Post request
    url: http://localhost:8080/restaurante/calorias
    payload example:


    {
        "name":"lasagna",
        "ingredients":[
            {
            "name":"Piñones",
            "weight":2
            },{
                "name":"Cuajada",
                "weight":100
            }
    
        ]
    }

    result example:
    
    {
        "fullCalories": 105.2,
        "mostClaoriesIngredienteName": "Cuajada",
        "ingredients": [
            {
                "name": "Piñones",
                "calories": 13.2
            },
            {
                "name": "Cuajada",
                "calories": 92.0
            }
        ]
    }