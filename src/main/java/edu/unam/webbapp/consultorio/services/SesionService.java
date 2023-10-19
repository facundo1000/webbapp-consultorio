package edu.unam.webbapp.consultorio.services;

import edu.unam.webbapp.consultorio.model.Sesion;

import java.util.List;
import java.util.Optional;

public interface SesionService {

  List<Sesion> findAll();

  Sesion findById(Integer id);

  Sesion save(Sesion sesion);

  Sesion update(Integer id, Sesion sesion);

  List <Sesion> findSesionByPacienteId(Integer id);

  void deleteById(Integer id);
}
