Create docker instance for Postgres database

connect with user -> psql -U postgres
create the database -> CREATE DATABASE demodb
-> \l to list databses
-> connect to databse \c demodb
-> \d for tables
-> \d person

To have uuid functionality add to database -> CREATE EXTENSION "uuid-ossp";
Check if it works with SELECT uuid_generate_v4();

Setting up Github Secrets
Secret for Docker username & password -> DB_USERNAME & DB_PASSWORD
Secret for application.yml have to be in brackets -> APPLICATION_YML (should include datasource for db, resource server for jwt)
Secret for firebase_config.json have to be in brackets -> FIREBASE_CONFIG (download from firebase admin sdk)

app:
    datasource:
        jdbc-url: jdbc:postgresql://host.docker.internal:5432/demodb
        username: username
        password: Parola
        pool-size: 30

spring:
    security:
        oauth2:
            resourceserver:
                jwt:
                    issuer-uri: https://securetoken.google.com/<FirebaseProjectID>
                    jwk-set-uri: https://www.googleapis.com/robot/v1/metadata/jwk/securetoken@system.gserviceaccount.com

While running the backend in container locally the url should be -> jdbc-url: jdbc:postgresql://host.docker.internal:5432/demodb
When setting the env in intelij and running it should be -> jdbc-url: jdbc:postgresql://localhost:5432/demodb

