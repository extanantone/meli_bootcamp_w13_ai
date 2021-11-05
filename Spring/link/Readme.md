# Excercice

# Example use

    - Add url

    POST
    ROUTE http://localhost:8080/link

    {
    "url":"https://www.google.com/",
    "password":"test"
    }

    - Redirect

    GET
    Route http://localhost:8080/link/1?password=test

    - Invalid

    POST
    ROUTE http://localhost:8080/link/invalidate/1

    - Metrics

    GET
    Route http://localhost:8080/metrics/1