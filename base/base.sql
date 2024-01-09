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
    qte double precision,
    id_look int
);

insert into type(nom) values('type1');
insert into taille(ref) values('ref1');
insert into formule_fabrication(id_taille,id_type,id_matiere,qte) values (1,1,1,2);
//09-01-24


alter table matiere add column pu numeric;
CREATE table historique_pu(
    id_matiere int REFERENCES matiere(id),
    date date,
    valeur NUMERIC
);


create or replace view v_sac_prix as select type.nom,taille.nom,look.nom,sum(formule_fabrication.qte*matiere.pu) from formule_fabrication join type on
 formule_fabrication.id_type=type.id and matiere on formule_fabrication.id_matiere=matiere.id and look formule_fabrication.look=look.id 