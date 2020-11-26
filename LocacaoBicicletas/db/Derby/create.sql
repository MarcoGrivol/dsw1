connect 'jdbc:derby:Login;create=true;user=root;password=root';

create table Usuario(id bigint not null generated always as identity, papel varchar(10), senha varchar(64) not null, login varchar(20) not null unique, CONSTRAINT Usuario_PK PRIMARY KEY (id));

insert into Usuario(papel, senha, login) values ('ADMIN', 'admin', 'admin');

insert into Usuario(papel, senha, login) values ('USER', 'user', 'user');

disconnect;

quit;