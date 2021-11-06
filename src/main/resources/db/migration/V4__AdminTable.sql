
create table admins (
    id bigint not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    roles varchar(64) not null,
    active boolean not null,
    primary key (id)
);

insert into admins(id,username,password, roles, active) values(1,'admin1','$2a$12$4pxuqizNw1qp89z9e7TGU.7nMTo7kqJpZta6cYx/5y.ix/wooRw36', 'ADMIN', 1);
