create table usr
(
    id             varchar(255) not null
        constraint usr_pkey
            primary key,
    email          varchar(255),
    email_verified boolean      not null,
    first_name     varchar(255),
    gender         varchar(255),
    google_id      varchar(255) not null,
    last_name      varchar(255),
    last_visit     timestamp    not null,
    user_name      varchar(255) not null
);
