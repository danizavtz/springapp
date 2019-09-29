CREATE TABLE category (
    id integer primary key auto_increment,
    nome varchar(255) not null
);

CREATE TABLE product (
    id integer primary key auto_increment,
    nome varchar(255) not null,
    valor integer not null,
    category_id integer,
    foreign key(category_id) references category(id));