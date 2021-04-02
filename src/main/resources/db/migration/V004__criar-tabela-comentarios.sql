create table comentarios (
	id SERIAL primary key,
    ordem_servico_id int not null,
    descricao varchar(245) not null,
    data_envio date not null
); 

alter table comentarios add constraint fk_comentario_ordem_servico
foreign key (ordem_servico_id) references ordem_servico(id);