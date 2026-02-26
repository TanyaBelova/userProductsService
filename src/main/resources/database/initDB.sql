CREATE TABLE IF NOT EXISTS products
(
    id UUID PRIMARY KEY ,
    name  text NOT NULL ,
    creation_date TIMESTAMPTZ NOT NULL ,
    active boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS user_products_relations
(
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    product_id UUID NOT NULL
);