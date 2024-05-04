--liquibase formatted sql
--changeset Justyna Palacz:1
CREATE TABLE IF NOT EXISTS employee (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR (100),
  last_name VARCHAR(100),
  phone VARCHAR(100),
  email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS client (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (500),
  nip VARCHAR (500),
  city VARCHAR(100),
  street VARCHAR(100),
  post_code VARCHAR(100),
  phone VARCHAR(100),
  email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS book (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR (100),
  author VARCHAR(100),
  isbn VARCHAR(100),
  category VARCHAR(100),
  price double,
  total int
);

CREATE TABLE IF NOT EXISTS summary (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  number VARCHAR(100),
  date DATE NOT NULL,
  status VARCHAR(100),
  payment_type VARCHAR(100),
  amount double,
  client_id INT UNSIGNED ,
  employee_id INT UNSIGNED,
  FOREIGN KEY (client_id) REFERENCES client(id),
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE IF NOT EXISTS book_order (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  summary_id INT UNSIGNED,
  book_id INT UNSIGNED ,
  quantity INT UNSIGNED,
  FOREIGN KEY (book_id) REFERENCES book(id),
  FOREIGN KEY (summary_id) REFERENCES summary(id)
);