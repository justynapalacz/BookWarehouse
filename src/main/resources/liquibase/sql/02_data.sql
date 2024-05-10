--liquibase formatted sql
--changeset Justyna Palacz:2
INSERT INTO employee (id, first_name, last_name, phone, email)VALUE(1,'Jan', 'Nowak', '698123456','jan@wp.pl');
INSERT INTO employee (id, first_name, last_name, phone, email)VALUE(2,'Anna', 'Kowalska', '696000111','akowalska@wp.pl');

INSERT INTO client(id, name, nip, city ,street ,post_code ,phone ,email)VALUE(1,'Biblioteka w Czestochowie', '7891231122','Czestochowa', 'al.nmp 24', '42-200', '698123456','biblioteka.czewa@gmail.com');
INSERT INTO client(id, name, nip, city ,street ,post_code ,phone ,email)VALUE(2,'Poczytaj mi', '9991112233','Czestochowa', 'al.nmp 28', '42-200', '667123456','poczytaj@wp.pl');
INSERT INTO client(id, name, nip, city ,street ,post_code ,phone ,email)VALUE(3,'Filia nr 1', '9567891425','Wroclaw', 'Studencka 1', '50-001', '122345667','filia1@wp.pl');

INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(1, 'Dziady', 'Adam Mickiewicz','9788378876274', 'Classics', 50.0, 22);
INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(2, 'Pan Tadeusz', 'Adam Mickiewicz','9788307033419', 'Classics', 45.5, 20);
INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(3, 'To', 'Stephen King','9788365781628', 'Crime Novel', 40.0, 28);
INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(4, '1984', 'George Orwell','9788367219617', 'Classics', 38.5, 22);
INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(5, 'Dzieci z Bullerbyn', 'Astrid Lindgren','9788310139764', 'Children', 25.0, 10 );
INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(6, 'Afryka Kazika', 'Łukasz Wierzbicki', '9788375517828','Children', 20.0, 2);
INSERT INTO book (id, title, author, isbn, category, price, total) VALUE(7, 'Genesis', 'Chris Carter','9788382304329', 'Crime Novel', 51.0, 21);

INSERT INTO summary(id, number, date, status, payment_type, amount, client_id, employee_id) VALUE(1, '1/2024', '2024-04-20', 'new','card', 277.0,1,1);
INSERT INTO summary(id, number, date, status, payment_type, amount, client_id, employee_id) VALUE(2, '2/2024', '2024-04-20', 'new','card', 529.5,3,2);

 INSERT INTO  book_order (id, summary_id, book_id, quantity) VALUE(1,1,1,4);
 INSERT INTO  book_order (id, summary_id, book_id, quantity) VALUE(2,1,4,2);
 INSERT INTO  book_order (id, summary_id, book_id, quantity) VALUE(3,2,2,5);
 INSERT INTO  book_order (id, summary_id, book_id, quantity) VALUE(4,2,3,5);
 INSERT INTO  book_order (id, summary_id, book_id, quantity) VALUE(5,2,7,2);