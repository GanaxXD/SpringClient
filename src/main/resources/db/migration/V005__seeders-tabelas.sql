insert into clients (nome, telefone, email) values
	('Pedro Victor', '98 65883259', 'pedro@gmail.com'),
	('André Silva', '99 36589924', 'andre@gmail.com'),
	('Aline Mendes', '99 25896645', 'aline@gmail.com'),
	('Mayara Soares', '99 12557894', 'mayara@gmail.com'),
	('Silvia Martins', '99 87995632', 'silva@gmail.com'),
	('João Caros', '11 23698854', 'joao@gmail.com'),
	('Tulla Luana', '11 36589974', 'tulla@gmail.com'),
	('Guilherme Oliveira', '98 85326679', 'guilherme@gmail.com'),
	('Francinette Borges', '98 23698857', 'francinette@gmail.com'),
	('Júlios Andrade', '98 32588967', 'julios@gmail.com');

insert into ordem_servico (cliente_id, descricao, preco, status, data_abertura, data_finalizacao) values
	(1, 'compra de um notebook', 100.25, 'ABERTO', current_date, null),
	(2, 'compra de uma máquina de lavar', 102.55,'ABERTO', current_date, null),
	(3, 'devolução de um computador', 0.00,'ABERTO', current_date, null),
	(4, 'devolução da máquina de lavar', 0.00, 'ABERTO', current_date, null),
	(5, 'compra de um fone de ouvido', 79.98, 'ABERTO', current_date, null),
	(6, 'compra de uma caixa de som', 125.12, 'ABERTO', current_date, null),
	(7, 'compra de um fone de ouvido bluetooth', 98.55, 'ABERTO', current_date, null),
	(8, 'devolução de um smartphone', 58.98, 'ABERTO', current_date, null),
	(9, 'compra de uma cadeira de escritório', 255.98, 'ABERTO', current_date, null),
	(10, 'devolução de uma caixa de som', 0.00, 'ABERTO', current_date, null),
	(1, 'compra de uma caixa de som', 110.25, 'ABERTO', current_date, null),
	(5, 'compra de uma bateria portátio', 189.55, 'ABERTO', current_date, null),
	(9, 'compra de uma CPU', 180.00, 'ABERTO', current_date, null),
	(8, 'compra de uma CPU', 180.00, 'ABERTO', current_date, null);
	
	
insert into comentarios (ordem_servico_id, descricao, data_envio) values
	(2, 'Nenhuma peça defeituosa encontrada', current_date),
	(2, 'Nenhuma peça defeituosa encontrada', current_date),
	(3, 'Nenhuma peça defeituosa encontrada', current_date),
	(4, 'Não adequação do equipamento ao usuário', current_date),
	(5, 'sem nenhuma informação relevante', current_date),
	(6, 'sem o cabo de energia', current_date),
	(7, 'Nenhuma peça defeituosa encontrada', current_date),
	(8, 'Tela quebrada', current_date),
	(9, 'cadeira preta com couro do assento craquelado', current_date),
	(10, 'lado direito do auto-falante com defeito', current_date),
	(4, 'Nenhuma peça defeituosa encontrada', current_date),
	(5, 'cliente não forneceu endereço', current_date),
	(9, 'cliente não forneceu o endereço', current_date),
	(8, 'cliente pediu mais informações do item', current_date);