# 📦 Tricol - Module Gestion des Fournisseurs

![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-blue.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring](https://img.shields.io/badge/Spring-6.1.18-green.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

## 📋 Description

Application web de gestion des fournisseurs pour Tricol, développée avec Spring Framework (sans Spring Boot). Ce module permet la gestion complète des fournisseurs : création, modification, suppression et consultation.

## 🚀 Fonctionnalités (Version v0)

- ✅ **Affichage de tous les fournisseurs** - Consultation de la liste complète des fournisseurs
- ✅ **Ajout d'un fournisseur** - Création d'une nouvelle fiche fournisseur
- ✅ **Modification d'un fournisseur** - Mise à jour des informations d'un fournisseur existant
- ✅ **Suppression d'un fournisseur** - Suppression définitive d'un fournisseur
- ✅ **Recherche par nom** - Recherche de fournisseurs par nom

## 🛠️ Technologies Utilisées

### Backend
- **Java 17** - Langage de programmation
- **Spring Framework 6.1.18** - Framework principal
  - Spring MVC - Pour l'architecture REST
  - Spring Data JPA - Pour la persistance des données
  - Spring ORM - Pour l'intégration Hibernate
- **Hibernate 6.5.2** - ORM (Object-Relational Mapping)
- **PostgreSQL 42.7.3** - Base de données relationnelle
- **HikariCP 5.1.0** - Pool de connexions
- **Jakarta Validation API** - Validation des données
- **Jackson** - Sérialisation/Désérialisation JSON

### Outils de Build et Déploiement
- **Maven 3.x** - Gestion des dépendances et build
- **Jetty 11.0.15** - Serveur d'application (développement)
- **Package WAR** - Format de déploiement

## 📁 Structure du Projet

```
src/
├── main/
│   ├── java/org/ismail/Tricol/
│   │   ├── controller/
│   │   │   └── FournisseurController.java      # Contrôleur REST
│   │   ├── model/
│   │   │   └── Fournisseur.java                # Entité JPA
│   │   ├── repository/
│   │   │   └── FournisseurRepository.java      # Interface JPA Repository
│   │   ├── service/
│   │   │   └── FournisseurService.java         # Logique métier
│   │   ├── ServletInitializer.java             # Configuration WAR
│   │   └── TricolApplication.java              # Classe principale
│   ├── resources/
│   │   └── application.properties              # Configuration application
│   └── webapp/WEB-INF/
│       ├── applicationContext.xml              # Configuration Spring
│       └── web.xml                             # Configuration Web
├── test/
│   └── java/org/ismail/Tricol/
│       └── TricolApplicationTests.java         # Tests unitaires
init-db.sql                                     # Script d'initialisation BDD
testEndPoints.http                              # Collection de tests API
```

## ⚙️ Prérequis

- **Java JDK 17** ou supérieur
- **Maven 3.6+**
- **PostgreSQL 12+**
- **Git**

## 🔧 Installation et Configuration

### 1. Cloner le Projet

```bash
git clone <repository-url>
cd Gestion-des-Approvisionnements-pour-Tricol---Module-Fournisseurs-spring-core-
git checkout v0
```

### 2. Configuration de la Base de Données

#### Créer la base de données PostgreSQL

```bash
# Se connecter à PostgreSQL
sudo -u postgres psql

# Exécuter le script d'initialisation
\i init-db.sql
```

Ou manuellement :

```sql
CREATE USER tricol_user WITH PASSWORD 'tricol_pass123';
CREATE DATABASE tricol_db OWNER tricol_user;
GRANT ALL PRIVILEGES ON DATABASE tricol_db TO tricol_user;
```

#### Configurer les paramètres de connexion

Modifier le fichier `src/main/resources/application.properties` si nécessaire :

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tricol_db
spring.datasource.username=tricol_user
spring.datasource.password=tricol_pass123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Compiler le Projet

```bash
# Nettoyer et compiler
mvn clean install

# Ou compiler sans les tests
mvn clean install -DskipTests
```

## 🚀 Démarrage de l'Application

### Mode Développement avec Jetty

```bash
# Démarrer sur le port 8080 (par défaut)
mvn jetty:run

# Démarrer sur un port personnalisé
mvn jetty:run -Djetty.http.port=9090
```

L'application sera accessible sur : `http://localhost:8080` (ou le port configuré)

### Déploiement en Production

```bash
# Générer le fichier WAR
mvn clean package

# Le fichier WAR sera généré dans : target/Tricol-0.0.1-SNAPSHOT.war
# Déployer sur Tomcat, Jetty ou tout autre serveur d'applications Java EE
```

## 📡 API REST - Endpoints

Base URL : `http://localhost:8080/api/v0`

### Fournisseurs

| Méthode | Endpoint | Description | Body |
|---------|----------|-------------|------|
| `GET` | `/fournisseurs` | Liste tous les fournisseurs | - |
| `GET` | `/fournisseurs/{id}` | Récupère un fournisseur par ID | - |
| `GET` | `/fournisseurs/nom/{nom}` | Recherche par nom | - |
| `POST` | `/fournisseurs` | Crée un nouveau fournisseur | JSON |
| `PUT` | `/fournisseurs/{id}` | Modifie un fournisseur existant | JSON |
| `DELETE` | `/fournisseurs/{id}` | Supprime un fournisseur | - |

### Exemples de Requêtes

#### Récupérer tous les fournisseurs
```http
GET http://localhost:8080/api/v0/fournisseurs
```

#### Créer un nouveau fournisseur
```http
POST http://localhost:8080/api/v0/fournisseurs
Content-Type: application/json

{
  "nom": "Alami",
  "prenom": "Hassan",
  "email": "hassan@example.com",
  "societe": "TechCorp",
  "adresse": "123 Rue Mohammed V",
  "contact": "Manager",
  "telephone": "0612345678",
  "ville": "Casablanca",
  "ice": "001234567890123"
}
```

#### Modifier un fournisseur
```http
PUT http://localhost:8080/api/v0/fournisseurs/1
Content-Type: application/json

{
  "nom": "Alami",
  "prenom": "Hassan",
  "email": "hassan.updated@example.com",
  "societe": "TechCorp SA",
  "adresse": "456 Rue Updated",
  "contact": "Director",
  "telephone": "0698765432",
  "ville": "Rabat",
  "ice": "009876543210987"
}
```

#### Supprimer un fournisseur
```http
DELETE http://localhost:8080/api/v0/fournisseurs/1
```

#### Rechercher par nom
```http
GET http://localhost:8080/api/v0/fournisseurs/nom/Alami
```

## 🧪 Tests

### Exécuter les Tests Unitaires

```bash
mvn test
```

### Tests Manuels des Endpoints

Utiliser le fichier `testEndPoints.http` avec un client REST (IntelliJ IDEA HTTP Client, VS Code REST Client, Postman, etc.)

## 📊 Modèle de Données

### Entité Fournisseur

| Champ | Type | Contraintes | Description |
|-------|------|-------------|-------------|
| `id` | Long | Primary Key, Auto-increment | Identifiant unique |
| `nom` | String | NOT NULL | Nom du fournisseur |
| `prenom` | String | NOT NULL | Prénom du contact |
| `email` | String | NOT NULL, Email | Email de contact |
| `societe` | String | NOT NULL | Nom de la société |
| `adresse` | String | NOT NULL | Adresse postale |
| `contact` | String | NOT NULL | Nom du contact |
| `telephone` | String | NOT NULL | Numéro de téléphone |
| `ville` | String | - | Ville |
| `ice` | String | - | Identifiant Commun de l'Entreprise |
| `version` | Integer | Optimistic Locking | Version pour la gestion concurrentielle |

## 🔒 Validation des Données

- **Email** : Format email valide requis
- **Champs obligatoires** : nom, prenom, email, societe, adresse, contact, telephone
- **Validation** : Effectuée côté serveur avec Jakarta Validation API

## 🐛 Dépannage

### Problème de connexion à la base de données

```
Vérifier que PostgreSQL est démarré :
sudo systemctl status postgresql

Vérifier les credentials dans application.properties
```

### Erreur de port déjà utilisé

```bash
# Changer le port Jetty
mvn jetty:run -Djetty.http.port=9090
```

### Erreur de compilation Maven

```bash
# Nettoyer le cache Maven
mvn clean
rm -rf ~/.m2/repository
mvn install
```

## 📝 Logs

Les logs de l'application sont disponibles dans :
- Console de sortie standard
- Fichiers générés : `jetty.log`, `jetty9090.log`

## 🗺️ Roadmap

### Version v0 (Actuelle)
- [x] CRUD complet des fournisseurs
- [x] API REST
- [x] Validation des données
- [x] Configuration Spring sans Spring Boot

### Versions Futures
- [ ] Authentification et autorisation
- [ ] Pagination et tri
- [ ] Recherche avancée
- [ ] Export des données (PDF, Excel)
- [ ] Interface utilisateur (Frontend)
- [ ] Documentation API avec Swagger/OpenAPI
- [ ] Tests d'intégration

## 👥 Auteur

**Ismail**
- Organisation : Tricol

## 📄 License

Ce projet est sous licence MIT - voir le fichier LICENSE pour plus de détails.

## 🤝 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Fork le projet
2. Créer une branche feature (`git checkout -b feature/AmazingFeature`)
3. Commit les changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

## 📞 Support

Pour toute question ou problème, veuillez ouvrir une issue sur le repository GitHub.

---

**Note** : Ce README correspond à la version v0 du projet, qui inclut les fonctionnalités de base de gestion des fournisseurs (affichage, ajout, modification, suppression).
