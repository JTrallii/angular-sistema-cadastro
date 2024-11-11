CREATE TABLE vendas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_venda DATETIME NOT NULL,
    valor_total_venda DECIMAL(10, 2) NOT NULL,
    forma_pagamento VARCHAR(50),
    PRIMARY KEY (id)
);


