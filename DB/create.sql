CREATE TABLE cake
(
    id     SERIAL PRIMARY KEY,
    weight INT,
    name   TEXT NOT NULL
);

CREATE TABLE client
(
    phone_humber TEXT PRIMARY KEY,
    name         TEXT
);

CREATE TABLE orders
(
    id           SERIAL PRIMARY KEY,
    phone_number TEXT NOT NULL,
    cost         INT CHECK (cost > 0),
    FOREIGN KEY (phone_number) references client (phone_humber)
);

CREATE TABLE delivery
(
    id       SERIAL PRIMARY KEY,
    date     DATE,
    location TEXT NOT NULL,
    id_order INT,
    FOREIGN KEY (id_order) references orders (id)
);

CREATE TABLE worker
(
    id           SERIAL PRIMARY KEY,
    name         TEXT,
    post         TEXT,
    number_phone TEXT UNIQUE,
    salary       INT
);

CREATE TABLE orders_cake
(
    orders_id INT,
    cake_id  INT,
    PRIMARY KEY (orders_id, cake_id),
    FOREIGN KEY (orders_id) references orders(id),
    FOREIGN KEY (cake_id) references cake(id)
);

CREATE TABLE orders_worker
(
    orders_id  INT,
    worker_id INT,
    PRIMARY KEY (orders_id, worker_id),
    FOREIGN KEY (orders_id) references orders(id),
    FOREIGN KEY (worker_id) references worker(id)
);
