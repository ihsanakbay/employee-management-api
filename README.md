# HR Employee Management API with Spring Boot 3

## Summary

This project provides api services to create company and it's employees.

### Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* Kotlin
* OpenApi
* Docker & Docker Compose
* Postgres

### Run & Build

1. Docker Compose
* You just need to run ```docker compose up``` inside of the main folder.
```bash
$ cd employee-management-api
$ docker compose up
```
2. Maven
```bash
$ cd employee-management-api
$ mvn clean install
$ mvn spring-boot:run
```

### Swagger-UI

```http://localhost:${PORT}/swagger-ui.html```
