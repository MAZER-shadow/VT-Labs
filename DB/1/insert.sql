INSERT INTO cake (weight, name)
VALUES (50, 'medovik'),
       (60, 'napoleon'),
       (70, 'vkysnyi'),
       (55, 'шоколадный'),
       (65, 'клубничный'),
       (75, 'ванильный'),
       (80, 'карамельный'),
       (45, 'лимонный');

INSERT INTO worker (name, post, number_phone, salary)
VALUES ('gosha', 'director', '+79115553322', 500),
       ('Мария', 'пекарь', '+79115553323', 400),
       ('Алексей', 'курьер', '+79115553324', 300),
       ('Ольга', 'менеджер', '+79115553325', 450),
       ('Дмитрий', 'пекарь', '+79115553326', 400),
       ('Елена', 'курьер', '+79115553327', 300);

INSERT INTO client (phone_humber, name)
VALUES ('+79115473959', 'Девятых Павел Леонидович'),
       ('+79115473960', 'Иванов Иван Иванович'),
       ('+79115473961', 'Петров Петр Петрович'),
       ('+79115473962', 'Сидорова Анна Владимировна'),
       ('+79115473963', 'Кузнецов Дмитрий Сергеевич'),
       ('+79115473964', 'Морозова Екатерина Алексеевна');

INSERT INTO orders (phone_number, cost)
VALUES ('+79115473959', 399),
       ('+79115473960', 450),
       ('+79115473961', 500),
       ('+79115473962', 600),
       ('+79115473963', 350),
       ('+79115473964', 400),
       ('+79115473959', 499);

INSERT INTO delivery (date, location, id_order)
VALUES ('2024-10-10', '5 kvartira', 1),
       ('2024-10-11', '10 квартира', 2),
       ('2024-10-12', '15 квартира', 3),
       ('2024-10-13', '20 квартира', 4),
       ('2024-10-14', '25 квартира', 5),
       ('2024-10-15', '30 квартира', 6);

INSERT INTO orders_cake (orders_id, cake_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (4, 1),
       (5, 2),
       (6, 3),
       (7, 2);

INSERT INTO orders_worker (orders_id, worker_id)
VALUES (1, 2),
       (2, 2),
       (3, 5),
       (4, 5),
       (5, 2),
       (6, 5),
       (7, 2);