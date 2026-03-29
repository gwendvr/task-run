# Task Run API

> Projet de démonstration de Spring Boot et Java réalisé pour des étudiants.
Une API REST de gestion de tâches construite avec Spring Boot et déployée sur Render.

## 🛠 Stack technique

- Java 25
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

## 🚀 Fonctionnalités

- CRUD complet sur les tâches (créer, lire, modifier, supprimer)
- Base de données PostgreSQL persistante
- Batch automatique toutes les nuits qui marque les tâches expirées

## 📦 Endpoints

| Méthode | URL | Description |
|--------|-----|-------------|
| GET | /tasks | Récupère toutes les tâches |
| POST | /tasks | Crée une nouvelle tâche |
| PUT | /tasks/{id} | Modifie une tâche |
| DELETE | /tasks/{id} | Supprime une tâche |

## 📝 Exemple de requête
```json
POST /tasks
{
    "title": "Ma tâche",
    "description": "Description de la tâche",
    "statut": "EN_COURS",
    "dueDate": "2026-12-31"
}
```

## 🌐 Démo

API disponible à : [https://task-run.onrender.com](https://task-run.onrender.com/tasks)

## ▶️ Lancer en local
```bash
git clone https://github.com/tonnom/task-run.git
cd task-run
mvnw spring-boot:run
```
