CREATE TABLE tbl_delivery
(
    delivery_number      BIGINT(20) NOT NULL AUTO_INCREMENT,
    delivery_person_name VARCHAR(100) NULL,
    delivery_date        DATE NULL,
    delivery_status      VARCHAR(20) NOT NULL,
    order_number         BIGINT(20) NOT NULL,
    PRIMARY KEY (delivery_number)
);