package com.nante.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nante.app.crud.repository.GenericRepository;
import com.nante.app.model.FormuleFabrication;
import com.nante.app.model.views.VSacPrix;

public interface FormuleFabricationRepository extends GenericRepository<FormuleFabrication> {
    public List<FormuleFabrication> findByMatiere_Id(int id);

    @Query(value = "insert into formule_fabrication (id, id_taille, id_type, id_matiere, id_look, qte) values (default, ?1, ?2, ?3, ?4, ?5) returning id", nativeQuery = true)
    public int save(int idTaille, int idType, int idMatiere, int idLook, double qte);

    @Query(value = "select ff.*, l.nom from formule_fabrication ff join look l on ff.id_look=l.id where ff.id=?1", nativeQuery = true)
    public FormuleFabrication findWithLook(int ffId);

    @Query(value = "select * from v_sac_prix where prix between ?1 and ?2", nativeQuery = true)
    public List<VSacPrix> getSacPrix(double min, double max);
}
