create table if not exists clients(
	id int not null auto_increment,
    nome varchar(200) not null,
    telefone varchar(200) not null,
    email varchar(200) not null,
    
    primary key (id)
);