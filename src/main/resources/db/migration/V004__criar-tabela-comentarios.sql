create table comentarios (
	id int primary key auto_increment,
    ordem_servico_id int not null,
    descricao varchar(245) not null,
    data_envio datetime not null
);

alter table comentarios add constraint fk_comentario_ordem_servico
foreign key (ordem_servico_id) references ordem_servico(id);