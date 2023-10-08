package edu.unam.webbapp.consultorio.services.impl;

import edu.unam.webbapp.consultorio.model.Psicologo;
import edu.unam.webbapp.consultorio.repository.PsicologoRepository;
import edu.unam.webbapp.consultorio.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PsicologoServiceImpl implements PersonaService<Psicologo> {

  private final PsicologoRepository repo;

  @Override
  public List<Psicologo> findAll() {
    return repo.findAll();
  }

  @Override
  public Psicologo getById(Integer id) {
    return repo.findById(id).orElseThrow();
  }

  @Override
  public Psicologo save(Psicologo psicologo) {
    return repo.save(psicologo);
  }

  @Override
  public Psicologo update(Integer id, Psicologo psicologo) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {
    Psicologo psicologo;
    if (id > 0) {
      psicologo = repo.findById(id).orElseThrow();
      psicologo.setEliminado(true);
      repo.save(psicologo);
    }
  }
}
