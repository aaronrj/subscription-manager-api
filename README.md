# Subscription Manager API

A RESTful API built with Spring Boot to manage recurring subscriptions.
The application allows users to create, update, delete and analyze monthly expenses.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Lombok

---

## 🏗 Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

- **Controller** handles HTTP requests.
- **Service** contains business logic.
- **Repository** communicates with the database.
- **PostgreSQL** stores subscription data.

---

## 🐳 Running with Docker

### 1️⃣ Start PostgreSQL

```bash
docker compose up -d
```

### 2️⃣ Run the application

Run `SubscriptionManagerApiApplication` from IntelliJ  
or use:

```bash
mvn spring-boot:run
```

The application runs on:

```
http://localhost:8080
```

---

## 📌 API Endpoints

### CRUD

- `GET /subscriptions` → Get all subscriptions
- `GET /subscriptions/{id}` → Get subscription by ID
- `POST /subscriptions` → Create subscription
- `PUT /subscriptions/{id}` → Update subscription
- `DELETE /subscriptions/{id}` → Delete subscription

### Statistics

- `GET /subscriptions/stats/total-monthly`
- `GET /subscriptions/stats/active-monthly`

---

## 📥 Example Request

### Create Subscription

```json
POST /subscriptions

{
  "name": "Netflix",
  "monthlyCost": 12.99,
  "category": "Streaming",
  "active": true
}
```

---

## 📊 Features Implemented

- Full CRUD operations
- Monthly cost statistics
- Layered architecture (Controller-Service-Repository)
- Dockerized PostgreSQL
- Automatic table creation with Hibernate

---

## 👨‍💻 Author
Aaron Rodríguez Jiménez  

## About This Project
This project is part of my backend portfolio and focuses on building structured REST APIs using Spring Boot and PostgreSQL.

