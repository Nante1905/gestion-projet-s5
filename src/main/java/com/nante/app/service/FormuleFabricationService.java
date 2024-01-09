package com.nante.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nante.app.crud.service.GenericService;
import com.nante.app.model.FormuleFabrication;
import com.nante.app.repository.FormuleFabricationRepository;

@Service
public class FormuleFabricationService extends GenericService<FormuleFabrication> {

    @Autowired
    private FormuleFabricationRepository repo;

    // public FormuleFabrication save(FormuleFabrication f) {
    // this.repo.save(f.getTaille().getId(), f.getType().getId(),
    // f.getMatiere().getId(), f.getLook().getId(),
    // f.getQte());
    // return null;
    // }

    public List<FormuleFabrication> findByIdMatiere(int id) {
        return repo.findByMatiere_Id(id);
    }

    public FormuleFabrication findWithLook(int ffId) {
        return this.repo.findWithLook(ffId);
    }
}
