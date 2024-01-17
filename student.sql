CREATE DATABASE IF NOT EXISTS student;
USE student;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(70) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT NOT NULL
    );

Insert into students (id, first_name, last_name, birth_date, email, age)
Values(1, 'John', 'Doe', '2005-01-15', 'john.doe@example.com', 22),
      (2, 'Nick', 'Hanma', '2002-03-19', 'nick.Hanma@example.com', 24),
      (3, 'Tom', 'Brook', '2004-01-15', 'tom.doe@example.com', 21),
      (4, 'Luke', 'Tyson', '2001-01-15', 'luke.doe@example.com', 18);