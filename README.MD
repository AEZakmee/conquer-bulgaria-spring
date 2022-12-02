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

Add to github secrets the database connection wrapped in ""
app:
  datasource:
    jdbc-url: jdbc:postgresql://host.docker.internal:5432/demodb
    username: username 
    password: password
    pool-size: 30

While running locally the url should be ->     jdbc-url: jdbc:postgresql://host.docker.internal:5432/demodb
