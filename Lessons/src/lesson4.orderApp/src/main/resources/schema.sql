create table orders (
id integer not null auto_increment,
name varchar(255) not null,
price integer not null,
PRIMARY KEY (id)
);

CREATE TABLE CUSTOMER (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);