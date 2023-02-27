create table app_user
(
    firstname varchar(50) not null ,
    lastname  varchar(50) not null ,
    email     varchar(50) not null ,
    address   varchar(50),
    id        serial PRIMARY KEY
);

insert into app_user(firstname, lastname, email)
values ('milosz', 'jurewicz', 'mju@spyro-soft.com');
