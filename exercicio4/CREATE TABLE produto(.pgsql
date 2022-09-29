CREATE TABLE produto(
    id serial PRIMARY KEY,
    nome VARCHAR(50),
    quantidade INTEGER

);

INSERT INTO produto (id, nome, quantidade) VALUES (1, 'pneu', 150);
INSERT INTO produto (id, nome, quantidade) VALUES (2, 'roda', 250);

select * from produto
