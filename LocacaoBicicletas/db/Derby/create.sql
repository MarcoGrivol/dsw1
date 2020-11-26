connect 'jdbc:derby:Login;create=true;user=root;password=root';

create table Usuario(
	cpf varchar(14) not null, 
	data_nascimento varchar(10),
	email varchar (26),
	login varchar(20) not null unique, 
	nome varchar (26) not null,
	senha varchar(64) not null, 
	sexo varchar (10),
	telefone varchar (15),
	papel varchar(10), 
	CONSTRAINT Usuario_PK PRIMARY KEY (cpf));

insert into Usuario(cpf, data_nascimento, email, login, nome, senha, sexo, telefone, papel) 
values ('111.111.111-11', '11/11/1111', 'aa@a.com', 'a1', 'Aaa Aaa', 'senha1', 'sexo1', 'tel1', 'ADMIN');

insert into Usuario(cpf, data_nascimento, email, login, nome, senha, sexo, telefone, papel) 
values ('222.222.222-22', '22/22/2222', 'bb@b.com', 'b1', 'Bbb Bbb', 'senha2', 'sexo2', 'tel2', 'USER');

disconnect;

quit;