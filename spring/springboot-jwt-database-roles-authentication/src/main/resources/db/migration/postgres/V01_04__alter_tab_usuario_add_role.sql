alter table tab_usuario add column role varchar(20);

insert into tab_usuario (nome, login, senha)
values ('USER','user','$2a$10$kxEKU62QjjB.IiLQsfed4Ow/IPgDfRljp4.JgUFZq3eMPV7QP9PEu');

insert into tab_usuario (nome, login, senha)
values ('MANAGER','manager','$2a$10$LIxlzEkZv9B5MxCylsPmEO7HIdjBAjO9B56aw3xsjysLx.Ftm0Y32');
