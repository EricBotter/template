CREATE TABLE IF NOT EXISTS Course (
       id            INTEGER PRIMARY KEY,
       name          VARCHAR(255) NOT NULL,
       description   VARCHAR(255),
       location      VARCHAR(255) NOT NULL,
       totalSeats    NUMERIC NOT NULL,
       start     DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS Student (
       id            INTEGER PRIMARY KEY,
       name          VARCHAR(255) NOT NULL,
       surname       VARCHAR(255) NOT NULL
);


