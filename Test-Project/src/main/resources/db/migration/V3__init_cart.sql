CREATE TABLE cart (
                      id SERIAL PRIMARY KEY,
                      customer_id BIGINT NOT NULL REFERENCES customer(id),
                      total_price NUMERIC(10,2) NOT NULL DEFAULT 0,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO cart (customer_id, total_price)
VALUES
    (1, 0.00),  -- Іван Петренко
    (2, 0.00),  -- Оксана Коваленко
    (3, 0.00),  -- Андрій Шевчук
    (4, 0.00),  -- Марія Гриценко
    (5, 0.00),  -- Володимир Сидоренко
    (6, 0.00),  -- Наталія Іванова
    (7, 0.00),  -- Олег Кравчук
    (8, 0.00),  -- Світлана Мороз
    (9, 0.00),  -- Денис Ткаченко
    (10, 0.00), -- Катерина Бондар
    (11, 0.00), -- Михайло Лисенко
    (12, 0.00); -- Юлія Ковтун