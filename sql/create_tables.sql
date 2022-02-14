create table if not exists categories
(
    id            bigserial
        primary key,
    category_name varchar(255)
);

alter table categories
    owner to postgres;

create table if not exists ingredients
(
    id              serial
        primary key,
    ingredient_name varchar(255)
);

alter table ingredients
    owner to postgres;

create table if not exists measurement_units
(
    id   serial
        primary key,
    unit varchar(255)
);

alter table measurement_units
    owner to postgres;

create table if not exists recipes
(
    id          bigserial
        primary key,
    recipe_name varchar(255)
);

alter table recipes
    owner to postgres;

create table if not exists images
(
    id         serial
        primary key,
    image_name varchar(255),
    recipe_id  bigint not null
        constraint fkpnl2bgsume2n6qwbamubsw42l
            references recipes
            on delete cascade
);

alter table images
    owner to postgres;

create table if not exists recipe_categories
(
    recipe_id   bigint not null
        constraint fk3w4m6a9qnpwjgknvss7amxhjd
            references recipes,
    category_id bigint not null
        constraint fkl4gklbf4tpxuk41fp77pgd28l
            references categories,
    primary key (category_id, recipe_id)
);

alter table recipe_categories
    owner to postgres;

create table if not exists recipe_steps
(
    id                  bigserial
        primary key,
    instruction         varchar(255),
    step_number         integer not null,
    recipe_id           bigint  not null
        constraint fkof4i3g3aiwgro5ykaf1j28iw1
            references recipes
            on delete cascade,
    measurement_qty     double precision,
    ingredient_id       bigint
        constraint fkslhufsle3b35fo0lhkh86yabd
            references ingredients
            on delete cascade,
    measurement_unit_id integer
        constraint fkkddbjl0qqt0bso32yw1908ob7
            references measurement_units
            on delete cascade
);

alter table recipe_steps
    owner to postgres;

create table if not exists roles
(
    id   serial
        primary key,
    name varchar(20)
);

alter table roles
    owner to postgres;

create table if not exists users
(
    id       bigserial
        primary key,
    email    varchar(50)
        constraint uk6dotkott2kjsp8vw4d0m25fb7
            unique,
    password varchar(120),
    username varchar(20)
        constraint ukr43af9ap4edm43mmtq01oddj6
            unique
);

alter table users
    owner to postgres;

create table if not exists user_roles
(
    user_id bigint  not null
        constraint fkhfh9dx7w3ubf1co1vdev94g3f
            references users,
    role_id integer not null
        constraint fkh8ciramu9cc9q3qcqiv4ue8a6
            references roles,
    primary key (user_id, role_id)
);

alter table user_roles
    owner to postgres;