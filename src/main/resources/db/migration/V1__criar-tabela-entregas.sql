CREATE TABLE tbl_entregas(
    numero_entrega BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome_entregador VARCHAR(100) NULL,
    data_entrega DATE NULL,
    status_entrega VARCHAR(20) NOT NULL,
    numero_pedido BIGINT(20) NOT NULL,
    PRIMARY KEY (numero_entrega)
);