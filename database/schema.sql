CREATE DATABASE game_project;

USE game_project;


CREATE TABLE players(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(100) NOT NULL,
                        wins INT DEFAULT 0,
                        losses INT DEFAULT 0,
                        draws INT DEFAULT 0,
                        score INT DEFAULT 0
);


INSERT INTO players
(username,password)
VALUES
    ('student1','12345'),
    ('student2','12345'),
    ('student3','12345'),
    ('student4','12345'),
    ('student5','12345');