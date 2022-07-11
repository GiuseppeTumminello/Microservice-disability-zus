# Disability Zus Microservice

The microservice calculates the Disability Zus amount from the monthly gross salary.
The endpoints are available in the following endpoints using the HTTP POST method:

* http://localhost:8080/disability-zus/calculation/8000
* http://localhost:8098/disability-zus/calculation/8000

The response will look like as following:

{
"value": "391.99",
"description": "Disability zus"
}

The actuator will be accessible via the following links:

* http://localhost:8080/disability-zus/actuator
* http://localhost:8098/disability-zus/actuator


The first endpoint is accessible via Spring api Gateway and the second one through the server port.

Swagger it is available via the following endpoints:

* http://localhost:8080/swagger-ui/?urls.primaryName=disability-zus
* http://localhost:8098/disability-zus/v3/api-docs

The first endpoints is accessible via Spring api Gateway and the second ones through the server port.