
create table surveys (
    id bigint not null auto_increment,
    sname varchar(255) not null,
    description varchar(255),
    constraint unique_sname unique (sname),
    primary key (id)
);

create table questions(
    id bigint not null auto_increment,
    text varchar(255) not null,
    question_type varchar(255) not null,
    answer_options varchar(255),
    right_answers varchar(255) not null,
    survey_id bigint,
    constraint unique_text unique (text),
    primary key (id)
);

create table authors(
    id bigint not null auto_increment,
    authorname varchar(255),
    primary key (id)
);

create table answers(
    author_id bigint not null references authors (id),
    question_id bigint not null references questions (id),
    answer varchar(255) not null,
    constraint author_id_fk foreign key (author_id) references authors (id),
    constraint question_id_fk foreign key (question_id) references questions (id),
    primary key (author_id, question_id)
);

