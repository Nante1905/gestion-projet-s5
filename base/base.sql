create table look(
    id serial primary key,
    nom VARCHAR(100) not null,
    ref VARCHAR(100) unique
);

create table matiere(
    id serial primary key,
    nom VARCHAR(100) not null,
    ref VARCHAR(100) unique
);

create table look_matiere(
    id serial primary key,
    id_look int REFERENCES look(id),
    id_matiere int REFERENCES matiere(id)
);
