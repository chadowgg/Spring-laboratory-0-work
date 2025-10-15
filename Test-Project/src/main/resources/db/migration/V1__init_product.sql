CREATE TABLE product (
     id SERIAL PRIMARY KEY,
     product_name VARCHAR(255) NOT NULL,
     price INT NOT NULL,
     quantity_in_stock INT NOT NULL,
     category VARCHAR(50) NOT NULL,
     product_description TEXT
);

INSERT INTO product (product_name, price, quantity_in_stock, category, product_description) VALUES
    ('Laptop', 1500, 10, 'ELECTRONICS', 'High performance laptop'),
    ('Smartphone', 800, 25, 'ELECTRONICS', 'Latest model smartphone'),
    ('Headphones', 120, 50, 'ELECTRONICS', 'Noise cancelling headphones'),
    ('Keyboard', 60, 40, 'ELECTRONICS', 'Mechanical keyboard'),
    ('Mouse', 40, 60, 'ELECTRONICS', 'Wireless mouse'),
    ('T-shirt', 20, 100, 'CLOTHING', 'Cotton t-shirt'),
    ('Jeans', 50, 80, 'CLOTHING', 'Blue denim jeans'),
    ('Jacket', 100, 30, 'CLOTHING', 'Warm winter jacket'),
    ('Sneakers', 70, 45, 'CLOTHING', 'Comfortable sneakers'),
    ('Cap', 15, 90, 'CLOTHING', 'Baseball cap'),
    ('Apple', 2, 200, 'FOOD', 'Fresh red apple'),
    ('Banana', 1, 180, 'FOOD', 'Ripe banana'),
    ('Milk', 3, 150, 'FOOD', '1 liter milk pack'),
    ('Bread', 2, 100, 'FOOD', 'Whole grain bread'),
    ('Cheese', 5, 80, 'FOOD', 'Cheddar cheese 200g'),
    ('Notebook', 5, 120, 'OTHER', 'Spiral notebook A4'),
    ('Pen', 2, 250, 'OTHER', 'Blue ink pen'),
    ('Backpack', 45, 35, 'OTHER', 'Travel backpack 20L'),
    ('Water Bottle', 10, 60, 'OTHER', 'Reusable water bottle'),
    ('Sunglasses', 30, 40, 'OTHER', 'UV protection sunglasses');