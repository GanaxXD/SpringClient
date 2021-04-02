create table if not exists clients(
	id SERIAL not null primary key,
    nome varchar(200) not null,
    telefone varchar(200) not null,
    email varchar(200) not null
);