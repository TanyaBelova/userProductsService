CREATE TABLE IF NOT EXISTS products
(
    id UUID PRIMARY KEY ,
    name  text NOT NULL ,
    creation_date TIMESTAMPTZ NOT NULL ,
    active boolean NOT NULL
);