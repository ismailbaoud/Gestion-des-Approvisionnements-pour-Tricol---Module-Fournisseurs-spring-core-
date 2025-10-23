-- Script d'initialisation de la base de données PostgreSQL pour Tricol

-- Créer l'utilisateur si il n'existe pas
DO
$$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_user WHERE usename = 'tricol_user') THEN
      CREATE USER tricol_user WITH PASSWORD 'tricol_pass123';
   END IF;
END
$$;

-- Créer la base de données si elle n'existe pas
SELECT 'CREATE DATABASE tricol_db OWNER tricol_user'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'tricol_db')\gexec

-- Donner tous les privilèges à l'utilisateur
GRANT ALL PRIVILEGES ON DATABASE tricol_db TO tricol_user;

-- Se connecter à la base tricol_db et donner les permissions sur le schéma public
\c tricol_db
GRANT ALL ON SCHEMA public TO tricol_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO tricol_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO tricol_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO tricol_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO tricol_user;

