CREATE TABLE IF NOT EXISTS user_products_relations
(
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    product_id UUID NOT NULL
);