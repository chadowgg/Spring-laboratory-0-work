CREATE TABLE cart_item (
                           id BIGSERIAL PRIMARY KEY,
                           cart_id BIGINT NOT NULL REFERENCES cart(id) ON DELETE CASCADE,
                           product_id BIGINT NOT NULL REFERENCES product(id),
                           quantity INT NOT NULL CHECK (quantity > 0)
);