create table app_user
(
    firstname varchar(50),
    lastname  varchar(50),
    email     varchar(50),
    id        serial PRIMARY KEY
);

insert into app_user(firstname, lastname, email)
values ('milosz', 'jurewicz', 'mju@spyro-soft.com');
