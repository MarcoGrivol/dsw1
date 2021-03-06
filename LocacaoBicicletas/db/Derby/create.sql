connect 'jdbc:derby:Login;create=true;user=root;password=root';

create table Usuario(
	cpf varchar(20) not null, 
	dataNascimento varchar(10) not null,
	email varchar (26) not null,
	login varchar(20) not null unique, 
	nome varchar (26) not null,
	senha varchar(64) not null, 
	sexo varchar (10) not null,
	telefone varchar (15) not null,
	papel varchar(10) not null, 
	CONSTRAINT Usuario_PK PRIMARY KEY (cpf));

create table Locadora(
	cnpj varchar (30) not null, 
	email varchar (26) not null, 
	nome varchar (26) not null,
	senha varchar(64) not null,
	cidade varchar(26) not null,
	papel varchar(26) not null,
	CONSTRAINT Locadora_PK PRIMARY KEY (cnpj));

create table Locacao(
	cnpj varchar (30),
	cpf varchar(20) not null, 
	data_locacao varchar(10) not null,
	hora varchar(4) not null,
	primary key (cpf, cnpj, data_locacao, hora),
	CONSTRAINT FK_CPF FOREIGN KEY (cpf) REFERENCES Usuario(cpf),
	FOREIGN KEY (cnpj) references Locadora(cnpj)
);

insert into Usuario(cpf, dataNascimento, email, login, nome, senha, sexo, telefone, papel) 
values ('111.111.111-11', '11/11/1111', 'aa@a.com', 'a1', 'Aaa Aaa', 'senha1', 'sexo1', 'tel1', 'ADMIN');

insert into Usuario(cpf, dataNascimento, email, login, nome, senha, sexo, telefone, papel) 
values ('222.222.222-22', '22/22/2222', 'bb@b.com', 'b2', 'Bbb Bbb', 'senha2', 'sexo2', 'tel2', 'USER');

insert into Usuario(cpf, dataNascimento, email, login, nome, senha, sexo, telefone, papel) 
values ('333.333.333-33', '33/33/3333', 'cc@c.com', 'c3', 'Ccc Ccc', 'senha3', 'sexo3', 'tel3', 'USER');

insert into Locadora(cnpj, email, nome, senha, cidade,papel) 
values ('44.444.444/0001-44', 'dd@d.com', 'Ddd Ddd', 'senha4','Sao carlos','USER');

insert into Locadora(cnpj, email, nome, senha, cidade,papel) 
values ('55.555.555/0001-55', 'ee@e.com', 'Eee Eee', 'senha5','Sao Paulo','USER');

insert into Locacao (cpf, cnpj, data_locacao, hora)
values ('222.222.222-22', '44.444.444/0001-44', '2020-01-01', '18');

insert into Locacao (cpf, cnpj, data_locacao, hora)
values ('222.222.222-22', '44.444.444/0001-44', '2020-01-01', '15');

insert into Locacao (cpf, cnpj, data_locacao, hora)
values ('222.222.222-22', '55.555.555/0001-55', '2020-01-02', '2');




disconnect;

quit;