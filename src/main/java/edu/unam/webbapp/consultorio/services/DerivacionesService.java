package edu.unam.webbapp.consultorio.services;

import edu.unam.webbapp.consultorio.model.Derivacion;

import java.util.List;

public interface DerivacionesService {

    List<Derivacion> findAll();

    Derivacion findById(Integer id);

    Derivacion save(Derivacion derivacion);

    void deleteById(Integer id);

}
