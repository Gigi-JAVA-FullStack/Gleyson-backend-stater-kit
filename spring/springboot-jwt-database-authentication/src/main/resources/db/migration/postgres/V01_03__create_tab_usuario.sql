create table tab_usuario
(
    id            serial primary key,
    nome          varchar(50)      not null,
    login         varchar(20)      not null,
    senha         varchar(100)      not null,
);
