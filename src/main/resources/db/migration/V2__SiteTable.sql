CREATE TABLE sites (
    id UUID NOT NULL PRIMARY KEY,
    number VARCHAR(100) NOT NULL,
    lat FLOAT NOT NULL,
    lng FLOAT NOT NULL,
    description TEXT NOT NULL,
    name VARCHAR(100) NOT NULL,
    town VARCHAR(100) NOT NULL,
    ratingCount INT NOT NULL,
    ratingTotal INT NOT NULL
);