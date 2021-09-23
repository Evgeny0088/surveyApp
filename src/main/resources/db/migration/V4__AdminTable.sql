
create table admins (
    id bigint not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);

insert into admins(id,username,password) values(1,'admin1','LDxUVGAcoWOIdf4lU55w/A==');
