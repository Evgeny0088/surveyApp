create table author_passed_surveys(
    author_id bigint not null references authors (id),
    survey_id bigint not null references surveys (id),
    constraint author_id_2_fk foreign key (author_id) references authors (id),
    constraint survey_id_2_fk foreign key (survey_id) references surveys (id),
    primary key (author_id, survey_id)
);