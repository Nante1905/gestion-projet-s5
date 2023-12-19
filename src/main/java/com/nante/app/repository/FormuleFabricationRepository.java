package com.nante.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nante.app.crud.repository.GenericRepository;
import com.nante.app.model.FormuleFabrication;

public interface FormuleFabricationRepository extends GenericRepository<FormuleFabrication> {
    public List<FormuleFabrication> findByMatiere_Id(int id);

    @Query(value = "insert into formule_fabrication (id, id_taille, id_type, id_matiere, id_look, qte) values (default, ?1, ?2, ?3, ?4, ?5) returning id", nativeQuery = true)
    public int save(int idTaille, int idType, int idMatiere, int idLook, double qte);
}
