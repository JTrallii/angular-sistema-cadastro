DROP TABLE IF EXISTS produtos;
CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT,
    produto VARCHAR(255) NOT NULL,
    codigo_barras VARCHAR(255) UNIQUE NOT NULL,
    fornecedor_id BIGINT,
    descricao TEXT NOT NULL,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    sku VARCHAR(255),
    preco_venda DECIMAL(10,2) NOT NULL,
    preco_custo DECIMAL(10,2) NOT NULL,
    qtd_estoque DOUBLE NOT NULL,
    qtd_minima_estoque DOUBLE NOT NULL,
    categoria_produto VARCHAR(255),
    material VARCHAR(255),
    unidade_dimensao VARCHAR(255),
    unidade_peso VARCHAR(255),
    unidade_volume VARCHAR(255),
    venda_id BIGINT,

    PRIMARY KEY (id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id),
    FOREIGN KEY (venda_id) REFERENCES vendas(id)
);




