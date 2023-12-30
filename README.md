# To Do List

Docker Compose project with Spring Boot, PostgreSQL & Svelte

This project is a full-stack application consisting of a backend developed with Spring Boot and Kotlin, a PostgreSQL database, and a frontend built with Svelte.

## Project Structure

- [Backend](backend/README.md): Spring Boot application written in Kotlin.
- [Database](db/README.md): PostgreSQL database configuration.
- [Frontend](frontend/README.md): Svelte application for the user interface.

Each part of the app is containerized with Docker and managed with Docker Compose.

## Prerequisites

Before getting started, ensure you have the following installed:

- Docker
- Docker Compose

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/RazielO/todo-list.git
```

2. Navigate to the project folder:

```bash
cd todo-list
```

3. Build and run the Docker containers:

```bash
docker-compose up --build
```

This command will start the containers for the backend, database, and frontend.

4. Access the application:

http://localhost:5000

## Configuration

- Database: PostgreSQL is configured with default settings in the `docker-compose.yml` file. Modify it according to your database requirements.
- Backend: Adjust any configuration settings in the backend's `application.properties` file.

## API Endpoints

Backend API endpoints are documented in the [Backend README](backend/README.md).

## License

This project is licensed under the [MIT License](LICENSE).