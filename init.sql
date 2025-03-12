CREATE TABLE cookies (
    cookie_id SERIAL PRIMARY KEY,
    title VARCHAR(25) NOT NULL CHECK (LENGTH(title) >= 3 AND LENGTH(title) <= 25)
);
CREATE TABLE sellers (
    seller_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL
);
CREATE TABLE store (
    store_id SERIAL PRIMARY KEY,
    cookie_id INTEGER REFERENCES cookies(cookie_id),
    seller_id INTEGER REFERENCES sellers(seller_id),
    price INTEGER NOT NULL,
    weight INTEGER NOT NULL,
    date DATE NOT NULL,
    created_time TIMESTAMP NOT NULL
);
CREATE TABLE cookie_orders (
    cookie_order_id SERIAL PRIMARY KEY,
    store_id INTEGER REFERENCES store(store_id),
    weight INTEGER NOT NULL
);