create table ordem_servico(
	id SERIAL not null primary key,
    cliente_id int not null,
    descricao text not null,
    preco decimal(10,2) not null,
    status varchar(20) not null,
    data_abertura date not null,
    data_finalizacao date
);

alter table ordem_servico add constraint fk_ordem_servico_cliente
foreign key (cliente_id) references clients(id);