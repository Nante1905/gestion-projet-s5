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
    qte double precision,
    id_look int
);

insert into type(nom) values('type1');
insert into taille(ref) values('ref1');
insert into formule_fabrication(id_taille,id_type,id_matiere,qte) values (1,1,1,2);

alter table formule_fabrication add id_look int references look(id);


-- 09-01-24


alter table matiere add column pu numeric;

CREATE table historique_pu(
    id_matiere int REFERENCES matiere(id),
    date date,
    valeur NUMERIC
);

select t.nom type_nom, ta.ref taille, l.nom look, sum(ff.qte*m.pu) prix
from formule_fabrication ff
join look l on ff.id_look = l.id
join type t on t.id = ff.id_type
join taille ta on ta.id = ff.id_taille
join matiere m on m.id = ff.id_matiere
group by t.nom, ta.ref, l.nom;

alter table historique_pu add id int primary key;


--11-01-24

create table fournisseur(
    id serial PRIMARY KEY,
    nom VARCHAR(20)
);

create table achat_matiere(
    id_matiere int REFERENCES matiere(id),
    qte numeric,
    id_fournisseur int REFERENCES fournisseur(id),
    date_achat date
);

create table fabrication(
    id serial PRIMARY KEY,
    id_type int REFERENCES type(id),
    id_taille int references taille(id),
    id_look int references look(id),
    qte numeric,
    date_fabrication date
);

create table utilisation_matiere(
    id_matiere int REFERENCES matiere(id),
    qte numeric,
    date_utilisation date,
    id_fabrication int REFERENCES fabrication(id)
);


CREATE OR REPLACE VIEW v_stock_matiere AS 
SELECT id_matiere, SUM(qte) FROM (
   SELECT utilisation_matiere.id_matiere, utilisation_matiere.qte * (-1) AS qte FROM utilisation_matiere
   UNION ALL 
   SELECT achat_matiere.id_matiere, achat_matiere.qte FROM achat_matiere
) AS view GROUP BY id_matiere;