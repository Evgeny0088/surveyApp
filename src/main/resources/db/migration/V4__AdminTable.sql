
create table admins (
    id bigint not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    roles varchar(64) not null,
    primary key (id)
);

insert into admins(id,username,password, roles) values(1,'admin1',' $2a$12$t2uDrekvkCh2EVgjJBsBju9eKtwRdeU9w/CLUcEIL0wRIawqa6bbq', 'ADMIN');
