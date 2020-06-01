create database bingo;
use bingo;
create table juegos(
	pk varchar(50),
    fecha date,
    carton varchar(250),
    bombo longtext,
    persona varchar(150),
    constraint pk_juegos primary key (pk)
); 
