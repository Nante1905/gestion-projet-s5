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
insert into look(nom,ref) values ('nom1','ref1');
insert into matiere(nom,ref) values ('nom1','ref1');
insert into look_matiere(id_look,id_matiere) values (1,1);

create table type(
    id serial primary key,
    nom varchar(50)
);

create table taille(
    id serial primary key,
    ref varchar(50)
);

create table formule_fabrication(
    id serial primary key,
    id_taille int references taille(id),
    id_type int references type(id),
    id_matiere int references matiere(id),
    qte double precision
);

insert into type(nom) values('type1');
insert into taille(ref) values('ref1');
insert into formule_fabrication(id_taille,id_type,id_matiere,qte) values (1,1,1,2);