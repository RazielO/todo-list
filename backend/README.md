# To Do List Backend

## Overview

This folder contains the source code for the backend server that powers the project.

## Table of Contents

* [Folder Structure](#folder-structure)
* [Dependencies](#dependencies)
* [Endpoints](#endpoints)

## Folder Structure

The main files and folders of the backend are:

* `src/main/kotlin/com/raziel/todo`. Contains the Kotlin source code:
    - `controller/TodoController.kt`. REST Controller with API endpoints.
    - `entity/Todo.kt`. JPA model of the to do item.
    - `repository/TodoRepository.kt`. Interface to make database operations.
    - `TodoApplication.kt`. Entry point for the app.
* `src/main/resources`. Contains configuration files, such as `application.properties`.

## Dependencies

* [Kotlin](https://kotlinlang.org/)
* [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/)
* [Spring Boot](https://spring.io/projects/spring-boot/)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa/)
* [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc/)
* [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/)

## Endpoints

| Endpoint            | HTTP Method | Description                              |
|---------------------|-------------|------------------------------------------|
| `/todo/all`         | `GET`       | Query all to-dos created                 |
| `/todo`             | `POST`      | Create a new to do                       |
| `/todo/{id}`        | `PUT`       | Update the to do with the given ID       |
| `/todo/{id}/toggle` | `PUT`       | Toggle the completion state of the to do |
| `/todo/{id}`        | `DELETE`    | Delete the to do with the given ID       |
