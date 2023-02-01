-- config_omdb table creation

create table config_omdb
(
    id         int AUTO_INCREMENT PRIMARY KEY,
    type       varchar(100) NOT NULL,
    enable     BOOLEAN         default true,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);

-- user table creation

create table user
(
    id         int AUTO_INCREMENT PRIMARY KEY,
    username       varchar(100)    NOT NULL,
    password       varchar(100)    NOT NULL,
    created_at timestamp not null default now(),
    UNIQUE Key (username)
);

-- movie table creation

create table movie
(
    id         int AUTO_INCREMENT PRIMARY KEY,
    title       varchar(50) NOT NULL,
    year        varchar(4),
    released    varchar(50), -- not show on front
    genre       varchar(250),
    director    varchar(250), -- not show on front
    actors      varchar(255), -- not show on front
    language    varchar(255),  -- not show on front
    awards      varchar(255),
    imdb_rating  double,
    imdb_votes   int,
    imdb_Id      varchar(15) UNIQUE,
    box_office   int,
    image        longblob,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);

-- movie_rate table creation

create table movie_rate
(
    id         int AUTO_INCREMENT PRIMARY KEY,
    movie_id    int,
    user_id     int,
    rate     varchar(20),
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    CONSTRAINT fk_movie
    FOREIGN KEY (movie_id)
        REFERENCES movie(id),
    CONSTRAINT fk_user
    FOREIGN KEY (user_id)
        REFERENCES user(id)
);

