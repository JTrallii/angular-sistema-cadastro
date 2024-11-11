CREATE TABLE itens_venda (
    id BIGINT NOT NULL AUTO_INCREMENT,
    venda_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade DOUBLE NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    preco_total DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (venda_id) REFERENCES vendas(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);



