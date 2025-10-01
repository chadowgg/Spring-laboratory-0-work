CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    delivery_address TEXT,
    date_registration TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO customer (full_name, phone_number, email, delivery_address)
VALUES
    ('Іван Петренко', '+380931112233', 'ivan.petrenko@example.com', 'Київ, вул. Хрещатик, 12'),
    ('Оксана Коваленко', '+380671234567', 'oksana.kovalenko@example.com', 'Львів, вул. Шевченка, 45'),
    ('Андрій Шевчук', '+380503456789', 'andriy.shevchuk@example.com', 'Одеса, вул. Дерибасівська, 1'),
    ('Марія Гриценко', '+380931234555', 'maria.grytsenko@example.com', 'Харків, просп. Науки, 100'),
    ('Володимир Сидоренко', '+380671112244', 'volodymyr.sydorenko@example.com', 'Дніпро, вул. Поля, 33'),
    ('Наталія Іванова', '+380503221144', 'nataliia.ivanova@example.com', 'Запоріжжя, вул. Соборна, 77'),
    ('Олег Кравчук', '+380931234666', 'oleh.kravchuk@example.com', 'Чернігів, вул. Рокосовського, 12'),
    ('Світлана Мороз', '+380671119988', 'svitlana.moroz@example.com', 'Полтава, вул. Європейська, 50'),
    ('Денис Ткаченко', '+380503457788', 'denys.tkachenko@example.com', 'Житомир, вул. Київська, 23'),
    ('Катерина Бондар', '+380931112299', 'kateryna.bondar@example.com', 'Вінниця, вул. Соборна, 9'),
    ('Михайло Лисенко', '+380671234999', 'mykhailo.lysenko@example.com', 'Черкаси, вул. Гагаріна, 5'),
    ('Юлія Ковтун', '+380503222555', 'yuliia.kovtun@example.com', 'Хмельницький, вул. Проскурівська, 17');
