package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Sesion;
import edu.unam.webbapp.consultorio.repository.SesionRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SesionServiceImpl implements SesionService {

  private final SesionRepositorio repo;

  @Override
  public List<Sesion> findAll() {
    return repo.findAll();
  }

  @Override
  public Sesion findById(Integer id) {
    return repo.findById(id).orElseThrow();
  }

  @Override
  public Sesion save(Sesion sesion) {
    return repo.save(sesion);
  }

  @Override
  public Sesion update(Integer id, Sesion sesion) {
    return null;
  }

  @Override
  public List<Sesion> findSesionByPacienteId(Integer id) {
    return repo.findSesionsByPacienteDni(id);
  }

  @Override
  public void deleteById(Integer id) {
    Sesion sesion = repo.findById(id).orElseThrow();
    sesion.setEliminado(true);
  }
}
