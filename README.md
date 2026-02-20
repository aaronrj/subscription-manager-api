# SubTrackAPI 
---

Proof of Concept (PoC) – Subscription Manager Backend API 
Febrero 2026 
SubTrackAPI es una API REST desarrollada con Spring Boot para la gestión de suscripciones digitales. Permite crear, consultar, actualizar y eliminar suscripciones, además de calcular el gasto mensual total y el gasto de suscripciones activas. 
Este proyecto representa una primera versión funcional (MVP técnico) como base para futuras mejoras y evolución hacia un producto más completo. 

--- 

## 🚀 Tecnologías Utilizadas 

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL 15
- Docker & Docker Compose
- Swagger (OpenAPI)

---

## 🏗 Arquitectura 

El proyecto sigue una arquitectura en capas (Layered Architecture): 

Controller → Service → Repository → PostgreSQL 

- **Controller**: Gestiona las peticiones HTTP
- **Service**: Contiene la lógica de negocio
- **Repository**: Acceso a datos mediante JPA
- **PostgreSQL**: Base de datos relacional ejecutada en Docker

Esta estructura permite mantener el código limpio, escalable y mantenible.

--- 

## 🐳 Cómo Ejecutar el Proyecto (Docker) 

Desde la raíz del proyecto:

```bash
docker compose up --build -d
```

Verificar que los contenedores estén activos:

```bash
docker compose ps
```

Para detener y limpiar contenedores y volúmenes:

```bash
docker compose down -v
```

--- 

## 🌐 Acceso a la Aplicación Aplicación: 

API Base URL: [Open Application](http://localhost:8080) 
Swagger UI (documentación interactiva): [Swagger UI](http://localhost:8080/swagger-ui/index.html) 
OpenAPI JSON: [OpenAPI JSON](http://localhost:8080/v3/api-docs) 

--- 

## 📌 Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|------------|
| GET | /subscriptions | Listar todas las suscripciones |
| POST | /subscriptions | Crear nueva suscripción |
| GET | /subscriptions/{id} | Obtener suscripción por ID |
| PUT | /subscriptions/{id} | Actualizar suscripción |
| DELETE | /subscriptions/{id} | Eliminar suscripción |
| GET | /subscriptions/stats/total-monthly | Gasto mensual total |
| GET | /subscriptions/stats/active-monthly | Gasto mensual activo |

```powershell
Invoke-RestMethod -Method Post `
  -Uri "http://localhost:8080/subscriptions" `
  -ContentType "application/json" `
  -Body '{"name":"Netflix","monthlyCost":12.99,"category":"Streaming","active":true}'
```

Obtener todas las suscripciones: 

```powershell
Invoke-RestMethod -Method Get -Uri "http://localhost:8080/subscriptions" 
```

Obtener gasto mensual total:

```powershell
Invoke-RestMethod -Method Get -Uri "http://localhost:8080/subscriptions/stats/total-monthly" ---  
```

---

## 🔮 Próximas Mejoras

- [ ] Autenticación con JWT
- [ ] Sistema de usuarios
- [ ] Paginación y filtros avanzados
- [ ] Validaciones extendidas
- [ ] Tests automatizados (Unit & Integration)
- [ ] CI/CD
- [ ] Despliegue en la nube (AWS / Render / Railway)

---


## 👨‍💻 Autor 
Aarón Rodríguez Jiménez 
Febrero 2026

## Version: 0.1.0 (MVP)
