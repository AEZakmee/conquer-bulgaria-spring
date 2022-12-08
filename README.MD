Create docker instance for Postgres database

connect with user -> psql -U postgres
create the database -> CREATE DATABASE demodb
-> \l to list databses
-> connect to databse \c demodb
-> \d for tables
-> \d sometable

To have uuid functionality add to database -> CREATE EXTENSION "uuid-ossp";
Check if it works with SELECT uuid_generate_v4();

Setting up GitHub Secrets
Secret for Docker username & password -> DOCKER_USERNAME & DOCKER_PASSWORD
Secret for Database username & password -> DB_USERNAME & DB_PASSWORD
Secret for Database url -> DB_URL
Secret for firebase project ID -> FIREBASE_ID
Secret for firebase_config.json (have to be in base64 format) -> FIREBASE_CONFIG (download from firebase admin sdk)

jdbc-url: jdbc:postgresql://host.docker.internal:5432/demodb
jdbc-url: jdbc:postgresql://localhost:5432/demodb

