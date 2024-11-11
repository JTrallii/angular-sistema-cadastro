create table fornecedores(

    id bigint not null auto_increment,
    fornecedor varchar(100) not null,
    nome_fantasia varchar(100),
    email varchar(100) not null unique,
    cnpj varchar(6) not null unique,
    telefone varchar(100),
    celular varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);