create table entrega(

	id bigint not null auto_increment,
    cliente_id bigint not null,
    taxa decimal(10,2) not null,
    status varchar(20) not null,
    data_pedido datetime,
    
    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(60) not null,
    destinatario_numero varchar(60) not null,
    destinatario_complemento varchar(60) not null,
    destinatario_bairro varchar(60) not null,

	primary key (id)
);

alter table entrega add constraint fk_entrega_cliente
foreign key (cliente_id) references cliente(id)