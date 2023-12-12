package com.nante.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.nante.app.crud.service.GenericService;
import com.nante.app.model.Look;
import com.nante.app.model.Matiere;

public class LookService extends GenericService<Look> {
    public List<Matiere> findMatieresOf(int id) throws NotFoundException {
        Look look = this.find(id);
        return look.getMatieres();
    }
}