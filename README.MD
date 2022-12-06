Create docker instance for Postgres database

connect with user -> psql -U postgres
create the database -> CREATE DATABASE demodb
-> \l to list databses
-> connect to databse \c demodb
-> \d for tables
-> \d person
-> SELECT * FROM person

To have uuid functionality add to database -> CREATE EXTENSION "uuid-ossp";
SELECT uuid_generate_v4();

Github secrets for docker are required

WHen running the built docker image, we have to add env variables
DB_URL ->
While running the backend in containerlocally the url should be -> jdbc-url: jdbc:postgresql://host.docker.internal:5432/demodb
When setting the env in intelij and running it should be -> jdbc-url: jdbc:postgresql://localhost:5432/demodb
DB_PASSWORD -> 
DB_USERNAME -> 

