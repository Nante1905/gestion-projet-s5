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

-- 2024-01-16

create table temps_fabrication (
    idLook int references look(id),
    duree numeric,
    creation_date date default now()
);

create table nbr_min_emp (
    nbr int,
    creation_date date default now()
);

create table taux_horaire (
    taux numeric,
    creation_date date default now()
);

create table prix_vente (
    id_type int references type(id),
    id_taille int references taille(id),
    id_look int references look(id),
    prix numeric,
    creation_date date default now()
);

alter table taille add ordre int;

-- migration down
drop temps_fabrication;
drop nbr_min_emp;
drop taux_horaire;
drop prix_vente;

insert into temps_fabrication (idLook, duree) values (1, 1);

 create view v_cout_materiaux as SELECT t.id AS id_type,
    ta.id AS taille,
    l.id AS look,
    sum(ff.qte * m.pu::double precision) AS prix
   FROM formule_fabrication ff
     JOIN look l ON ff.id_look = l.id
     JOIN type t ON t.id = ff.id_type
     JOIN taille ta ON ta.id = ff.id_taille
     JOIN matiere m ON m.id = ff.id_matiere
  GROUP BY t.id, ta.id, l.id;

create view v_last_taux_horaire as SELECT taux_horaire.taux,
    taux_horaire.creation_date
   FROM taux_horaire
  WHERE taux_horaire.creation_date = ( SELECT max(taux_horaire.creation_date) AS max
           FROM taux_horaire);

create view v_last_nbr_min_emp as SELECT nbr_min_emp.nbr,
    nbr_min_emp.creation_date
   FROM nbr_min_emp
  WHERE nbr_min_emp.creation_date = ( SELECT max(nbr_min_emp.creation_date) AS max
           FROM nbr_min_emp);

create view v_last_tf as select tf.* 
from temps_fabrication tf 
join (select idLook, max(creation_date) creation_date from temps_fabrication tf GROUP BY idLook) ltf 
on tf.idlook=ltf.idlook and tf.creation_date=ltf.creation_date;

create view v_cout_materiaux_emp as 
select vcm.*, vcle.cout_par_emp 
from v_cout_materiaux vcm join v_cout_look_emp vcle on vcm.look = vcle.idlook;

-- v_cout_materiaux
 SELECT t.id AS id_type,
 t.nom nom_type,
    ta.id AS taille,
	ta.ref nom_taille,
    l.id AS look,
	l.nom nom_look,
    sum(ff.qte * m.pu::double precision) AS prix
   FROM formule_fabrication ff
     JOIN look l ON ff.id_look = l.id
     JOIN type t ON t.id = ff.id_type
     JOIN taille ta ON ta.id = ff.id_taille
     JOIN matiere m ON m.id = ff.id_matiere
  GROUP BY t.id, ta.id, l.id;

create view v_last_prix_vente as select pv.*
from prix_vente pv 
join (select pv.id_taille, pv.id_type, pv.id_look, max(pv.creation_date) creation_date from prix_vente pv group by pv.id_taille, pv.id_type, pv.id_look) lpv
on pv.id_taille=lpv.id_taille and pv.id_type=lpv.id_type and pv.id_look=lpv.id_look and pv.creation_date=lpv.creation_date;

-- fix: 17-01-24
create table emp_fabrication (
    id_taille int references taille(id),
    nbr int,
    date_creation date default now()
);

-- data test for emp_fabrication
insert into emp_fabrication (id_taille, nbr, date_creation) values (4, 1, '2023-12-04');
insert into emp_fabrication (id_taille, nbr, date_creation) values (5, 2, '2023-12-04');
insert into emp_fabrication (id_taille, nbr, date_creation) values (6, 4, '2023-12-04');
insert into emp_fabrication (id_taille, nbr, date_creation) values (7, 8, '2023-12-04');
insert into emp_fabrication (id_taille, nbr, date_creation) values (8, 16, '2023-12-04');

create view v_last_emp_fabrication as 
select * 
from emp_fabrication ef where ef.date_creation = (select max(date_creation) from emp_fabrication)

-- v_benefice
create or replace view v_benefice as select vcm.nom_type, vcm.nom_taille, vcm.nom_look, vlpv.prix prix_vente, (vcm.prix + vlef.nbr*vlth.taux*vltf.duree) prix_reviens, (vlpv.prix - (vcm.prix + vlef.nbr*vlth.taux*vltf.duree)) benefice
from v_cout_materiaux vcm
JOIN v_last_prix_vente vlpv on vcm.id_type=vlpv.id_type and vcm.taille=vlpv.id_taille and vcm.look=vlpv.id_look
join v_last_tf vltf on vcm.look = vltf.idlook
join v_last_emp_fabrication vlef on vcm.taille=vlef.id_taille
cross join v_last_taux_horaire vlth;

--23-01-24
create table Employe(
    id serial primary key,
    nom varchar(20),
    prenom varchar(15),
    date_embauche date
);

create table categorie_emp(
    id SERIAL PRIMARY key,
    nom varchar(10),
    annee_exp int,
    coef_salaire int
);
