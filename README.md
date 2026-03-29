# Task Run API

> Ce projet a été créé à l'origine comme support de démonstration pour initier des étudiants aux concepts fondamentaux de Spring Boot et Java (architecture REST, JPA, batch scheduling). 
> Suite à cette démonstration, le projet a été enrichi avec des fonctionnalités plus avancées afin de continuer à progresser et d'approfondir les bonnes pratiques du développement backend : structuration en packages, workflow Git professionnel (feature branches, pull requests), gamification, et déploiement cloud.

## 🛠 Stack technique

- Java 25
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

## 🚀 Fonctionnalités

- CRUD complet sur les tâches
- Tags libres et système de priorité (BASSE, MOYENNE, HAUTE)
- Gamification : XP, niveaux, badges et streak journalier
- Batch automatique toutes les nuits qui marque les tâches expirées
- Base de données PostgreSQL persistante

## 📦 Endpoints

| Méthode | URL | Description |
|--------|-----|-------------|
| GET | /tasks | Récupère toutes les tâches |
| POST | /tasks | Crée une nouvelle tâche |
| PUT | /tasks/{id} | Modifie une tâche |
| DELETE | /tasks/{id} | Supprime une tâche |
| GET | /tags | Récupère tous les tags |
| POST | /tags | Crée un tag |
| GET | /badges | Récupère tous les badges |
| POST | /badges | Crée un badge |
| GET | /utilisateurs | Récupère tous les utilisateurs |
| POST | /utilisateurs | Crée un utilisateur |
| POST | /utilisateurs/{id}/xp | Ajoute des XP à un utilisateur |

## 📝 Exemple de requête
```json
POST /tasks
{
    "title": "Ma tâche",
    "description": "Description",
    "statut": "EN_COURS",
    "dueDate": "2026-12-31",
    "priorite": "HAUTE"
}
```

## 🌐 Démo

API disponible à : https://task-run.onrender.com

## ▶️ Lancer en local
```bash
git clone https://github.com/tonnom/task-run.git
cd task-run
mvnw spring-boot:run -Dspring-boot.run.profiles=local
```
